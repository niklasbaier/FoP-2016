package pgdp;

public class Money {

	// Member Variable
	private int cent;
	
	// Konstruktoren
	public Money() {
		this.cent = 0;
	}
	
	public Money(int cent) {
		this.cent = cent;
	}
	
	// Methoden
	public int getCent() {
		return cent;
	}
	
	public Money addMoney(Money m) {
		Money add = new Money(this.cent + m.cent);
		return add;
	}
	
	@ Override
	public String toString() {
		int vk = getCent() / 100;	// Vorkommastelle
		int nk = getCent() % 100;	// Nachkommastelle
		boolean neg = false;
		String out = "";
		// Ueberpruefen der Negativitaet
		if(vk < 0) {
			nk *= -1;				// damit nicht beide neg sind
		} else if(nk < 0) {
			nk *= -1;				// sonst ist Vorzeichen nach dem Komma
			neg = true;
		}
		if(neg == true) {
			out = "-";
		}
		if(nk < 10) {
			out += vk + ",0" + nk + " Euro";
		} else {
			out += vk + "," + nk + " Euro";
		}
		return out;
	}
}
