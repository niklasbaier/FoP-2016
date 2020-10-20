package pgdp;

public class BankAccount {

	// Member Variablen
	private int bankaccount;
	private String firstname;
	private String lastname;
	private Money balance;
	
	// Konstruktor
	public BankAccount(int accountnumber, String fname, String sname) {
		this.bankaccount = accountnumber;
		this.firstname = fname;
		this.lastname = sname;
		this.balance = new Money();
	}
	
	// Methoden
	public int getAccountnumber() {
		return bankaccount;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getSurname() {
		return lastname;
	}
	
	public Money getBalance() {
		return balance;
	}
	
	public void addMoney(Money m) {
		this.balance = this.balance.addMoney(m);
	}
	
	@ Override
	public String toString() {
		String out = "|------------ BankAccount ------------|\n|\n";
		out += "| Account holder:\t" + getFirstname() + " " + getSurname() + "\n";
		out += "| Account number:\t" + getAccountnumber() + "\n";
		out += "| Current balance:\t" + getBalance() + "\n";
		out += "|\n|------------ XXXXXXXXXXX ------------|\n";
		return out;
	}
}
