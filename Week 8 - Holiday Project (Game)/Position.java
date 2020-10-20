/**
 * Die Klasse Position repraesentiert eine Spielsituation.
 *
 */
public class Position {

    /**
     * Die Tiere werden intern in einem Array gespeichert.
     * nrAnimals gibt an, wie viele Tiere auf dem Brett sind.
     * Diese sind in myAnimals an den Positionen 0 bis nrAnimals-1 enthalten.
     *
     * Es ist empfohlen, aber nicht vorgeschrieben, diese Attribute zu verwenden.
     *
     * Falls die beiden Attribute NICHT verwendet werden, muss die Ausgabe
     * der Spielposition unten entsprechend auf die verwendete Datenstruktur
     * angepasst werden. Die toString-Methode darf dabei nicht veraendert werden,
     * muss jedoch die selbe Rueckgabe liefern. D.h. es ist dann notwendig,
     * die Hilfsmethode boardRepresentation auf die verwendete Datenstruktur anzupassen.
     */
    private Animal[] myAnimals;
    private int nrAnimals;

    /**
     * Spieler, der als naechstes ziehen darf ('M' oder 'W').
     * Wird jedes Mal aktualisiert, wenn eine Seite ihre Zuege ausfuehrt.
     */
    private char next = 'W';
    
    // weitere Attribute
    private int nrPredators = 12;


    /**
     * Stellt die Anfangsposition des Spiels her.
     * Der Parameter gibt an, welche Seite beginnt ('M' oder 'W').
     */
    public void reset(char movesNext) {
        //TODO
    	next = movesNext;
    	nrAnimals = 32;
    	myAnimals = new Animal[nrAnimals];

    	myAnimals[0] = new Elephant(true, "b1", this);
    	myAnimals[1] = new Elephant(true, "g1", this);
    	myAnimals[2] = new Elephant(false, "b8", this);
    	myAnimals[3] = new Elephant(false, "g8", this);
    	myAnimals[4] = new Horse(true, "c1", this);
    	myAnimals[5] = new Horse(true, "f1", this);
    	myAnimals[6] = new Horse(false, "c8", this);
    	myAnimals[7] = new Horse(false, "f8", this);
    	myAnimals[8] = new Rabbit(true, "b2", this);
    	myAnimals[9] = new Rabbit(true, "c2", this);
    	myAnimals[10] = new Rabbit(true, "d2", this);
    	myAnimals[11] = new Rabbit(true, "e2", this);
    	myAnimals[12] = new Rabbit(true, "f2", this);
    	myAnimals[13] = new Rabbit(true, "g2", this);
    	myAnimals[14] = new Rabbit(false, "b7", this);
    	myAnimals[15] = new Rabbit(false, "c7", this);
    	myAnimals[16] = new Rabbit(false, "d7", this);
    	myAnimals[17] = new Rabbit(false, "e7", this);
    	myAnimals[18] = new Rabbit(false, "f7", this);
    	myAnimals[19] = new Rabbit(false, "g7", this);
    	myAnimals[20] = new Leopard(true, "d1", this);
    	myAnimals[21] = new Leopard(true, "e1", this);
    	myAnimals[22] = new Leopard(false, "d8", this);
    	myAnimals[23] = new Leopard(false, "e8", this);    	
    	myAnimals[24] = new Penguin(true, "a2", this);
    	myAnimals[25] = new Penguin(true, "h2", this);
    	myAnimals[26] = new Penguin(false, "a7", this);
    	myAnimals[27] = new Penguin(false, "h7", this);
    	myAnimals[28] = new Snake(true, "a1", this);
    	myAnimals[29] = new Snake(true, "h1", this);
    	myAnimals[30] = new Snake(false, "a8", this);
    	myAnimals[31] = new Snake(false, "h8", this);
    	
    	System.out.println(toString());	
    }


    /**
     * Fuehrt die uebergebenen Zuege fuer einen der Spieler aus.
     * Die Reihenfolge soll keinen Unterschied machen.
     * Diese Methode geht davon aus, dass dies bereits ueberprueft wurde.
     *
     * Der Zustand des Spiels wird entsprechend angepasst, d. h. ein Spiel
     * kann von der Anfangsposition aus allein mittels Aufrufen dieser Methode
     * gespielt werden. Insbesondere wechselt durch den Aufruf das Zugrecht,
     * da M und W abwechselnd ziehen.
     *
     * @param move Array mit den Zuegen, die ausgefuehrt werden sollen.
     *
     */
    public void applyMoves(Move[] move){
        //TODO
    	int pos;
    	int count = 0;
    	boolean square = false;
    	String goal;
    	Animal[] tmp;
    	
    	if(move == null) {
    		changePlayer();
    		System.out.println(this.toString());
    		return;
    	}

    	for(int i = 0; i < move.length; i++) {
    		pos = findAnimal("" + move[i].toString().charAt(0) + move[i].toString().charAt(1));
    		goal = "" + move[i].toString().charAt(2) + move[i].toString().charAt(3);
    		
    		// Raubtier zieht; ANNAHME: auf dem Zielfeld steht ein vegetarischer Gegner
    		if(myAnimals[pos].isVeggie() == false) {
    			
    			for(int j = 0; j < myAnimals.length; j++) {
    					if(myAnimals[j].square.equals(goal)) {
    						count = j;
    						square = true;
    						break;
    					}
    				}
    			if(square == true) {
    				myAnimals[pos].setDays();
    				myAnimals[count].square = "";
    				myAnimals[pos].square = "" + goal;
    				tmp = new Animal[myAnimals.length - 1];
        			for(int k = 0, l = 0; k < tmp.length; k++, l++) {
        				if(k == count) {
    						l++;
    					}
    					tmp[k] = myAnimals[l];
    				}
        			myAnimals = tmp;
    			} else {
    				myAnimals[pos].square = "" + goal;
    			}
	
    		} else {
        		myAnimals[pos].square = "" + goal;
    		}
	
    	}
    	// Spielerwechsel
    	if(next == 'W') {
    		next = 'M';
    	} else {
    		next = 'W';
    	}
    	
    	// Ausgabe des aktualisierten Spielfeldes
    	System.out.println(this);
    }


    /**
     * Ermittelt, ob/wer gewonnen hat.
     *
     * @return 'W' falls W gewonnen hat,
     *         'M' falls M gewonnen hat,
     *         'N' falls das Spiel unentschieden zu Ende ist,
     *         'X' falls das Spiel noch nicht zu Ende ist.
     *
     */
    public char theWinner() {
        //TODO
    	
    	// alle Tiere sind vom Brett verschwunden
    	if(myAnimals.length == 0) {
    		return 'N';
    	}
    	
    	int w = 0;
    	int m = 0;
    	for(int i = 0; i < myAnimals.length; i++) {
    		if(myAnimals[i].female == true) {
    			w++;
    		} else {
    			m++;
    		}
    	}
    	
    	// keine Raubtiere mehr uebrig
    	if(nrPredators == 0) {
    		if(w > m) {
    			return 'W';
    		} else if(m > w) {
    			return 'M';
    		} else {
    			return 'N';
    		}
    	}
    	
    	// eine Seite hat keine Tiere mehr
    	if(w == 0 && m != 0) {
    		return 'M';
    	} else if(m == 0 && w != 0) {
    		return 'W';
    	}
    	
    	return 'X';
    }





    // Ausgabe der Spielposition

    private static final int[] I = {8,7,6,5,4,3,2,1};
    private static final String[] J = {"a","b","c","d","e","f","g","h"};
    private static int toIndex(String s){return (s.charAt(0)-'a');}

    // Erzeugt eine 2D-Repraesentation der Spielposition.
    // Darf ggf. auf neue Datenstruktur angepasst werden (s.o.)
    // Die Rueckgabe ist ein zweidimensionales Array, welches
    // jedem Feld das darauf befindliche Tier (oder null) zuordnet.
    // Dabei laeuft der erste Index von der 'a'-Linie zur 'h'-Linie,
    // der zweite von der 1. zur 8. Reihe. D.h. wenn z.B. bei a[3][7]
    // ein Tier ist, ist das zugehörige Feld "d8" (vierter Buchstabe,
    // achte Zahl).
    public Animal[][] boardRepresentation(){
        Animal[][] a = new Animal[8][8];
        for (int i : I) {
            for (String j : J) {
                for (int k = 0; k < myAnimals.length; k++) {
                    if (null == myAnimals[k]) {break;}
                    if (myAnimals[k].square.equals(j+i)) {
                        a[toIndex(j)][i-1] = myAnimals[k];
                    }
                }
            }
        }
        return a;
    }


    @Override
    public String toString(){
        String str = "   a b c d e f g h\n";
        Animal[][] ani = boardRepresentation();
        for (int i : I) {
            str += (i+" ");
            for (String j : J) {
                if (null == ani[toIndex(j)][i-1]) {
                    str += (i+toIndex(j))%2==1 ? Globals.ts_empty_square_dark : Globals.ts_empty_square_light;
                } else {
                    str += ani[toIndex(j)][i-1].toString();
                }
            }
            str += " " + i + "\n";
        }
        str += "  a b c d e f g h\nIt is " + next + "'s turn.\n";
        return str;
    }
    
    // weitere Methoden
    public int findAnimal(String s) {
    	int pos = -1;
    	for(int i = 0; i < myAnimals.length; i++) {
    		if(myAnimals[i].square.equals(s)) {
    			pos = i;
    		}
    	}
    	return pos;
    }
    
    public Move[] actualMoves(String s) {

    	int pos = findAnimal(s);
    	if(pos == -1) {
    		System.out.println("Der Spielstein wurde nicht gefunden.");
    		return null;
    	} 
    	
    	Move[] tmp2 = new Move[myAnimals[pos].possibleMoves().length];
    	int u = 0;
    	int x = 0;
    	for(int i = 0; i < myAnimals[pos].possibleMoves().length; i++) {
    		String ziel = "" + myAnimals[pos].possibleMoves()[i].toString().charAt(2) + myAnimals[pos].possibleMoves()[i].toString().charAt(3);
    		for(int j = 0; j < myAnimals.length; j++) {
    			// Zielfeld ist von eigener Figur belegt
    			if(ziel.equals(myAnimals[j].square) && myAnimals[j].female == nextPlayer()) { 
                	u = 1;
                	break;
               	}
    			// Zielfeld ist von gegnerischem Raubtier belegt
    			if(ziel.equals(myAnimals[j].square) && myAnimals[j].female != nextPlayer() && myAnimals[j].isVeggie() == false) {
    				u = 1;
    				break;
    			}
    			// Zielfeld ist von gegnerischer Figur besetzt und die ziehende Figur ist ein Vegetarier
    			if(ziel.equals(myAnimals[j].square) && myAnimals[j].female != nextPlayer() && myAnimals[pos].isVeggie() == true) {
    				u = 1;
    				break;
    			}
    			// ein Zwischenfeld wird blockiert?
    			// ist das Feld direkt vor dem Zielfeld belegt, so darf die Figure nicht dort hin ziehen
    			
    		}
    		if(u == 0) {
    			tmp2[x] = myAnimals[pos].possibleMoves()[i];
    			x++;
    		}
    		u = 0;
    	}

    	if(x == 0) {
    		System.out.println("Dieser Spielstein hat derzeit keine Bewegungsmoeglichkeiten.");
    		return null;
    	}
    	
    	Move[] actualMoves = new Move[x];
    	for(int i = 0; i < x; i++) {
    		actualMoves[i] = tmp2[i];
    	}

    	return actualMoves;
    }
    
    public void printActualMoves(Move[] m) {
    	if(m == null) {
    		return;
    	}
    	System.out.print("[");
    	for(int i = 0; i < m.length; i++) {
    		if(i == m.length - 1) {
    			System.out.println(m[i] + "]");
    		} else {
        		System.out.print(m[i] + ", ");
    		}
    	}
    }
    
    public boolean legitMove(String s, Move m) {
    	
    	boolean equal = false;
    	for(int i = 0; i < actualMoves(s).length; i++) {
    		if(actualMoves(s)[i].equals(m)) {
    			equal = true;
    			break;
    		}
    	}
    	return equal;
    }
    
    public boolean femaleAnimal(String s) {
    	boolean female = false;
    	int pos = findAnimal(s);
    	if(myAnimals[pos].female == true) {
    		female = true;
    	}
    	return female;
    }
    
    public boolean nextPlayer() {
    	boolean female = false;
    	if(next == 'W') {
    		female = true;
    	}
    	return female;
    }
    
    public void changePlayer() {
    	if(next == 'W') {
    		next = 'M';
    	} else {
    		next = 'W';
    	}
    }
    
    public boolean isVeggie(String s) {
    	return myAnimals[findAnimal(s)].isVeggie();
    }

    public String[] findPredator(int n, boolean player) {
    	
    	int[] days = new int[2];
    	String[] square = new String[2];
    	int j = 0;
    	for(int i = 0; i < myAnimals.length; i++) {
    		if(myAnimals[i].female == player) {
    			if(myAnimals[i].isVeggie() == false) {
    				if(myAnimals[i].getIdentifier() == n) {
    					days[j] = myAnimals[i].getDays();
    					square[j] = myAnimals[i].square;
    					j++;
    				}
    			}
    		}
    	}
    	if(j == 0) {
    		return null;
    	}
    	String[] result = new String[j];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = "" + square[i] + days[i];
    	}
    	return result;
    }
    
    public void triggerSunset() {
    	for(int i = 0; i < myAnimals.length; i++) {
    		myAnimals[i].sunset();
    	}
    }
    
    public int killPredators() {
    	int[] positions = new int[12];
    	int deaths = 0;
    	
    	for(int i = 0, j = 0; i < myAnimals.length; i++) {
    		if(myAnimals[i].isVeggie() == false) {
    			if(myAnimals[i].getDays() < 0) {
    				positions[j] = i;
    				deaths++;
    				j++;
    			}
    		}
    	}
    	
    	int[] pos = new int[deaths];
    	for(int i = 0; i < pos.length; i++) {
    		pos[i] = positions[i];
    	}
    	
    	Animal[] tmp = new Animal[myAnimals.length - deaths];
    	for(int i = 0, j = 0; i < tmp.length; i++, j++) {
    		for(int k = 0; k < pos.length; k++) {
    			if(pos[k] == j) {
    				j++;
    			}
    		}
    		tmp[i] = myAnimals[j];
    	}
    	
    	if(deaths != 0) {
        	myAnimals = tmp;
    	}

    	nrPredators = nrPredators - deaths;
    	
    	// gibt Anzahl der verbliebenen Raubtiere auf dem Spielfeld zurueck
    	return nrPredators;
    }
    
}
