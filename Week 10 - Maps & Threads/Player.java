import java.util.Random;

public class Player implements Runnable {

	private int i = -1;
	public boolean lock;
	private int times;
	private int counter;
	public int n;
	
	public Player(int n, int times) {
		this.n = n;
		this.times = times;
		this.counter = 0;
	}
	
	public void run() {
		System.out.println("Thread(" + n + ") has been started!");
		while(true) {
			try {
				setChoice();
			} catch(InterruptedException e) {
				break;
			}
		}
	}
	
	public synchronized int getChoice() throws InterruptedException {
		if(Thread.interrupted() || counter == times) {
			throw new InterruptedException();
		} else {
			while(lock == false) {
				wait();
			}
			//System.out.println("Thread(" + n + "): get i = " + i);
			counter++;
			return i;
		}
	}
	
	// Eigene Methoden
	public synchronized void setChoice() throws InterruptedException {
		if(Thread.interrupted() || counter == times) {
			throw new InterruptedException();
		} else {
			while(lock == true) {
				wait();
			}
			i = (new Random()).nextInt(3);
			//System.out.println("Thread (" + n + "): set i = " + i);
			setLock();
		}
	}
	
	public synchronized void setLock() {
		lock = !lock;
		notify();
	}
	
}