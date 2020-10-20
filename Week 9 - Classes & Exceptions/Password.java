public class Password {

	final private int nrUpperShould;
	final private int nrLowerShould;
	final private int nrSpecialShould;
	final private int nrNumbersShould;
	final private int lengthShould;
	final private char[] illegalChars;
	
	public Password(int nrUpperShould, int nrLowerShould, int nrSpecialShould, int nrNumbersShould, int lengthShould, char[] illegalChars) {
		this.nrUpperShould = nrUpperShould;
		this.nrLowerShould = nrLowerShould;
		this.nrSpecialShould = nrSpecialShould;
		this.nrNumbersShould = nrNumbersShould;
		this.lengthShould = lengthShould;
		this.illegalChars = illegalChars;
	}
	
	public void checkFormat(String pwd) throws IllegalCharExc, NotEnoughExc, NotLongEnoughExc {
		
		// NotLongEnough
		if(pwd.length() < lengthShould) {
			throw new NotLongEnoughExc(lengthShould, pwd.length());
		}
		
		int c = 0;
		// NotEnoughLetter
			// Grossbuchstaben in ASCII: 65 - 90
		for(int i = 0; i < pwd.length(); i++) {
			if(pwd.charAt(i) >= 65 && pwd.charAt(i) <= 90) {
				c++;
			}
		}
		if(c < nrUpperShould) {
			throw new NotEnoughUpper(nrUpperShould, c);
		}
			// Kleinbuchstaben in ASCII: 97 - 122
		c = 0;
		for(int i = 0; i < pwd.length(); i++) {
			if(pwd.charAt(i) >= 97 && pwd.charAt(i) <= 122) {
				c++;
			}
		}
		if(c < nrLowerShould) {
			throw new NotEnoughLower(nrLowerShould, c);
		}
		
		// NotEnoughSpecial
			// Sonderzeichen in ASCII: 0 - 255 ausser: 48 - 57, 65 - 90, 97 - 122
		c = 0;
		for(int i = 0; i < pwd.length(); i++) {
			if(pwd.charAt(i) >= 48 && pwd.charAt(i) <= 57 || pwd.charAt(i) >= 65 && pwd.charAt(i) <= 90 || pwd.charAt(i) >= 97 && pwd.charAt(i) <= 122) {
			} else {
				c++;
			}
		}
		if(c < nrSpecialShould) {
			throw new NotEnoughSpecial(nrSpecialShould, c);
		}
		
		// NotEnoughNumber
		c = 0;
			// Numbers in ASCII: 48 - 57
		for(int i = 0; i < pwd.length(); i++) {
			if(pwd.charAt(i) >= 48 && pwd.charAt(i) <= 57) {
				c++;
			}
		}
		if(c < nrNumbersShould) {
			throw new NotEnoughNumber(nrNumbersShould, c);
		}
		
		// IllegalChars
		for(int i = 0; i < illegalChars.length; i++) {
			for(int j = 0; j < pwd.length(); j++) {
				if(pwd.charAt(j) == illegalChars[i]) {
					throw new IllegalCharExc(illegalChars[i]);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a = {'a', '1', '!', '\n'};
		Password p = new Password(2, 2, 2, 2, 6, a);
		String s = "Ge23\r=?456bG";

		try {
			p.checkFormat(s);
		} catch (NotLongEnoughExc e) {
			System.out.println(e.toString());
		} catch (IllegalCharExc i) {
			System.out.println(i.toString());
		} catch(NotEnoughExc n) {
			System.out.println(n.toString());
		}
	}
	
}
