public class Penguin extends Predator {

    // Ein Pinguin kann 12 Tage bzw. Spielrunden ohne Essen auskommen.
    // Die Deklaration darf entfernt (und der Wert z. B. direkt im Code
    // verwendet) werden.
    private static int withoutFood = 12;
    private int days = 12;


    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Penguin(boolean female) {
        //TODO
    	super(female);
    }

    // Eigener Konstruktor
    public Penguin(boolean female, String square, Position position) {
    	super(female, square, position);
    }

    @Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_penguin_dark : Globals.ts_female_penguin_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_penguin_dark : Globals.ts_male_penguin_light);
    }
    
    // weitere Methoden
    @Override
    public Move[] possibleMoves() {
    	String s = this.square;
    	
    	// X und Y Koordinate als Zahlen
    	int posx = toIndexFirst(s);
    	int posy = toIndexSecond(s);
    	Move[] tmp = new Move[8];
    	int counter = 0;
    	
    	// Bewegungsmoeglichkeiten des Pinguins auf dem Feld
    	for(int y = posy + 1; y >= posy - 1; y--) {
    		for(int x = posx - 1; x <= posx + 1; x++) {
    			if(y <= 8 && y >= 1 && x <= 7 && x >= 0) {
    				if(x == posx && y == posy) {
    				} else {
        				tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
        				counter++;	
    				}
    			}
    		}
    	}
    	
    	// Ausgabe Array, der nur wirklich so lange ist, wie es moegliche Zuege gibt
    	Move[] result = new Move[counter];
    	for(int i = 0; i < counter; i++) {
    		result[i] = tmp[i];
    	}
    	return result;
    }

    @Override
    public void sunset() {
    	this.days--;
    	return;
    }
    
    @Override
    public int getDays() {
    	return this.days;
    }
    
    @Override
    public int getIdentifier() {
    	return withoutFood;
    }
    
    @Override
    public void setDays() {
    	this.days = withoutFood;
    }
    
}
