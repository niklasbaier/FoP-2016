public class NotEnoughUpper extends NotEnoughLetter {
	
	public NotEnoughUpper(int should, int is) {
		super(should, is);
	}
	
	@Override
	public String toString() {
		return "NotEnoughUpper:\tDas Passwort enthaelt zu wenige Grossbuchstaben (" + is + "). Vorgebene Mindestanzahl an Grossbuchstaben: " + should;
	}
}
