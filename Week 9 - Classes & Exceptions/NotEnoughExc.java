public class NotEnoughExc extends Exception {

	final int should;
	final int is;
	
	public NotEnoughExc(int should, int is) {
		this.should = should;
		this.is = is;
	}
	
	@Override
	public String toString() {
		return "";
	}
}
