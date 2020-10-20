public class Buffer{

	// Es fehlt die Implementierung der Klasse Data
	
	private int cap, first, last;
	private Sema free, occupied;
	private Data[] a;
	
	public Buffer(int n) {
		cap = n;
		first = last = 0;
		a = new Data[n];
		free = new Sema(n);
		occupied = new Sema(0);
	}
	
	// Methoden sind nicht synchronized
	public void produce(Data d) throws InterruptedException {
		free.down();
		synchronized(this) {
			a[last] = d;
			last = (last + 1) % cap;
		}
		occupied.up();
	}
	
	public Data consume() throws InterruptedException {
		Data result;
		occupied.down();
		synchronized(this) {
			result = a[first];
			first = (first + 1) % cap;
		}
		free.up();
		return result;
	}
}
