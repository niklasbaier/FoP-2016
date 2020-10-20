package pgdp;

public class MoneyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialisierung
		Bank b = new Bank();
		
		// newAccount
		b.newAccount("Sonja", "Schotte");
		b.newAccount("Kaan", "Bulut");
		b.newAccount("Julian", "Boell");
		b.newAccount("Tobias", "Baldauf");
		b.newAccount("Thomas", "Schramowski");
		System.out.println(b);
		
		// depositOrWithdraw
		b.depositOrWithdraw(1, new Money(30000));
		b.depositOrWithdraw(2, new Money(80000));
		b.depositOrWithdraw(3, new Money(2000));
		b.depositOrWithdraw(4, new Money(-1000));
		b.depositOrWithdraw(5, new Money(312315));
		System.out.println(b);
		
		// getBalance
		System.out.println("Balance is: " + b.getBalance(1));
		System.out.println("Balance is: " + b.getBalance(2));
		System.out.println("Balance is: " + b.getBalance(3));
		System.out.println("Balance is: " + b.getBalance(4));
		System.out.println("Balance is: " + b.getBalance(5));
		
		// transfer
		System.out.println();
		b.transfer(1, 2, new Money(2000));
		System.out.println("Balance is: " + b.getBalance(1));
		System.out.println("Balance is: " + b.getBalance(2));
		b.transfer(3, 3, new Money(2000));
		System.out.println("Balance is: " + b.getBalance(3));
		b.transfer(4, 5, new Money(-2000));
		System.out.println("Balance is: " + b.getBalance(4));
		System.out.println("Balance is: " + b.getBalance(5));
		
		// print
		b.depositOrWithdraw(4, new Money(-2000));
		System.out.println(b);
		
		// remove
		b.removeAccount(2);
		b.depositOrWithdraw(2, new Money(80000));
		System.out.println("Balance is: " + b.getBalance(2));
		b.removeAccount(5);
		System.out.println(b);
		b.removeAccount(1);
		System.out.println(b);
		b.removeAccount(3);
		b.removeAccount(4);
		System.out.println(b);
		
		// newGame
		b.newAccount("Niklas", "Baier");
		b.depositOrWithdraw(1, new Money(1000000000));
		System.out.println(b);
	}
}