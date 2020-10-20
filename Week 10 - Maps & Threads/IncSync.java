public class IncSync implements Runnable {

	private static Count x = new Count();
	
	public void run() {
		x.inc();
	}
	
	public static void main(String[] args) {
		(new Thread(new IncSync())).start();
		(new Thread(new IncSync())).start();
		(new Thread(new IncSync())).start();
	}
}
