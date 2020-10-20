public class Rabbit extends Vegetarian {

    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Rabbit(boolean female) {
        //TODO
    	super(female);
    }
    
    public Rabbit(boolean female, String square, Position position) {
    	super(female, square, position);
    }


    @Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_rabbit_dark : Globals.ts_female_rabbit_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_rabbit_dark : Globals.ts_male_rabbit_light);
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
    	
    	// Bewegungsmoeglichkeiten des Kaninchens auf dem Feld
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
    	return;
    }
    
}
