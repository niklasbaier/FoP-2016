/**
 * Klasse der Vegetarier.
 */
public class Vegetarian extends Animal {
	
    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Vegetarian(boolean female) {
        //TODO
    	super(female);
    }
    
    // Eigener Konstruktor
    public Vegetarian(boolean female, String square, Position position) {
    	super(female, square, position);
    }
    
    // weitere Methoden
    @Override
    public boolean isVeggie() {
    	return true;
    }
    
}
