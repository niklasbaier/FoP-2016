public class CW implements Runnable {

	private static int count = 0;
	private int n = count++;
	private static Thread[] task = new Thread[3];
	
	public void run() {
		try {
			task[(n+1) % 3].join();
		} catch(InterruptedException e) {
			System.err.println(e.toString());
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 3; i++) {
			task[i] = new Thread(new CW());
		}
		for(int i = 0; i < 3; i++) {
			task[i].start();
		}
	}
}
