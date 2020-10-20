public class FunctionalCaesar extends MiniJava {

    public static char shift(char c, int k) {
        // TODO
    	
    	// A bis Z:	65 bis 90
    	// a bis z: 97 bis 122
    	int pos = (int) c;
    	while(k < 0) {
    		k = k + 26;
    	}
    	if(pos > 64 && pos < 91) {
    		// Grossbuchstabe
    		pos = (pos + k);
    		while(pos > 90) {
    			pos = pos - 26;
    		}
    		c = (char) pos;
    		return c;
    	} else if(pos > 96 && pos < 123) {
    		// Kleinbuchstabe
    		pos = (pos + k);
    		while(pos > 122) {
    			pos = pos - 26;
    		}
    		c = (char) pos;
    		return c;
    	} else {
    		// sonstiges Zeichen
    		return c;
    	}
    }

    public static String encrypt(String s, int k) {
        // TODO
    	String output = "";
    	for(int i = 0; i < s.length(); i++) {
    		output = output + shift(s.charAt(i), k % 26);
    	}
    	return output;
    }

    public static String decrypt(String s, int k) {
        return encrypt(s, -(k % 26));
    }

    public static void main(String[] args) {
       String input = readString();
       int k = read();
       String out = encrypt(input, k);
       write(out);
       
       // Entschluesselung des Geheimtextes
       String geheim = "Mrn pnvnrwbcnw Jdopjknw bcnuuc Ajyqjnuj";
       for(int i = 0; i < 27; i++) {
    	   System.out.print("Verschlüsselung mit k = " + i + ":\t\t" + decrypt(geheim, i) + "\n");
       }
       k = 9;
       write("Zusatz: der Schlüssel ist " + k + ". Die entschlüsselte Botschaft lautet also:\n" + decrypt(geheim, k));
    }
}