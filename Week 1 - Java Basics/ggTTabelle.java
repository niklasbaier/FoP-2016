public class ggTTabelle extends MiniJava {

	public static void main(String[] args) {

		/*
		 * Kommentar: ich verwende den Tabulator zur Ausgabe, da ansonsten bei
		 * hohen eingegebenen Werten die Tabelle unschön verrückt (da ja
		 * mehrstellige Zahlen mehr Platz benötigen)
		 */

		// Deklaration
		int x, y, i, j;
		int eingabe;

		// Initialisierung
		j = 1;
		eingabe = read();

		// Ausgabe der ersten Zeile (Beschriftung Anzahl Spalten)
		System.out.print("\t");
		while (j <= eingabe) {
			System.out.print(j + "\t");
			j++;
		}
		System.out.print("\n");

		// j muss nun wieder auf 1 zurückgesetzt werden
		j = 1;

		/*
		 * äußere Schleife: setzt 'i' jedes mal wieder auf 1 zurück, sonst wäre
		 * die Bedingung der inneren Schleife nach dem ersten Durchgang erfüllt
		 */
		while (j <= eingabe) {
			i = 1;
			
			/*
			 * innere Schleife: x und y müssen nach jedem Algorithmus Durchlauf
			 * neu die aktualisierten Werte übergeben werden
			 */
			System.out.print(j + "\t");
			while (i <= eingabe) {
				x = i;
				y = j;

				// ggT Algorithmus
				while (x != y) {
					if (x < y) {
						y = y - x;
					} else {
						x = x - y;
					}
				}
				
				System.out.print(x + "\t");
				i++;
			}
			System.out.print("\n");
			j++;
		}
	}
}