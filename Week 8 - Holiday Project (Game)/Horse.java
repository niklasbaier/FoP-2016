public class Horse extends Vegetarian {

    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Horse(boolean female) {
        //TODO
    	super(female);
    }
    
    // Eigener Konstruktor
    public Horse(boolean female, String square, Position position) {
    	super(female, square, position);
    }


    @Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_horse_dark : Globals.ts_female_horse_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_horse_dark : Globals.ts_male_horse_light);
    }

    // weitere Methoden
    @Override
    public Move[] possibleMoves() {
    	String s = this.square;
    	
    	// X und Y Koordinate als Zahlen
    	int posx = toIndexFirst(s);
    	int posy = toIndexSecond(s);
    	Move[] tmp = new Move[12];
    	int counter = 0;
    	
    	// Bewegungsmoeglichkeiten des Pferdes auf dem Feld
    	// vertikal
    	for(int y = posy - 1; y <= posy + 1; y++) {
    		if(y <= 8 && y >= 1) {
    			if(y == posy) {
				} else {
    				tmp[counter] = new Move("" + s, "" + fromIndex(posx) + y);
    				counter++;	
				}
    		}
    	}
    	// horizontal
        for(int x = posx - 1; x <= posx + 1; x++) {
        	if(x <= 7 && x >= 0) {
        		if(x == posx) {
    			} else {
        			tmp[counter] = new Move("" + s, "" + fromIndex(x) + posy);
        			counter++;	
    			}
        	}
        }
        // nach links unten
    	int x = posx - 2;
    	int y = posy - 2;
    	if(x >= 0 && y >= 1) {
    		tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
    		counter++;
    		x--;
    		y--;
    		if(x >= 0 && y >= 1) {
    			tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
    			counter++;
    		}
    	}
    	// nach rechts unten
    	x = posx + 2;
    	y = posy - 2;
    	if(x <= 7 && y >= 1) {
    		tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
    		counter++;
    		x++;
    		y--;
    		if(x <= 7 && y >= 1) {
    			tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
    			counter++;
    		}
    	}
    	// nach links oben
    	x = posx - 2;
    	y = posy + 2;
    	if(x >= 0 && y <= 8) {
    		tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
    		counter++;
    		x--;
    		y++;
    		if(x >= 0 && y <= 8) {
    			tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
    			counter++;
    		}
    	}
    	// nach rechts oben
    	x = posx + 2;
    	y = posy + 2;
    	if(x <= 7 && y <= 8) {
    		tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
    		counter++;
    		x++;
    		y++;
    		if(x <= 7 && y <= 8) {
    			tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
    			counter++;
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
