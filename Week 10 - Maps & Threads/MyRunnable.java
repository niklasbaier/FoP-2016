public class MyRunnable implements Runnable {
	
	public void hello(String s) {
		System.out.println(s);
	}
	
	public void run() {
		hello("I'm running ...");
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable());
		t.start();
		System.out.println("Thread has been started ...");
	}
}
