public class RekursionBeispiele {

	// Binäre Suche
	public static int binarySearch(int elem, int[] a, int low, int high) {
		if(low > high) {
			return -1;
		}
		int m = (low + high) / 2;
		if(elem == a[m]) {
			return m;
		}
		if(elem < a[m]) {
			return binarySearch(elem, a, low, m - 1);
		}
		return binarySearch(elem, a, m + 1, high);
	}
	
	// Größter gemeinsamer Teiler
	public static int gcd(int x, int y) {
		int rest = x % y;
		if(rest == 0) {
			return y;
		} else {
			return gcd(y, rest);
		}
	}
	
	// Fibonacci-Funktion
	// fib(n) = 1								für n = 1, 2 und
	// fib(n) = fib(n - 1) + fib(n - 2)			für n > 2
	public static int fib(int n) {
		if(n <= 2) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
	
	// Ackermann-Funktion
	//				m + 1						falls n = 0
	// ack(n, m) =	ack(n - 1, 1)				falls m = 0
	//				ack(n - 1, ack(n, m - 1))	sonst
	public static int ack(int n, int m) {
		if(n == 0) {
			return m + 1;
		} else if(m == 0) {
			return ack(n - 1, 1);
		} else {
			return ack(n - 1, ack(n, m - 1));
		}
	}
	
	// Fakultät
	public static int fak(int n) {
		if(n == 1) {
			return 1;
		} else {
			return n * fak(n - 1);
		}
	}
	
	// Multiplikation
	public static int mult(int x, int y) {
		if(y == 1) {
			return x;
		} else {
			return x + mult(x, y - 1);
		}
	}
	
}
