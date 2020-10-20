public class SuV extends MiniJava {

	public static void main(String[] args) {

		int card1, card2, newcard;
		int punkte, punkte1;
		int zustand, spieler;

		// Initialisierung
		spieler = 1;
		zustand = 1;
		punkte = punkte1 = 0;

		/*
		 * Die Variable 'spieler' bestimmt je nach Wert, ob Spieler 1 oder
		 * Spieler 2 an der Reihe ist. Sie wird am Ende der while Schleife
		 * hochgezählt, sodass jeweils ein Durchlauf für jeden Spieler
		 * durchgeführt wird.
		 */
		while (spieler <= 2) {

			// Welcher Spieler ist an der Reihe?
			if (spieler == 1) {
				card1 = drawCard();
				card2 = drawCard();
				punkte = card1 + card2;
				write("Es beginnt Spieler 1. Deine Hand ist: " + card1 + " und " + card2
						+ "\nDementsprechend betragen deine Punkte: " + punkte);
			} else {
				card1 = drawCard();
				card2 = drawCard();
				punkte = card1 + card2;
				write("Spieler 2 ist an der Reihe. Deine Hand ist: " + card1 + " und " + card2
						+ "\nDementsprechend betragen deine Punkte: " + punkte);
			}

			/*
			 * Es wird solange nachgefragt, ob der Spieler weiterziehen will,
			 * wie die Antwort nicht 0 ist oder die Punktestände beider Spieler
			 * jeweils kleiner sind als 21.
			 */
			while (zustand != 0 && punkte <= 21 && punkte1 <= 21) {
				zustand = read("Möchtest du eine weitere Karte ziehen? Ja: 1, Nein: 0");

				// Eingabe wird auf ihre Gültigkeit hin überprüft.
				while (zustand > 1 || zustand < 0) {
					zustand = read("Triff bitte eine Entscheidung. Ja: 1, Nein: 0");
				}

				/*
				 * Es wird so lange eine neue Karte gezogen, bis 0 eingegeben
				 * wird. Der Punktestand erhöht sich dementsprechend.
				 */
				if (zustand != 0) {
					newcard = drawCard();
					punkte = punkte + newcard;
					write("Du hast die Karte " + newcard + " gezogen.\nDementsprechend betragen deine Punkte: "
							+ punkte);
					zustand = 1;

					/*
					 * Wenn ein Spieler 22 oder mehr Punkte erreicht, verliert
					 * er sofort.
					 */
					if (punkte > 21) {
						write("Du hast einen Punktestand von über 21 (" + punkte + ") und damit das Spiel verloren.");
						return;
					}
				}
			}

			// Ausgabe
			write("Du hast einen Punktestand von " + punkte + ".");

			/*
			 * Die Punkte von Spieler 1 werden in der Variable 'punkte1'
			 * gespeichert, damit 'punkte' im zweiten Durchlauf für Spieler 2
			 * überschrieben werden kann.
			 */
			if (spieler == 1) {
				punkte1 = punkte;
			}

			/*
			 * Die Spielernummer wird um eins hochgezählt und die Variable
			 * 'zustand', die die Entscheidung des Spielers beim Ziehen (ja oder
			 * nein) speichert, wird auf 1 zurückgesetzt, da ansonsten Spieler 2
			 * keine Wahlmöglichkeit hat.
			 */
			spieler++;
			zustand = 1;
		}

		// Abschließende Evaluation
		if (punkte1 >= punkte) {
			write("Spieler 1 siegt mit " + punkte1 + " Punkten über Spieler 2 mit " + punkte
					+ " Punkten.\nDas Spiel wird beendet.");
			return;
		} else {
			write("Spieler 2 siegt mit " + punkte + " Punkten über Spieler 1 mit " + punkte1
					+ " Punkten.\nDas Spiel wird beendet.");
			return;
		}
	}
}