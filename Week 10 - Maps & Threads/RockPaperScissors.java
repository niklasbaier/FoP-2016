public class RockPaperScissors implements Runnable {

	private int wins1 = 0;
	private int wins2 = 0;
	private int neutral = 0;

	public void run() {
		Player p1 = new Player(1, 1000);
		Player p2 = new Player(2, 1000);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		t1.start();
		t2.start();
		while(true) {
			try {
				int x = p1.getChoice();
				int y = p2.getChoice();
				System.out.println("p1: " + transform(x));
				System.out.println("p2: " + transform(y));
				wins(x, y);
				p1.setLock();
				p2.setLock();
			} catch(InterruptedException e) {
				// andere Threads unterbrechen
				t1.interrupt();
				t2.interrupt();
				break;
			}
		}
		result();
	}
	
	private String transform(int i) {
		if(i == 0) {
			return "Schere";
		} else if(i == 1) {
			return "Stein";
		} else {
			return "Papier";
		}
	}
	
	private void wins(int x, int y) {
		if(x == y) {
			System.out.println("Unentschieden.");
			neutral++;
		} else {
			if(x == 0) {
				if(y == 1) {
					System.out.println("Schere verliert gegen Stein");
					wins2++;
				} else {
					System.out.println("Schere gewinnt gegen Papier");
					wins1++;
				}
			}
			
			if(x == 1) {
				if(y == 2) {
					System.out.println("Stein verliert gegen Papier");
					wins2++;
				} else {
					System.out.println("Stein gewinnt gegen Schere");
					wins1++;
				}
			}
			
			if(x == 2) {
				if(y == 0) {
					System.out.println("Papier verliert gegen Schere");
					wins2++;
				} else {
					System.out.println("Papier gewinnt gegen Stein.");
					wins1++;
				}
			}
		}
	}
	
	private void result() {
		System.out.println("|----------------------------|");
		System.out.println("XXXXXXXXXX RESULTS XXXXXXXXXXX");
		System.out.println("Wins Player 1:\t" + wins1);
		System.out.println("Wins Player 2:\t" + wins2);
		System.out.println("No winner:\t" + neutral);
		System.out.println("XXXXXXXXXX XXXXXXX XXXXXXXXXXX");
		System.out.println("|----------------------------|");
	}
	
	public static void main(String[] args) {
		Thread g = new Thread(new RockPaperScissors());
		g.start();
	}
}
