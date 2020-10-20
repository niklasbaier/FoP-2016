public class NotEnoughLower extends NotEnoughLetter {

	public NotEnoughLower(int should, int is) {
		super(should, is);
	}
	
	@Override
	public String toString() {
		return "NotEnoughLower:\tDas Passwort enthaelt zu wenige Kleinbuchstaben (" + is + "). Vorgebene Mindestanzahl an Kleinbuchstaben: " + should;
	}
}
