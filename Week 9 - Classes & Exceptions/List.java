public class List<T> {
	
	final private T info;
	final private List<T> next;
	
	public List() {
		this.info = null;
		this.next = null;
	}
	
	public List(T info, List<T> list) {
		this.info = info;
		this.next = list;
	}
	
	public List(List<T> list) {
		this.info = list.info;
		this.next = list.next;
	}
	
	public List<T> remove(Object e, List<T> list) {
		if(length() == 1) {
			return null;
		}
		List<T> tmp = new List<T>();
		for(int i = 0; i < length(); i++) {
			if(!list.info.equals(e)) {
				tmp = new List<T>(list.info, tmp);
				list = list.next;
			} else {
				list = list.next;
			}
		}
		return tmp;
	}
	
	public String toString() {
		String out = "[";
		if(length() != 0) {
			List<T> tmp = this;
			while(tmp.next.next != null) {
				out += tmp.info + ", ";
				tmp = tmp.next;
			}
			out += tmp.info;
		}
        out += "]";
        return out;
	}
	
	// Hilfsmethoden
	public int length() {
		int x = 0;
		List<T> tmp = this;
		while(tmp.next != null) {
			x++;
			tmp = tmp.next;
		}
		return x;
	}
	
	public boolean contains(Object e) {
			List<T> tmp = this;
			while(tmp.next != null) {
				if(tmp.info.equals(e)) {
					return true;
				}
				tmp = tmp.next;
			}
		return false;
	}
	
	public boolean equals(List<T> e, List<T> f) {
		List<T> tmp = e;
		if(e.length() != f.length()) {
			return false;
		}
		while(tmp.next != null) {
			if(!f.contains(tmp.info)) {
				return false;
			}
			tmp = tmp.next;
		}
		return true;
	}
}
