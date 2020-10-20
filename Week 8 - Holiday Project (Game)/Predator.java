/**
 * Klasse der Raubtiere.
 */
public class Predator extends Animal {
	
    /**
     * Dem Konstruktor wird das Geschlecht des Tiers uebergeben.
     *
     */
    public Predator(boolean female) {
        //TODO
    	super(female);
    }
    
    // Eigener Konstruktor
    public Predator(boolean female, String square, Position position) {
    	super(female, square, position);
    }
    
    // weitere Methoden
    @Override
    public boolean isVeggie() {
    	return false;
    }

    @Override
    public int getDays() {
    	return 0;
    }
    
    @Override
    public int getIdentifier() {
    	return 0;
    }
    
    @Override
    public void setDays() {
    	return;
    }
    
}
