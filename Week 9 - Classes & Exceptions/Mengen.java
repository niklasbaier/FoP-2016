
public class Mengen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> p = new Set<String>();
		p = p.add("a");
		p = p.add("b");
		p = p.add("cdf");
		System.out.println(p);
		System.out.println(p.size());

		Set<String> q = new Set<String>();
		q = q.add("b");
		q = q.add("a");
		q = q.add("cdf");
		System.out.println(q);
		System.out.println(q.contains("cdf"));

		System.out.println(p.equals(q));
	}

}
