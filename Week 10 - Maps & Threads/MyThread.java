public class MyThread extends Thread {
	
	public void hello(String s) {
		System.out.println(s);
	}
	
	public void run() {
		hello("I'm running ...");
	}
	
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		System.out.println("Thread has been started ...");
	}
}