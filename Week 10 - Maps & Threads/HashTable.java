public class HashTable <K, V> {

	// Es fehlt die Implementierung der Liste
	
	private RW rw;
	private List<K, V> [] a;
	private int n;
	
	public HashTable(int n) {
		rw = new RW();
		a = new List[n];
		this.n = n;
	}
	
	public V lookup (K key) throws InterruptedException {
		int i = Math.abs(key.hashCode()) % n;
		return a[i].lookup(key);
	}
	
	public void update (K key, V value) throws InterruptedException {
		int i = Math.abs(key.hashCode()) % n;
		a[i].update(key, value);
	}
}
