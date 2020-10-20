public class Kaninchenproblem extends MiniJava {

	public static void main(String[] args) {

		// Deklaration
		int x_alt, y_alt, z_alt, x, y, z, n, i;

		// Initialisierung
		x_alt = 1;
		y_alt = 0;
		z_alt = 0;
		x = 0;
		y = 0;
		z = 0;
		i = 1;

		n = read();
		System.out.print("Monat" + "\t1. Generation" + "\t2. Generation" + "\t3. Generation" + "\n");

		while (i <= n) {
			
			// Behandelt die Initialisierung, sprich den 1. Monat
			if (y_alt == 0) {
				x = x_alt + y_alt + z_alt;
				y = y_alt;
				z = z_alt;

				/* falls alle Zeilen (auch die der vorherigen Monate) ausgegeben
				   werden sollen
				System.out.print(i + "\t\t" + x + "\t\t" + y + "\t\t" + z + "\n"); */
				
				// falls nur der erste Monat ausgegeben werden soll
				if(n == 1) {
					System.out.print(i + "\t\t" + x + "\t\t" + y + "\t\t" + z + "\n");
					return;
				}
				i++;
			}

			/*
			 * Bezieht sich auf die restlichen Iterationen, 3*y_alt, da jedes
			 * Kaninchenpaar in der 2. Generation jeweils 3 weitere
			 * Kaninchenpaare zur Welt bringt
			 */
			x = x_alt + 3 * y_alt + z_alt;
			y = x_alt;
			z = y_alt;
			
			/* falls alle Zeilen (auch die der vorherigen Monate) ausgegeben
			werden sollen
			System.out.print(i + "\t\t" + x + "\t\t" + y + "\t\t" + z + "\n"); */
			x_alt = x;
			y_alt = y;
			z_alt = z;
			i++;
		}

		//falls nur die Zeile des n-ten Monats ausgegeben werden soll
		System.out.print(i-1 + "\t\t" + x + "\t\t" + y + "\t\t" + z + "\n");
	}
}
