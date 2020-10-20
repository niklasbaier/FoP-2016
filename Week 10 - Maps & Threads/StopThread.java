public class StopThread extends Thread {

	private static boolean stopRequested;
	
	private static synchronized void setStop() {
		stopRequested = true;
	}
	
	private static synchronized boolean getStop() {
		return stopRequested;
	}
	
	public void run() {
		int i = 0;
		while(!getStop()) {
			i++;
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		Thread background = new StopThread();
		background.start();
		try {
			Thread.sleep(2);
		} catch(InterruptedException e) {
		}
		setStop();
	}
}
