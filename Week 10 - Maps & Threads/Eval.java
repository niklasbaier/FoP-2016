interface Func<T> {
	T func(int arg);
}
        	  
public class Eval<T> {
	void eval(Func<T> f, int[] arr, T[] res) {
		for(int i = 0; i < arr.length; i++) {
			res[i] = f.func(arr[i]);
		}
	}
	
	public static void main(String args[]) {
		int[] a = {1, 2, 3, 4, 5};
		String[] b = new String[5];
		new Eval<String>().eval(x -> "1" + x, a, b);
		for(int i = 0; i < 5; i++) {
			System.out.println(b[i] + ", ");
		}
	}
}
