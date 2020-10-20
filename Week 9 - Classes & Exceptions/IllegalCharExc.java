public class IllegalCharExc extends Exception {

	final private char used;
	
	public IllegalCharExc(char used) {
		this.used = used;
	}
	
	@Override
	public String toString() {
		switch(used) {
		case '\n': return "IllegalCharExc:\tDas Zeichen \\n ist im Passwort nicht erlaubt.";
		case '\t': return "IllegalCharExc:\tDas Zeichen \\t ist im Passwort nicht erlaubt.";
		case '\r': return "IllegalCharExc:\tDas Zeichen \\r ist im Passwort nicht erlaubt.";
		case '\b': return "IllegalCharExc:\tDas Zeichen \\b ist im Passwort nicht erlaubt.";
		case '\f': return "IllegalCharExc:\tDas Zeichen \\f ist im Passwort nicht erlaubt.";
		default: return "Das Sonderzeichen " + used + " ist nicht im Passwort erlaubt.";
		}
	}
	
}
