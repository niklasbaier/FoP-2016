public class SuValt extends MiniJava {

	public static void main(String[] args) {

		int s1card1, s1card2, s2card1, s2card2;
		int zustand, newcard;
		int s1punkte, s2punkte;

		zustand = 1;

		// Spieler 1 ist an der Reihe
		s1card1 = drawCard();
		s1card2 = drawCard();
		s1punkte = s1card1 + s1card2;

		write("Es beginnt Spieler 1. Deine Hand ist: " + s1card1 + " und " + s1card2
				+ "\nDementsprechend betragen deine Punkte: " + s1punkte);

		while (zustand != 0 && s1punkte <= 21) {
			zustand = read("Möchtest du eine weitere Karte ziehen? Ja: 1, Nein: 0");

			// Eingabe wird auf ihre Gültigkeit hin überprüft.
			while (zustand > 1 || zustand < 0) {
				zustand = read("Triff bitte eine Entscheidung. Ja: 1, Nein: 0");
			}

			if (zustand != 0) {

				newcard = drawCard();
				s1punkte = s1punkte + newcard;
				write("Du hast die Karte " + newcard + " gezogen.\nDementsprechend betragen deine Punkte: " + s1punkte);
				zustand = 1;
			}

		}

		// Wenn ein Spieler 22 oder mehr Punkte erreicht, verliert er sofort.
		if (s1punkte > 21) {
			write("Du hast einen Punktestand von über 21 (" + s1punkte + ") und damit das Spiel verloren.");
			return;
		} else {
			write("Du hast einen Punktestand von " + s1punkte + ". Nun ist Spieler 2 an der Reihe.");
		}

		// Spieler 2 ist an der Reihe
		s2card1 = drawCard();
		s2card2 = drawCard();
		s2punkte = s2card1 + s2card2;
		zustand = 1;

		write("Deine Anfangshand ist: " + s2card1 + " und " + s2card2 + "\nDementsprechend betragen deine Punkte: "
				+ s2punkte);

		while (zustand != 0 && s2punkte <= 21) {
			zustand = read("Möchtest du eine weitere Karte ziehen? Ja: 1, Nein: 0");

			// Eingabe wird auf ihre Gültigkeit hin überprüft.
			while (zustand > 1 || zustand < 0) {
				zustand = read("Triff bitte eine Entscheidung. Ja: 1, Nein: 0");
			}

			if (zustand != 0) {

				newcard = drawCard();
				s2punkte = s2punkte + newcard;
				write("Du hast die Karte " + newcard + " gezogen.\nDementsprechend betragen deine Punkte: " + s2punkte);
				zustand = 1;
			}

		}

		// Wenn ein Spieler 22 oder mehr Punkte erreicht, verliert er sofort.
		if (s2punkte > 21) {
			write("Du hast einen Punktestand von über 21 (" + s2punkte + ") und damit das Spiel verloren.");
			return;
		} else {
			write("Du hast einen Punktestand von " + s2punkte + ". Damit steht das Endergebnis fest.");
		}

		// Evaluation
		if (s1punkte >= s2punkte) {
			write("Spieler 1 siegt mit " + s1punkte + " Punkten über Spieler 2 mit " + s2punkte
					+ " Punkten.\nDas Spiel wird beendet.");
			return;
		} else {
			write("Spieler 2 siegt mit " + s2punkte + " Punkten über Spieler 1 mit " + s1punkte
					+ " Punkten.\nDas Spiel wird beendet.");
		}
	}

}