public class Snake extends Predator {

    // Eine Schlange kann 9 Tage bzw. Spielrunden ohne Essen auskommen.
    // Die Deklaration darf entfernt (und der Wert z. B. direkt im Code
    // verwendet) werden.
    private static int withoutFood = 9;
    private int days = 9;


    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Snake(boolean female) {
        //TODO
    	super(female);
    }
    
    // Eigener Konstruktor
    public Snake(boolean female, String square, Position position) {
    	super(female, square, position);
    }


    @Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_snake_dark : Globals.ts_female_snake_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_snake_dark : Globals.ts_male_snake_light);
    }
    
    // weitere Methoden
    @Override
    public Move[] possibleMoves() {
    	String s = this.square;
    	
    	// X und Y Koordinate als Zahlen
    	int posx = toIndexFirst(s);
    	int posy = toIndexSecond(s);
    	// Maximum der Moeglichkeiten entspricht der Anzahl Felder
    	Move[] tmp = new Move[64];
    	int counter = 0;
    	
    	// Bewegungsmoeglichkeiten der Schlange auf dem Feld
    	// oben
    	int x = posx - 1;
    	int y = posy + 1;
    	boolean left = true;
    	while(x >= 0 && x <= 7 && y <= 8) {
    		tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
			counter++;
			if(left == true) {
				x++;
				left = false;
			} else {
				x--;
				left = true;
			}
			y++;
    	}
    	// rechts
    	x = posx + 1;
    	y = posy + 1;
    	left = true;
    	while(x <= 7 && y <= 8 && y >= 1) {
    		tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
    		counter++;
    		if(left == true) {
    			y--;
    			left = false;
    		} else {
    			y++;
    			left = true;
    		}
    		x++;
    	}
    	// unten
    	x = posx + 1;
    	y = posy - 1;
    	left = true;
    	while(x <= 7 && x >= 0 && y >= 1) {
    		tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
			counter++;
			if(left == true) {
				x--;
				left = false;
			} else {
				x++;
				left = true;
			}
			y--;
    	}
    	// links
    	x = posx - 1;
    	y = posy - 1;
    	left = true;
    	while(x >= 0 && y >= 1 && y <= 8) {
    		tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
    		counter++;
    		if(left == true) {
    			y++;
    			left = false;
    		} else {
    			y--;
    			left = true;
    		}
    		x--;
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
