public class Inc implements Runnable {

	private static int x = 0;
	private static void pause(int t) {
		try {
			Thread.sleep((int) (Math.random()*t*1000));
		} catch(InterruptedException e) {
			System.err.println(e.toString());
		}
	}
	
	public void run() {
		String s = Thread.currentThread().getName();
		pause(3);
		int y = x;
		System.out.println(s + " read " + y);
		pause(4);
		x = y + 1;
		System.out.println(s + " wrote " + (y + 1));
	}
	
	public static void main(String[] args) {
		(new Thread(new Inc())).start();
		pause(2);
		(new Thread(new Inc())).start();
		pause(2);
		(new Thread(new Inc())).start();
	}
}
