public class Verhext extends MiniJava {

	// x^y
	public static int pow(int x, int y) {
		return java.math.BigInteger.valueOf(x).pow(y).intValueExact();
	}

	public static void main(String[] args) {

		// Deklaration und Initialisierung
		String input = readString();
		int output = 0;

		char[] inputstorage;
		int length, index, i, j = 0;
		int counter, counter2 = 0;

		char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f' };
		char[] letters_big = { 'A', 'B', 'C', 'D', 'E', 'F' };
		int[] numbers;

		length = input.length();

		/*
		 * Abzug der Stellen '(-)0x' bzw. '(-)0X', da diese ja nur der
		 * Kennzeichnung einer Hexadezimalzahl dienen. Die relevanten Stellen
		 * werden in einem neuen char Array gespeichert.
		 */
		if (input.charAt(0) == '-') {
			i = 3;
			index = length - i;
		} else {
			i = 2;
			index = length - i;
		}

		for (counter = 0; counter < index; counter++) {
			if (input.charAt(i + counter) == '_') {
				j++;
			}
		}

		index = index - j;
		inputstorage = new char[index];
		numbers = new int[index];
		counter = 0;

		// Unterstriche herausfiltern
		for (counter2 = 0; counter2 < index; counter2++) {
			while (input.charAt(i + counter) == '_') {
				counter++;
			}
			inputstorage[counter2] = input.charAt(i + counter);
			counter++;
		}

		// Zwischenergebnis präsentieren
		System.out.print("Die eingegebene Hexadezimalzahl war:\t" + input + " mit der Länge " + length + ".\n");
		if (i == 3) {
			System.out.print(
					"(Das negative Vorzeichen wird der Einfachkeit halber erst wieder nach Berechnung der Lösung hinzugefügt.)\n");
		}
		System.out.print("Die relevanten Stellen sind also: \t");
		System.out.print(inputstorage);
		System.out.print(" mit " + index + " Index Stellen.\nUmgewandelt in Zahlen gibt das:\t\t");

		/*
		 * KOMMENTAR: Da ich nicht wusste, wie ich ohne die Verwendung von Java
		 * Methoden die in einem char Array gespeicherten Ziffern als
		 * numerischen Werte (eben 0 bis 9) und NICHT als ASCII Werte (Unicode
		 * wurde in der VL angeschnitten) erhalte, habe ich mittels folgender
		 * Schleife getestet, welche Zahlen hinter den Ziffern stecken und bin
		 * zu dem Ergebnis gekommen, dass diese von 48 bis 57 gehen.
		 * Dementsprechend war meine Idee für den Rest des Programms also, diese
		 * Werte abzüglich 48 in einer int Variable zu sichern, die dann die
		 * korrekten Ziffern enthält. Tut mir leid, falls dies eine unschöne Art
		 * und Weise ist, anders wusste ich mir aber nicht mit meinem Wissen aus
		 * der VL zu helfen. (Hinweis: Ich habe das Programm vor dem entsprechenden
		 * Programmierpraktikum geschrieben, wo genau dies behandelt wurde.)
		 */

		/*
		 * Mittels diesen Code Zeilen lassen sich die ASCII Werte der Zahlen 0
		 * bis 9 in einem char Array herausfinden. char[] test = { '0', '1',
		 * '2', '3', '4', '5', '6', '7', '8', '9' }; int[] zahl = new int[10];
		 * for (counter = 0; counter < 10; counter++) { zahl[counter] =
		 * test[counter]; System.out.print(zahl[counter] + "   "); }
		 */

		// Der char Array wird nun in einen int Array eingespeist.
		for (counter = 0; counter < index; counter++) {

			for (counter2 = 0; counter2 < 6; counter2++) {
				if (inputstorage[counter] == letters[counter2] || inputstorage[counter] == letters_big[counter2]) {
					numbers[counter] = 10 + counter2;
				}
			}

			/*
			 * falls der Arraystelle nichts zugewiesen wird durch die obere
			 * Schleife, war die entsprechende Eingabe eine Zahl und kein
			 * Buchstabe
			 */
			if (numbers[counter] == 0) {
				numbers[counter] = inputstorage[counter] - 48;
			}

			System.out.print(numbers[counter] + "\t");
		}

		// Potenzrechnung
		for (counter = 0; counter < index; counter++) {
			output = output + numbers[(index - 1) - counter] * pow(16, counter);
		}

		if (i == 3) {
			output = output * -1;
		}

		// Ausgabe
		System.out.print("\nSomit ist der Integer-Wert:\t\t" + output);
		write(output);
	}
}
