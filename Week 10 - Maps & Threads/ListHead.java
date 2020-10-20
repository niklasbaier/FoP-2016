public class ListHead <K, V> {
	
	private List<K, V> list = null;
	private RW rw = new RW();
	
	public V lookup(K key) throws InterruptedException {
		rw.startRead();
		V result = (list == null) ? null : list.lookup(key);
		synchronized(rw) {
			rw.endRead();
			return result;
		}
	}
	
	public void update(K key, V value) throws InterruptedException {
		rw.startWrite();
		if(list == null) {
			list = new List<K, V>(key, value, null);
		} else {
			list.update(key, value);
			rw.endWrite();
		}
	}
}
