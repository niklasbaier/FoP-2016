public class NextTest {

	private static int[][] spielfeld = new int[8][6];
   
	private static int[] neg_ziellinie = { -1, -2, -3, -4, -11, -12, 0, 0, 0, 0, 0, 0 };
    private static int[] pos_ziellinie = { 1, 2, 5, 8, 10, 11, 12, 0, 0, 0, 0, 0 };

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
    
    private static boolean analysiereFeld(int stein) {
    	
    	for(int i = 0; i < spielfeld.length; i++) {
    		for(int j = 0; j < spielfeld[i].length; j++) {
    			if(spielfeld[i][j] == stein) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }
    
    private static int[] findeStein(int stein) {
        
    //TODO
    	int[] tmp = new int[2];
    	
    	for(int i = 0; i < spielfeld.length; i++) {
    		tmp[1] = i;
    		for(int j = 0; j < spielfeld[i].length; j++) {
    			tmp[0] = j;
    			if(stein == spielfeld[i][j]) {
    				return tmp;
    			}
    		}
    	}
    	
    	tmp[0] = -1;
    	tmp[1] = -1;
    	return tmp;
    }
    	
    
    private static boolean end() {
    	
    	int init_pos = 7;
    	int init_neg = 0;
    	int tmp[] = new int[2];
    	
    	// Spieler 1
    	for(int i = 1; i < 13; i++) {
    		if(analysiereFeld(i) == true) {
    			tmp = findeStein(i);
    			if(tmp[1] < init_pos) {
    				init_pos = tmp[1];
    			}
    		}
    	}
    	
		
    	// Spieler 2
    	for(int i = -1; i > -13; i--) {
    		if(analysiereFeld(i) == true) {
    			tmp = findeStein(i);
    			if(tmp[1] > init_neg) {
    				init_neg = tmp[1];
    			}
    		}
    	}

    	// Vergleich
    	if(init_neg - init_pos < 0) {
    		return true;
    	}
    	
    	return false;
    }
    
    public static void zaehlePunkte() {
    	
    	int[] pos_punkte = { -5, -3, -2, -1, 1, 2, 3, 5 };
    	int[] neg_punkte = { 5, 3, 2, 1, -1, -2, -3, -5 };
    	int pos_score = 0;
    	int neg_score = 0;
    	int counter = 0;
    	int tmp[] = new int[2];
    	
    	// Spieler 1
    	for(int i = 1; i < 13; i++) {
    		if(analysiereFeld(i) == true) {
    			tmp = findeStein(i);
    			pos_score = pos_score + pos_punkte[tmp[1]];
    		}
    	}
		while(counter < pos_ziellinie.length) {
			if(pos_ziellinie[counter] == 0) {
				break;
			}
			counter++;
		}
	
		pos_score = pos_score + 5*counter;
    	
    	// Spieler -1
    	for(int i = -1; i > -13; i--) {
    		if(analysiereFeld(i) == true) {
    			tmp = findeStein(i);
    			neg_score = neg_score + neg_punkte[tmp[1]];
    		}
    	}
    	counter = 0;
    	while(counter < neg_ziellinie.length) {
			if(neg_ziellinie[counter] == 0) {
				break;
			}
			counter++;
		}
	
		neg_score = neg_score + 5*counter;
    	
    	// Ausgabe
		System.out.print("|--------------------------------------------------|\n");
		System.out.print("Spieler 1:\t\t" + pos_score + "\nSpieler -1:\t\t" + neg_score);
    }
    
    
    public static void main(String args[]) {

    	// Initialisierung des Spielfelds
        initSpiel();
    	spielfeld[0] = new int[] {0, 0, 0, 0, 0, 0};
    	spielfeld[1] = new int[] {-8, 0, 0, 0, 0, 0};
    	spielfeld[2] = new int[] {-6, -7, -9, 0, 0, 0};
    	spielfeld[3] = new int[] {-10, -5, 0, 0, 0, 0};
    	spielfeld[4] = new int[] {4, 9, 0, 0, 0, 0};
    	spielfeld[5] = new int[] {0, 0, 0, 0, 0, 0};
    	spielfeld[6] = new int[] {0, 3, 6, 7, 0, 0};
    	spielfeld[7] = new int[] {0, 0, 0, 0, 0, 0};
    	
        System.out.println(output());
        System.out.print(end());
        zaehlePunkte();
    }
}