public class Ablage extends MiniJava {

	public static void main(String[] args) {

		int x, y, z, i = 1, j = 1;
		y = read();

		// Schleife
		
		
		while(j <= y) {
		// Zeilen
		while (i <= y) {
			x = i;
			z = j;
			
			// ggT Algorithmus
			while (x != z) {
				if (x < z) {
					z = z - x;
				} else {
					x = x - z;
				}
			}
			System.out.print(x + "\t");
			i++;
		}
		j++;
		}
	}
}