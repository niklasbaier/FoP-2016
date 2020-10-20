/**
 * Die Klasse Main enthaelt das Hauptprogramm.
 *
 * Im Hauptprogramm wird zuerst der Benutzer gefragt,
 * wer das Spiel beginnen soll.
 *
 * Dann wird das Spiel gestartet.
 *
 */
public class Main {

    public static void main(String args[]) {
        //TODO
    	String player = "";
    	boolean ladiesFirst = false;
    	while(true) {
    		player = IO.readString("Wer soll das Spiel beginnen?\nMaennchen (M) oder Weibchen (W)? ");
        	if(player.equals("W")) {
        		System.out.println();
        		System.out.println("Die Weibchen (W) beginnen.");
        		ladiesFirst = true;
        		break;
        	} else if(player.equals("M")) {
        		System.out.println();
        		System.out.println("Die Maennchen (M) beginnen.");
        		break;
        	}
    		System.out.println();
        	System.out.println("Bitte entweder 'M' oder 'W' eingeben.");
    	}
    	// Spiel wird gestartet
        System.out.println("|--------------------|");
    	Game g = new Game();
    	g.startGame(ladiesFirst);
    }

}
