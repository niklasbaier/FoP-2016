public class NotEnoughSpecial extends NotEnoughExc {

	public NotEnoughSpecial(int should, int is) {
		super(should, is);
	}
	
	@Override
	public String toString() {
		return "NotEnoughSpecial:\tDas Passwort enthaelt zu wenige Sonderzeichen (" + is + "). Vorgebene Mindestanzahl an Sonderzeichen: " + should;
	}
}
