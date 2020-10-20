public class Palindrom extends MiniJava {

	/*
	 * @return: String, der die gleiche Zeichenfolge ist wie input, wobei alle
	 * Großbuchstaben A bis Z in den entsprechenden Kleinbuchtaben umgewandelt
	 * sind
	 */
	public static String toLowerCase(String input) {
		
		char[] low = toCharArray(input);
		int pos;
		for(int i = 0; i < low.length; i++) {
			pos = (int) low[i];
			if(pos > 64 && pos < 91) {
				pos = pos + 32;
			}
			low[i] = (char) pos;
		}
		String output = "";
		for(int i = 0; i < low.length; i++) {
			output = output + low[i];
		}
		return output;
	}

	/*
	 * wandelt den String input in ein char-Array um und gibt diesen als Rückgabewert zurück
	 */
	public static char[] toCharArray(String input) {
		
		char[] arr = new char[input.length()];
		for(int i = 0; i < input.length(); i++) {
			arr[i] = input.charAt(i);
		}
		return arr;
	}

	/*
	 * bestimmt, ob es sich bei der gesamten Zeichenkette um ein Palindrom handelt
	 */
	public static boolean isPalindrome(char[] input) {

		char[] pal = new char[input.length];
		int j = input.length - 1;
		
		for(int i = 0; i < input.length; i++) {
			pal[j] = input[i];
			j--;
		}
		
		int i;
		for(i = 0; i < input.length; i++) {
			j = i;
			if(input[i] != pal[j]) {
				break;
			}
		}
		
		if(i == input.length) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		String input = "";
		int l = input.length();
		
		// String darf nicht leer sein
		while(l == 0) {
			input = readString();
			l = input.length();
		}
		
		boolean palindrom = isPalindrome(toCharArray(toLowerCase(input)));
		if(palindrom == true) {
			write("'" + input + "' ist ein Palindrom.");
		} else {
			write("'" + input + "' ist kein Palindrom.");
		}
	}
}