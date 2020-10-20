public class DameSpiel extends MiniJava {

    private int nrRows, nrColumns; // Board dimensions
    private boolean[][] board;     // true = queen, false = empty
    private boolean whiteToMove;   // Whose turn it is
    private String white, black;   // Players' names

    //TODO Mehr Attribute?
    private boolean[][] freieFelder;
    private int gameover = 0;

    //TODO Weitere Methoden?
    /*
     * ueberprueft, ob die eingegebene Zahl einem Feld zugeordnet werden kann
     */
    private boolean gueltigeEingabe(int move) {
    	for(int i = nrRows; i > 0; --i) {
    		for(int j = nrColumns; j > 0; --j) {
    			if(move == 10*i + j) {
    				return true;
    			}
    		}
    	}
    	return false;
    }

    /*
     * entscheidet, ob der Zug durchfuehrbar ist
     */
    private boolean gueltigerZug(int move) {
    	int y = move % 10;
    	int x = (move - y) / 10;
    	
    	if(freieFelder[x - 1][y - 1] == true) {
    		return false;
    	}
    	return true;
    }
    
    /*
     * zaehlt die Anzahl an Feldern, auf denen noch eine Dame platziert werden kann
     */
    private int countMoves() {
    	int count = 0;
    	for(int i = 0; i < freieFelder.length; i++) {
    		for(int j = 0; j < freieFelder[i].length; j++) {
    			if(freieFelder[i][j] == false) {
    				count++;
    			}
    		}
    	}
    	return count;
    }

    
    /**
     * Der Konstruktor registriert Spielernamen fuer Weiss und Schwarz.
     *
     * @param white Name des als 'Weiss' bezeichneten Spielers
     * @param black Name des als 'Schwarz' bezeichneten Spielers
     */
    public DameSpiel(String white, String black){
        //TODO
    	this.white = white;
    	this.black = black;
    }

    /**
     * Gibt das Spielbrett aus.
     */
    private void printBoard(){
        for (int j = board[0].length - 1; j >= 0; j--) {
            System.out.print("\n " + (1 + j));
            for (int i = 0; i < board.length; i++) {
                System.out.print(board[i][j] ? " X" : " -");
            }
        }
        System.out.print("\n  ");
        for (int i = 1; i <= board.length; i++) {
            System.out.print(" " + i);
        }
        System.out.println("\n" + (whiteToMove ? white : black) + " ist am Zug.");
    }

    /**
     * Initialisiert das Spielbrett ueberall mit false.
     * Dazu wird (ggf. neuer) Speicher allokiert.
     */
    private void initBoard(){
        //TODO
    	board = new boolean[nrRows][nrColumns];
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j < board[i].length; j++) {
    			board[i][j] = false;
    		}
    	}
    	// Initialisierung eines zweiten Feldes, welches die moeglichen Positionen fuer neue Damen speichert
    	freieFelder = new boolean[nrRows][nrColumns];
    	for(int i = 0; i < freieFelder.length; i++) {
    		for(int j = 0; j < freieFelder[i].length; j++) {
    			freieFelder[i][j] = false;
    		}
    	}
    }

    /**
     * Ermittelt die Groesse des Spielbretts gemaess den Spielregeln.
     * Das Ergebnis der Abfrage wird in den Attributen nrRows und nrColumns abgelegt.
     */
    private void determineBoardSize(){
        //TODO
    	while(nrRows < 5 || nrRows > 8) {
    		nrRows = read(white + ", bitte waehle eine Zahl aus der Menge {5, 6, 7, 8} fuer die Breite des Spielfeldes.");
    	}
    	while(nrColumns < nrRows - 1 || nrColumns > nrRows + 1) {
    		nrColumns = read(black + ", bitte waehle eine Zahl aus dem Bereich {" + (nrRows - 1) + ", " + nrRows + ", " + (nrRows + 1) + "} fuer die Laenge des Spielfeldes.");
    	}
    }

    /**
     * Ermittelt, wer anfaengt zu ziehen.
     * Das Ergebnis der Abfrage wird im Attribut whiteToMove abgelegt.
     */
    private void determineFirstPlayer(){
        //TODO
    	int x = -1;
    	while(x < 0 || x > 1) {
    		x = read(white + ", moechtest du beginnen (0), oder soll " + black + " anfangen, zu ziehen (1)?");
    	}
    	if(x == 0) {
    		whiteToMove = true;
    	} else {
    		whiteToMove = false;
    	}
    }

    /**
     * Fuehrt den Zug aus.
     *
     * @param move der auszufuehrende Zug!
     */
    private void applyMove(int move){
        //TODO
    	int y = move % 10;
    	int x = (move - y) / 10;
    	board[x - 1][y - 1] = true;
    	// Sperrung der Felder in freieFelder
    	// Reihe sperren
    	for(int i = 0; i < nrRows; i++) {
        	freieFelder[i][y - 1] = true;
    	}
    	// Spalte sperren
    	for(int j = 0; j < nrColumns; j++) {
    		freieFelder[x - 1][j] = true;
    	}
    	int posx = move / 10;
    	int posy = move % 10;
    	while(posx != 1 && posy != 1) {
    		posx--;
    		posy--;
    	}
    	// Diagonale nach rechts oben sperren
    	while(posx <= nrRows && posy <= nrColumns) {
        	freieFelder[posx - 1][posy - 1] = true;
        	posx++;
        	posy++;
    	}
    	// Zuruecksetzen der Variablen
    	posx = move / 10;
    	posy = move % 10;
    	while(posx != nrRows && posy != 1) {
        	posx++;
        	posy--;
    	}
    	// Diagonale nach rechts unten sperren
    	while(posx >= 1 && posy <= nrColumns) {
    		freieFelder[posx - 1][posy - 1] = true;
    		posx--;
    		posy++;
    	}
    }

    /**
     * Startet die Hauptschleife des Spiels
     * mit der Abfrage nach Zuegen.
     * Die Schleife wird durch Eingabe von -1 beendet.
     */
    private void mainLoop(){
        //TODO
    	int x = countMoves();
    	while(x != 0) {
    		System.out.println("Es gibt " + countMoves() + " moegliche Position(en) fuer die naechste Dame.");
    		int feld = -1;
    		boolean gueltig = false;
        	while(gueltig == false) {
        		if(whiteToMove == true) {
        			feld = read(white + ", auf welches Feld moechtest du eine Dame setzen?\nErinnerung: 1. Stelle: Breite, 2.Stelle: Laenge\nZum Aufgeben gebe -1 ein.");
        		} else {
        			feld = read(black + ", auf welches Feld moechtest du eine Dame setzen?\nErinnerung: 1. Stelle: Breite, 2.Stelle: Laenge\nZum Aufgeben gebe -1 ein.");
        		}
        		if(feld == -1) {
        			gameover = 1;
        			return;
        		}
        		if(gueltigeEingabe(feld) == true && gueltigerZug(feld) == true) {
        			gueltig = true;
        		}
        	}
        	applyMove(feld);
        	whiteToMove = !whiteToMove;
        	printBoard();
        	x = countMoves();
    	}
    }

    /**
     * Informiert die Benutzerin ueber den Ausgang des Spiels.
     * Speziell: Wer hat gewonnen (Weiss oder Schwarz)?
     */
    private void reportWinner(){
        //TODO
    	if(gameover == 1) {
    		if(whiteToMove == true) {
    			System.out.println(white + " hat aufgebeben. Es gewinnt " + black + ".");
    			return;
    		} else {
    			System.out.println(black + " hat aufgebeben. Es gewinnt " + white + ".");
    			return;
    		}
    	}
    	if(whiteToMove == true) {
        	System.out.println("Es gibt keine freie Position mehr auf dem Spielfeld. Da der letzte Zug von " + black + " durchgefuehrt wurde, hat diese gewonnen.");
    	} else {
    		System.out.println("Es gibt keine freie Position mehr auf dem Spielfeld. Da der letzte Zug von " + white + " durchgefuehrt wurde, hat diese gewonnen.");
    	}
    }

    /**
     * Startet das Spiel.
     */
    public void startGame(){
        determineBoardSize();
        initBoard();
        determineFirstPlayer();
        printBoard();
        mainLoop();
        reportWinner();
    }
    
    public static void main(String[] args) {
        DameSpiel ds = new DameSpiel("Weiß", "Schwarz");
        ds.startGame();
    }
}