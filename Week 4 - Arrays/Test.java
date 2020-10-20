public class Test {

	private static int[][] spielfeld = new int[8][6];
   
	private static int[] pos_ziellinie = new int[12];
    private static int[] neg_ziellinie = new int[12];

    /**
     * initialisiert das Spielfeld 
     * Ziellinie fuer Spieler 1 ist Zeile 7
     * Ziellinie fuer Spieler -1 ist Zeile 0
     */
    private static void initSpiel() {
        for (int i = 0; i < spielfeld.length; i++) {
            if (i != 0 && i != spielfeld.length - 1) {
                spielfeld[i] = new int[]{-(12 - i + 1), 0, 0, 0, 0, 6 + i};
            }
            if (i == 0) {
                spielfeld[i] = new int[]{1, 2, 3, 4, 5, 6};
            }
            if (i == spielfeld.length - 1) {
                spielfeld[i] = new int[]{-6, -5, -4, -3, -2, -1};
            }
        }

    }

    /**
     *
     * @return formatiertes aktuelles Spielfeld
     */
    private static String output() {
        String tmp = "Spieler 1 spielt von oben nach unten\n"
                + "Spieler -1 spielt von unten nach oben\n";
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                tmp = tmp + "\t" + spielfeld[i][j];
            }
            tmp = tmp + "\n";
        }
        return tmp;
    }

    private static boolean spielende() {
        
    //TODO
    	int i, j;
    	int counter_neg = 0;
    	int counter_null = 0;
    	int counter[] = new int[8];
    	
    	for(i = 0; i < spielfeld.length; i++) {
    		for(j = 0; j < spielfeld[i].length; j++) {
    			if(spielfeld[i][j] < 0) {
    				counter_neg++;
    			} else if(spielfeld[i][j] > 0) {
    				counter_neg--;
    			} else if(spielfeld[i][j] == 0) {
    				counter_null++;
    			}
    		}
    
    		if(counter_neg + counter_null == 6) {
    			if(counter_neg > 0) {
        			// Reihe ist nur mit negativen Zahlen besetzt
        			counter[i] = -1;
    			} else {
    				// Reihe besteht nur aus Nullen
    				counter[i] = 0;
    			}
    		} else if(counter_neg - counter_null == -6) {
    			// Reihe besteht nur aus positiven Zahlen
    			counter[i] = 1;
    		} else {
    			// Reihe besteht sowohl aus negativen, als auch aus positiven Zahlen
    			counter[i] = 2;
    		}
    		
    		// Zurücksetzung der Zähler für die nächste Reihe
    		counter_neg = counter_null = 0;
    	}

    	// Formale Darstellung der Reihen
    	for(i = 0; i < counter.length; i++) {
    		System.out.print(counter[i]);
    		System.out.print("   ");
    	}
    	
    	i = 0; j = 0;
    	int x = 0;
    	
    	while(counter[i] == -1 || counter[i] == 0) {
    		i++;
    	}
    	
    	for(x = i; x < counter.length; x++)
    	if(counter[x] == 1) {
    		j++;
    	}
    	
    	System.out.print("\n");
    	
    	if(j == counter.length - i) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public static void main(String args[]) {

    	// Initialisierung des Spielfelds
        initSpiel();
    	spielfeld[0] = new int[] {0, 0, 0, 0, 0, 0};
    	spielfeld[1] = new int[] {0, 0, -1, -1, -1, 0};
    	spielfeld[2] = new int[] {0, 0, 0, 0, 0, 0};
    	spielfeld[3] = new int[] {-1, -1, -1, -1, -1, -1};
    	spielfeld[4] = new int[] {0, 0, 1, 1, 1, 0};
    	spielfeld[5] = new int[] {1, 1, 1, 1, 1, 0};
    	spielfeld[6] = new int[] {0, 0, 0, 1, 0, 0};
    	spielfeld[7] = new int[] {0, 0, 0, 0, 0, 0};
    	
        System.out.println(output());
        System.out.print(spielende());
       
        pos_ziellinie[0] = 1;
        pos_ziellinie[1] = 1;
        pos_ziellinie[2] = 1;
        
        neg_ziellinie[0] = -1;
        neg_ziellinie[0] = -1;
        neg_ziellinie[0] = -1;
        
        int punkte_pos, punkte_neg;
        int i = 0, j = 0;
        int counter_pos = 0;
        int counter_neg = 0;
        int counter_null = 0;
        
        while(pos_ziellinie[i] == 1) {
        	counter_pos++;
        	i++;
        }
        
        i = 0;
        while(neg_ziellinie[i] == -1) {
        	counter_neg++;
        	i++;
        }
        
        punkte_pos = 5*counter_pos;
        punkte_neg = -5*counter_neg;
        
        for(i = 0; i < spielfeld.length; i++) {
    		for(j = 0; j < spielfeld[i].length; j++) {
    			if(spielfeld[i][j] < 0) {
    				counter_neg++;
    			} else if(spielfeld[i][j] > 0) {
    				counter_neg--;
    			} else if(spielfeld[i][j] == 0) {
    				counter_null++;
    			}
    		}
        }
        
        i = 0;
        while(i < 12) {
        	if(i == 5) {
        		break;
        	}
        	i++;
        }
        
        System.out.print(i);
        
        
        
        
    }
}    