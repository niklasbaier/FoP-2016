public class SymmetricStackMain extends SymmetricStack {

	public static void print(SymmetricStack stack) {
		System.out.println("first: " + stack.getFirst() + "\tlast: " + stack.getLast());
		System.out.println(stack.toString());
		System.out.println("elements: " + stack.getNumberOfElements());
		System.out.println("|------------------------------------|");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialisierung
		System.out.println("- INITIALISIERUNG -");
		SymmetricStack stack = new SymmetricStack();
		print(stack);
		int c = 0;
		
		while(c < 2) {
			// Append
			System.out.println("- APPEND -");
			for(int i = 1; i < 10; i++) {
				stack.append(i);
			}
			print(stack);
			
			// Prepend
			System.out.println("- PREPREND -");
			for(int i = 10; i < 17; i++) {
				stack.prepend(i);
			}
			print(stack);
			stack.prepend(17);
			print(stack);
			
			// RemoveFirst
			System.out.println("- REMOVEFIRST -");
			for(int i = 1; i < 13; i++) {
				stack.removeFirst();
			}
			print(stack);
			stack.removeFirst();
			print(stack);
			
			// RemoveLast
			System.out.println("- REMOVELAST -");
			for(int i = 1; i < 4; i++) {
				stack.removeLast();
			}
			print(stack);
			stack.removeFirst();
			print(stack);
			c++;
		}
	}
}