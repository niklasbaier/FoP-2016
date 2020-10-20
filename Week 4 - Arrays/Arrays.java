public class Arrays {

	/*
	 * gibt das Array feld auf der Konsole aus
	 */
	public static void print(int[] feld) {

		System.out.print("{");
		for(int i = 0; i < feld.length; i++) {
			System.out.print(feld[i]);
			if(i != feld.length - 1) {
				System.out.print(", ");	
			}
		}
		System.out.print("}\n");
	}

	/*
	 * gibt Minimum und Maximum des Arrays feld auf der Konsole aus
	 */
	public static void minUndMax(int[] feld) {

		int min = feld[0], max = feld[0];
		
		for(int i = 1; i < feld.length; i++) {
			if(feld[i] < min) {
				min = feld[i];
			} else if(feld[i] > max) {
				max = feld[i];
			}
		}
		System.out.print("Minimum = " + min + ", Maximum = " + max + ".\n");
	}

	/*
	 * gibt ein neues Array zurück, das die Elemente von feld in umgekehrter
	 * Reihenfolge enthält
	 */
	public static int[] invertieren(int[] feld) {

		int[] invert = new int[feld.length];
		int j = feld.length - 1;
		
		for(int i = 0; i < feld.length; i++) {
			invert[j] = feld[i];
			j--;
		}
		return invert;
	}

	/*
	 * gibt ein neues Array zurück, dass laenge Zeichen lang ist und die
	 * Elemente von feld in der gleichen Reihenfolge und so viele wie möglich
	 * enthält
	 */
	public static int[] schneiden(int[] feld, int laenge) {

		int[] cut = new int[laenge];
		
		if(laenge > feld.length) {
			for(int i = 0; i < feld.length; i++) {
				cut[i] = feld[i];
			}
			for(int i = feld.length; i < laenge; i++) {
				cut[i] = 0;
			}
		} else {
			for(int i = 0; i < laenge; i++) {
				cut[i] = feld[i];
			}	
		}
		return cut;
	}

	/*
	 * gibt ein neues eindimensionales Array zurück, das die Werte des
	 * übergebenen zweidimensionalen Arrays feld enthält
	 */
	public static int[] linearisieren(int[][] feld) {
		
		int l = 0;
		for(int i = 0; i < feld.length; i++) {
			l = l + feld[i].length;
			}
		int[] lin = new int[l];
		
		for(int i = 0; i < l; i++) {
			for(int j = 0; j < feld.length; j++) {
				for(int k = 0; k < feld[j].length; k++) {
					lin[i] = feld[j][k];
					i++;
				}
			}
		}
		return lin;
		}

	public static void main(String[] args) {

		// print
		int[] a = {1, 2, 3, 4, 5};
		print(a);
		System.out.print("\n");
		
		// minUndMax
		int[] b = {1, 10, 25, -13, 1000};
		minUndMax(b);
		System.out.print("\n");
		
		// invertieren
		int[] c = {0, 1, 2, 3};
		print(invertieren(c));
		System.out.print("\n");
		
		// schneiden
		int[] d = {1, 2, 3};
		print(schneiden(d, 3));
		print(schneiden(d, 5));
		System.out.print("\n");
		
		// linearisieren
		int[][] e = {{1, 3}, {25}, {7, 4, 6, 9}};
		print(linearisieren(e));
		System.out.print("\n");
	}
}
