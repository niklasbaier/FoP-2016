public class Schlangenspiel extends Spielfeld {

	public static void main(String[] args) {

		// Initialisierung
		int spielerposition = 0, spieler1pos = 0, spieler2pos = 0;
		int wurf = 0, spieler = 0;

		paintField(spieler1pos, spieler2pos);
		write("Drücke 'Enter' zum Spielen.");
		write("Es würfelt Spieler 1.");

		while (spielerposition <= 35) {
			wurf = dice();
			write("Es wurde eine " + wurf + " gewürfelt.\n");

			// TO DO: Falls der Spieler durch eine Schlange wieder auf eine
			// Leiter zurückrutscht

			spielerposition = spielerposition + wurf;
			if (spieler == 0) {
				spieler1pos = spielerposition;
			} else {
				spieler2pos = spielerposition;
			}
			
			paintField(spieler1pos, spieler2pos);

			while (spielerposition % 5 == 0 && spielerposition < 35
					|| spielerposition % 7 == 0 && spielerposition < 35) {
				if (spielerposition % 5 == 0) {
					spielerposition = spielerposition + 3;

					if (spieler == 0) {
						spieler1pos = spielerposition;
					} else {
						spieler2pos = spielerposition;
					}

					write("Wow! Du bist auf einer Leiter gelandet! Du rückst 3 weitere Felder vor.");
					paintField(spieler1pos, spieler2pos);
				} else if (spielerposition % 7 == 0) {
					spielerposition = spielerposition - 4;

					if (spieler == 0) {
						spieler1pos = spielerposition;
					} else {
						spieler2pos = spielerposition;
					}

					write("Au weh, du bist auf eine Schlange getreten! Du rutscht 4 Felder zurück.");
					paintField(spieler1pos, spieler2pos);
				}
			}

			if (spieler == 0) {
				spieler++;
				if (spieler1pos >= 35) {
					paintField(35, spieler2pos);
					write("Herzlichen Glückwunsch, Spieler 1 hat gewonnen!");
					return;
				} else{
					spielerposition = spieler2pos;
				}
			} else {
				spieler--;
				if (spieler2pos >= 35) {
					paintField(spieler1pos, 35);
					write("Herzlichen Glückwunsch, Spieler 2 hat gewonnen!");
					return;
				} else {
					spielerposition = spieler1pos;
				}
			}

			if (spielerposition < 35) {
				write("Dein Spielzug ist beendet. Nun würfelt Spieler " + (spieler + 1) + ".");
			}
		}
	}
}