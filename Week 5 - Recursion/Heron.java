public class Heron extends MiniJava {

	public static double wurzel(int base, double start, double abw) {
		
		if(start*start < base + abw) {
			return start;
		} else {
			return wurzel(base, 0.5*(start + (base/start)), abw);	
		}
	}
	
	public static void main(String[] args) {
		
		int a = read("Von welcher Zahl moechtest du die Wurzel bestimmen?");
		int x0 = a + dice();
		double e = readDouble("Um welchen Betrag darf das Ergebnis von der tatsaechlichen Wurzel abweichen?");
		System.out.print("Wir fassen zusammen:\nreelle Zahl a:\t\t" + a + "\nStartwert x0:\t\t" + x0 + "\nAbweichung e\t\t" + e + "\n");
		System.out.print("|---------------------------|\nQuadratwurzel:\t\t" + wurzel(a, x0, e));
	}
}
