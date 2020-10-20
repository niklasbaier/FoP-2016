public class Set<T> {

	final private List<T> list;
	
	public Set() {
		// TODO
		this.list = new List<T>();
	}
	
	public Set(T e, List<T> s) {
		this.list = new List<T>(e, s);
	}
	
	public Set(List<T> s) {
		this.list = new List<T>(s);
	}
	
	public Set<T> add(T e) throws NullPointerException {
		// TODO
		if(e == null) {
			throw new NullPointerException();
		}
		if(contains(e)) {
			return this;
		}
		return new Set<T>(e, list);
	}
	
	public Set<T> remove(Object o) throws NullPointerException {
		// TODO
		if(o == null) {
			throw new NullPointerException();
		}
		if(!contains(o)) {
			return this;
		}
		return new Set<T>(list.remove(o, list));
	}
	
	public boolean contains(Object o) {
		// TODO
		if(list.contains(o)) {
			return true;
		}
		return false;
	}
	
	public int size() {
		// TODO
		return list.length();
	}
	
	public boolean equals(Object o) {
		// TODO
		if(o instanceof Set<?>) {
			// mit instanceof ueberpruefe ich ja, ob o vom Typ Set<T> ist, daher muesste der cast trotzdem safe sein
			Set<T> tmp = (Set<T>) o;
			return list.equals(this.list, tmp.list);
		}
		return false;
	}
	
	public String toString() {
		return list.toString();
	}
}
