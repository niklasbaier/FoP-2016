public class Map implements Runnable {

	private int counter = 0;
	
	public static <T, R> void map(Fun<T, R> f, T[] a, R[] b, int n) {
		// Threads erstellen
		Thread[] threads = new Thread[n];
		for(int i = 0; i < n; i++) {	
			threads[i] = new Thread(new Map() {
				@Override
				public void run() {
					System.out.println("Thread wurde gestartet!");
					for(int j = 0; j < a.length / n; j++) {
						b[j] = (R) f.apply(a[j]);
					}
					System.out.println("Thread Ende!");
				}
			});
			threads[i].start();
		}
	}
	
	public void run() {
		//Override
	}
	
	public static void main(String[] args) {
		Integer[] a = {1, 2, 3, 4, 5};
		String[] b = new String[5];
		int n = 2;
		for(int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		map(new IntToString(), a, b, n);
		int j = 0;
		while(j < 10000000) {
			j++;
		}
		for(int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}