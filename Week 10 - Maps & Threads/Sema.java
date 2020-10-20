public class Sema {

	private int x;
	
	public Sema(int n) {
		x = n;
	}
	
	public synchronized void up() {
		x++;
		if(x <= 0) {
			this.notify();
		}
	}
	
	public synchronized void down() throws InterruptedException {
		x--;
		while(x < 0) {
			this.wait();
		}
	}
}
