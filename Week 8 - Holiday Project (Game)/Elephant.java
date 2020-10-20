public class Elephant extends Vegetarian {

    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Elephant(boolean female) {
        //TODO
    	super(female);
    }
    
    // Eigener Konstruktor
    public Elephant(boolean female, String square, Position position) {
    	super(female, square, position);
    }


    @Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_elephant_dark : Globals.ts_female_elephant_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_elephant_dark : Globals.ts_male_elephant_light);
    }
    
    // weitere Methoden
    @Override
    public Move[] possibleMoves() {
    	String s = this.square;
    	
    	// X und Y Koordinate als Zahlen
    	int posx = toIndexFirst(s);
    	int posy = toIndexSecond(s);
    	Move[] tmp = new Move[14];
    	int counter = 0;
    	
    	// Bewegungsmoeglichkeiten des Elefanten auf dem Feld
    	// vertikal
    	int y = 1;	
    	while(y <= 8) {
    		if(y == posy) {
    		} else {
    			tmp[counter] = new Move("" + s, "" + fromIndex(posx) + y);
    			counter++;
    		}
    		y++;
    	}
    	// horizontal
    	int x = 0;
    	while(x <= 7) {
    		if(x == posx) {
    		} else {
    			tmp[counter] = new Move("" + s, "" + fromIndex(x) + posy);
    			counter++;
    		}
    		x++;
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
