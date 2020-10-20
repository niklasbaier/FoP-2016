public class Seiteneffekte {

	public static void main(String[] args) {
		
		// 1. Aufgabe
		int b, c;
		int b1, c1;
		
		b = 5;
		c = b++ + ++b - --b;
		System.out.print(c);
		
		b1 = 5;
		c1 = b1;
		b1 = b1 + 1;
		b1 = b1 + 1;
		c1 = c1 + b1;
		b1 = b1 - 1;
		c1 = c1 - b1;
		System.out.print("\n" + c1);
		
		// 2. Aufgabe
		System.out.print("\n\n");
		int a, d;
		int a1, d1;
		
		d = 5;
		a = d + 1 - --d;
		System.out.print(a);
		
		d1 = 5;
		a1 = d1;
		a1 = a1 + 1;
		d1 = d1 - 1;
		a1 = a1 - d1;
		System.out.print("\n" + a1);
		
		// 3. Aufgabe
		System.out.print("\n\n");
		int e, f;
		int e1, f1;
		
		f = 5;
		e = f++ + f++ + f++;
		System.out.print(e);
		
		f1 = 5;
		e1 = f1;
		f1 = f1 + 1;
		e1 = e1 + f1;
		f1 = f1 + 1;
		e1 = e1 + f1;
		f1 = f1 + 1;
		System.out.print("\n" + e1);
	}

}
