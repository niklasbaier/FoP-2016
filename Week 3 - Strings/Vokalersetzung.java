public class Vokalersetzung extends MiniJava {

    public static void main(String[] args) {

        String text = "Hat der alte Hexenmeister\n" +
        			"sich doch einmal wegbegeben!\n" +
        			"Und nun sollen seine Geister\n" +
        			"auch nach meinem Willen leben.\n" +
        			"Seine Wort und Werke\n" +
        			"merkt ich und den Brauch,\n" +
        			"und mit Geistesstärke\n" +
        			"tu ich Wunder auch.\n" +
        			"Walle! walle\n" +
        			"Manche Strecke,\n" +
        			"daß, zum Zwecke,\n" +
        			"Wasser fließe\n" +
        			"und mit reichem, vollem Schwalle\n" +
        			"zu dem Bade sich ergieße.";
        String ausgabe = "";
        String input = ""; 
        int length = -1, buchstabe;
        
        while(length != 1) {
        	if(length == -1) {
        		input = readString("Durch welchen Vokal sollen die Vokale ersetzt werden?");
        		length = input.length();
        	} else {
        		input = readString("Die Eingabe ist zu lang! Bitte geben Sie nur einen Vokal an.");
        		length = input.length();
        	}	
        }
        
        char v = input.charAt(0);
        int vi = (int) v;
        
        System.out.print(vi);
        
       if(vi >= 97 && vi <= 122) {
    	   buchstabe = 0;
       } else {
    	   buchstabe = 1;
       }
        
        char[] vokale = { ' ', 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' };
        int counter, counter2, laufvariable = 0;
        char c = 0;
        
        length = text.length();
        
        for(counter = 0; counter < length; counter++) {
        	laufvariable = 0;
        	
        	for(counter2 = 0; counter2 < 11; counter2++) {
        		if(text.charAt(counter) == vokale[counter2]) {
            		laufvariable = counter2;
            	}
        	}
        	
        	if(laufvariable == 0) {
        		c = text.charAt(counter);
        	} else {
        		c = input.charAt(0);
        	}
        	
         	ausgabe = ausgabe + c;
        }       
        write(ausgabe);
    }
}