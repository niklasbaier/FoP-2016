package pgdp;

public class Bank {

	// NOTIZ AN MICH: Die Liste accounts zeigt auf andere Listen, ist sozusagen wie ein head
	// HINWEIS: Ist ein Konto einmal geloescht, so wird seine Kontonummer NICHT freigegeben
	
	// Member Variablen
	private BankAccountList accounts;
	
	// Methoden
	public int newAccount(String firstname, String lastname) {
		BankAccountList add = new BankAccountList();
		// erstes Element
		if(accounts == null) {
			add.info = new BankAccount(1, firstname, lastname);
			accounts = add;
			return add.info.getAccountnumber();
		}
		// weitere Elemente
		add.info = new BankAccount(1 + lastAccountnumber(), firstname, lastname);
		BankAccountList tmp = accounts;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = add;
		return add.info.getAccountnumber();
	}
	
	public void removeAccount(int accountnumber) {
		if(findAccount(accountnumber) == null) {
			System.out.println("Fehler: Ein Konto mit dieser Kontonummer existiert nicht.");
			return;
		}
		// erstes Listenelement wird geloescht
		if(accounts.info.getAccountnumber() == accountnumber) {
			accounts = accounts.next;
			return;
		}
		BankAccountList tmp = accounts;
		while(tmp.next.info.getAccountnumber() != accountnumber) {
			tmp = tmp.next;
		}
		// tmp verweist nun auf den Account, der vor demjenigen liegt, der geloescht werden soll
		tmp.next = tmp.next.next;
	}
	
	public Money getBalance(int accountnumber) {
		if(findAccount(accountnumber) == null) {
			return null;
		}
		return findAccount(accountnumber).getBalance();
	}
	
	public boolean depositOrWithdraw(int accountnumber, Money m) {
		if(findAccount(accountnumber) == null) {
			return false;
		}
		findAccount(accountnumber).addMoney(m);
		return true;
	}
	
	public boolean transfer(int from, int to, Money m) {
		if(findAccount(from) != null && findAccount(to) != null) {
			Money f = new Money(-1*m.getCent());
			depositOrWithdraw(from, f);
			depositOrWithdraw(to, m);
			return true;
		}
		return false;
	}
	
	// Hilfsmethoden
	public int lastAccountnumber() {
		BankAccountList tmp = accounts;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		return tmp.info.getAccountnumber();
	}
	
	public BankAccount findAccount(int accountnumber) {
		BankAccountList tmp = accounts;
		while(tmp != null) {
			if(tmp.info.getAccountnumber() == accountnumber) {
				return tmp.info;
			}
			tmp = tmp.next;
		}
		return null;
	}
	
	// Ausgabe fuer Testzwecke
	@Override
	public String toString() {
		BankAccountList tmp = accounts;
		String out = "\n\n\n|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|\n";
		out += "|\n| Die Bank haelt derzeit folgende Konten:\n|\n";
		while(tmp != null) {
			out += tmp.info.toString();
			tmp = tmp.next;
		}
		out += "|\n|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|\n\n\n";
		return out;
	}
	
	private class BankAccountList {	
		
		public BankAccount info;	// Listenelement beinhaltet ein Konto
		public BankAccountList next;	// next pointer auf nächstes Listenelement
	}
}