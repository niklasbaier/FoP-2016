public class NotLongEnoughExc extends Exception {

	final private int should;
	final private int is;
	
	public NotLongEnoughExc(int should, int is) {
		this.should = should;
		this.is = is;
	}
	
	@Override
	public String toString() {
		return "NotLongEnoughExc:\tDas Passwort ist zu kurz (" + is + "). Vorgebene Mindestlaenge: " + should;
	}
}
