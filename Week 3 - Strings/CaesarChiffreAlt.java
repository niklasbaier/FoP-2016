public class CaesarChiffreAlt extends MiniJava {

	public static void main(String[] args) {

		// Deklaration
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		char[] alphabet_big = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		String eingabe, aktion, result;
		char[] ausgabe;
		char zeichen, x;
		
		int shift, zustand, length;
		int counter, counter2;
		int position = 0, buchstabe = 2;

		// Initialisierung
		eingabe = readString("Bitte geben Sie einen Text ein, der verschlüsselt oder entschlüsselt werden soll.");
		shift = read("Welchen Wert soll der zyklische Shift haben?");

		// Umwandlung eines negativen Schlüssels (ob z.B. 3 Schritte nach hinten
		// oder 26-3=23 Schritte nach vorne, ist bei einem Zyklus mit 26 Zeichen
		// ja egal)
		if (shift < 0) {
			shift = shift + 26;
		}
		zustand = read("Soll der Text verschlüsselt (0) oder entschlüsselt werden (1)?");

		// Überprüfung der Eingabe
		while (zustand > 1) {
			zustand = read("Bitte entscheiden Sie sich! Zur Erinnerung: 0 für Verschlüsselung, 1 für Entschlüsselung.");
		}
		if (zustand == 0) {
			aktion = "Verschlüsselung";
		} else {
			aktion = "Entschlüsselung";
		}

		// Zusammenfassung der Eingaben
		System.out.print("Wir fassen zusammen:\nEingabe:\t\t" + eingabe + "\nzyklischer Shift:\t" + shift
				+ "\nAktion:\t\t\t" + aktion);

		// Bestimmung der Länge des eingegebenen Strings und Anlegung eines
		// Ausgabe Strings mit derselben Länge
		length = eingabe.length();
		ausgabe = new char[length];

		/*
		 * Schleife iteriert nun durch den eingegebenen String und bestimmt
		 * für jeden einzelnen Buchstaben, ob dieser ein Groß-/ oder
		 * Kleinbuchstabe oder ein Sonderzeichen ist. Dementsprechend werden
		 * Groß- und Kleinbuchstaben mittels dem Algorithmus ver-/entschlüsselt
		 * und Sonderzeichen übernommen und anschließend im auszugebenen
		 * String gespeichert.
		 */
		for (counter2 = 0; counter2 < length; counter2++) {

			// Speicherung des zu betrachtenden Buchstabends in der Variable
			// zeichen
			zeichen = eingabe.charAt(counter2);

			// Überprüfung, ob zeichen ein Kleinbuchstabe ist
			for (counter = 0; counter < 26; counter++) {
				if (zeichen == alphabet[counter]) {
					buchstabe = 0;
					position = counter;
				}
			}

			// Überprüfung, ob zeichen ein Großbuchstabe ist
			for (counter = 0; counter < 26; counter++) {
				if (zeichen == alphabet_big[counter]) {
					buchstabe = 1;
					position = counter;
				}
			}

			/*
			 * trifft keine der Bedingungen zu, wird angenommen, dass
			 * zeichen ein Sonderzeichen ist und demnach nur übernommen
			 * wird.
			 */
			if (buchstabe == 0) {
				if(aktion == "Verschlüsselung") {
					position = (position + shift) % 26;
				} else {
					position = (position - shift) % 26;
					if (position < 0) {
						position = position + 26;
					}
				}
				ausgabe[counter2] = alphabet[position];
			} else if (buchstabe == 1) {
				if(aktion == "Verschlüsselung") {
					position = (position + shift) % 26;
				} else {
					position = (position - shift) % 26;
					if (position < 0) {
						position = position + 26;
					}
				}
				ausgabe[counter2] = alphabet_big[position];
			} else {
				ausgabe[counter2] = eingabe.charAt(counter2);
			}

			// Zurücksetzung der Variable buchstabe
			buchstabe = 2;
		}
		
		/*
		 * Übergabe des Arrays in einen String: Zuerst wird ein leerer
		 * String initialisiert, dann wird mittels einer Schleife jedes
		 * Element des Ausgabe Arrays in einen char gespeichert, der dann
		 * per + Operation sich nach und nach zu einem String zusammenfügt,
		 * der mit der Methode write() von MiniJava ausgegeben werden kann.
		 */
		result = "";
		for (counter = 0; counter < length; counter++) {
			x = ausgabe[counter];
			result = result + x;
		}

		// Verschlüsselung wird ausgegeben
		System.out.print("\n\nDie Eingabe besteht aus " + length + " Zeichen.\nDie Verschlüsselung ist: ");
		System.out.print(ausgabe);
		write(result);
		}
}