public class Adding extends MiniJava {

	public static int getInt(String str) {
		String s;
		while(true) {
			try {
				s = readString(str);
				return Integer.parseInt(s);
			} catch(NumberFormatException e) {
				System.out.println("Falsche eingabe! ...");
			}
		}
	}
	
	public static void main(String[] args) {
		int x = getInt("1. Zahl:\t");
		int y = getInt("2. Zahl:\t");
		write("Summe:\t\t" + (x + y));
	}
}
