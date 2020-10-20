public class Count {
	
	private int count = 0;
	
	public synchronized void inc() {
		String s = Thread.currentThread().getName();
		int y = count;
		System.out.println(s + " read " + y);
		count = y + 1;
		System.out.println(s + " wrote " + count);
	}
}
