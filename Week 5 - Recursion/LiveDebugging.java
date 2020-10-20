public class LiveDebugging {

	static int a = 5;
	static int b = 6;
	static int c = 7;
	
	
	public static void main(String[] args) {

		System.out.println(a);
		int a = 0;
		System.out.print(a);
		eineMethode(3);
	}
	
	public static int eineMethode(int b) {
		int c = 0;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		return b;
	}

}
