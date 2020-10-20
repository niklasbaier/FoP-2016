public class Start extends Thread {

	public void run() {
		System.out.println("I'm running ...");
		while(true);
	}
	
	public static void main(String[] args) {
		(new Start()).start();
		(new Start()).start();
		(new Start()).start();
		System.out.println("main is running ...");
		while(true);
	}
}
