public class NotEnoughNumber extends NotEnoughExc {

	public NotEnoughNumber(int should, int is) {
		super(should, is);
	}
	
	@Override
	public String toString() {
		return "NotEnoughNumber:\tDas Passwort enthaelt zu wenige Ziffern (" + is + "). Vorgebene Mindestanzahl an Ziffern: " + should;
	}
}
