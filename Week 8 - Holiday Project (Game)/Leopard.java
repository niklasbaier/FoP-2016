public class Leopard extends Predator {

    // Ein Leopard kann nur 5 Tage bzw. Spielrunden ohne Essen auskommen.
    // Die Deklaration darf entfernt (und der Wert z. B. direkt im Code
    // verwendet) werden.
    private static int withoutFood = 5;
    private int days = 5;


    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Leopard(boolean female) {
        //TODO
    	super(female);
    }
    
    // Eigener Konstruktor
    public Leopard(boolean female, String square, Position position) {
    	super(female, square, position);
    }


    @Override
    public String toString(){
        return this.female
          ? (Globals.darkSquare(this.square) ? Globals.ts_female_leopard_dark : Globals.ts_female_leopard_light)
          : (Globals.darkSquare(this.square) ? Globals.ts_male_leopard_dark : Globals.ts_male_leopard_light);
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
    	
    	// Bewegungsmoeglichkeiten des Leoparden auf dem Feld
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
    	// Position links unten ermitteln
    	x = posx;
    	y = posy;
    	while(x != 0 && y != 1) {
    		x--;
    		y--;
    	}
    	// diagonal nach rechts oben
    	while(x <= 7 && y <= 8) {
    		if(x == posx && y == posy) {
    		} else {
    			tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
    			counter++;
    		}
        	x++;
        	y++;
    	}
    	// Position rechts unten ermitteln
    	x = posx;
    	y = posy;
    	while(x != 7 && y != 1) {
    		x++;
    		y--;
    	}
    	// diagonal nach links oben
    	while(x >= 0 && y <= 8) {
    		if(x == posx && y == posy) {
    		} else {
    			tmp[counter] = new Move("" + s, "" + fromIndex(x) + y);
    			counter++;
    		}
    		x--;
    		y++;
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
