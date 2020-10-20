public class Toolbox {

    /*
	 * berechnet die Summe aller ganzen geraden Zahlen von 0 bis einschliesslich n, falls n >= 0
	 * berechnet die Summe aller ganzen Zahlen von n bis 0, falls n < 0
	 * n aus [-10^4, +10^4]
	 */
    public static int evenSum(int n) {
        // TODO
    	if(odd(n) != 0) {
    		// n wird gerade gemacht
    		if(n < 0) {
    			n++;
    		} else {
    			n--;
    		}
    	}
    	// n ist gerade
    	if(n < 0) {
    		if(n == 0) {
    			return n;
    		} else {
    			return n + evenSum(n + 2);
    		}
    	} else {
    		if(n == 0) {
    			return n;
    		} else {
    			return n + evenSum(n - 2);
    		}
    	}		
    }

    /*
     * multipliziert zwei Integer x und y und liefert das Ergebnis zurueck;
     * fuer den Fall, dass eine der Zahlen oder beide 0 ist/sind, habe ich 
     * jetzt einfach mal 0 festgesetzt, da ich ja keinen boolean
     * returnen kann und eine andere Zahl zu Verwirrung fuehren koennte
     */
    public static int multiplication(int x, int y) {
        // TODO
    	if(x > 0 && y > 0 || x > 0 && y < 0) {
    		if(x == 1) {
        		return y;
        	} else {
        		return y + multiplication(x - 1, y);
        	}
    	}
    	if(x < 0 && y > 0) {
    		if(x == -1) {
    			return -y;
    		} else {
    			return -y + multiplication(x + 1, y);
    		}
    	} else if(x < 0 && y < 0) {
    		if(x == -1) {
    			return -y;
    		} else {
    			return -y + multiplication(x + 1, y);
    		}
    	}
    	return 0;
    }
    
    /*
     * kehrt die Reihenfolge der Elemente im Array um
     */
    public static void reverse(int[] m) {
        // TODO
    	int l = m.length;
    	int i = 0;
    	reverseHelp(m, i, l);
    }

    /*
     * gibt die Anzahl an ungeraden Integern aus dem Array zurueck
     */
    public static int numberOfOddIntegers(int[] m) {
        // TODO
    	int l = m.length;
    	int i = -1;
    	int p = 0;
    	return numberOfOddIntegersHelp(m, i, l, p);
    }

    /*
     * Ergebnis Array enthaelt genau alle ungeraden Integer aus dem Array
     */
    public static int[] filterOdd(int[] m) {
        // TODO
    	int l = m.length;
    	if(l == 0) {
    		return m;
    	} else if(l == 1) {
    		if(oddIntegers(m[0]) == 0) {
    			int [] u = new int[0];
    			return u;
    		} else {
    			return m;
    		}
    	}
    	int odd = numberOfOddIntegers(m);
    	int i = 0;
    	int[] fill = new int[l];
    	int[] cut = new int[odd];
    	return cutArray(fillArray(m, fill, i, i), cut, odd, 0);
    }
    
    
    
    // HILFSMETHODEN
    
    /*
     * bestimmt mittels den beiden Hilfsmethoden oddPos und oddNeg, ob die Zahl gerade oder ungerade ist
     */
    public static int odd(int n) {
    	
    	if(n > 0) {
    		return oddPos(n);
    	} else {
    		return oddNeg(n);
    	}
    }
    
    public static int oddPos(int n) {
    	
    	if(n <= 0) {
    		return n;
    	} else {
    		return oddPos(n - 2);
    	}
    }
    
    public static int oddNeg(int n) {
    	
    	if(n >= 0) {
    		return n;
    	} else {
    		return oddNeg(n + 2);
    	}
    } 
    
    /*
     * Hilfsmethode, um den Array aus reverse umzudrehen
     */
    public static void reverseHelp(int[] m, int i, int l) {
    	
    	int x;
    	if(odd(m.length) == 0) {
        	if(i > (m.length / 2) - 1) {
        		return;
        	}
        	x = m[i];
        	m[i] = m[l - 1];
        	m[l - 1] = x;
        	reverseHelp(m, i + 1, l - 1);
    	} else {
    		if(i > (m.length / 2)) {
        		return;
        	}
        	x = m[i];
        	m[i] = m[l - 1];
        	m[l - 1] = x;
        	reverseHelp(m, i + 1, l - 1);
    	}
    }
    
    /*
     * ueberprueft, ob ein Integer gerade oder ungerade ist (und gibt entweder 0 oder 1 aus)
     * Anmerkung: die oben definierten Methoden geben entweder -1, 0 oder 1 aus, da ich
     * jedoch fuer numberOfOddIntegers insgesamt wissen moechte, wie viele ungerade Zahlen es gibt,
     * seien sie nun positiv oder negativ, habe ich hier nochmals eine Methode konstruiert, die
     * mir nun nur noch 0 oder 1 ausgibt, sodass dieser Wert in einen Counter einfliessen kann
     */   
    public static int oddIntegers(int n) {
    	
    	if(n > 0) {
    		return -1*oddPos(n);
    	} else {
    		return oddNeg(n);
    	}
    }

    /*
     * dient als Counter fuer die Anzahl an ungeraden Zahlen innerhalb des Arrays
     */
    public static int numberOfOddIntegersHelp(int[] m, int i, int l, int p) {
    	
    	if(i == l - 1) {
    		return p;
    	} else {
        	return p + numberOfOddIntegersHelp(m, i + 1, l, oddIntegers(m[i + 1]));
    	}
    }
    
    /*
     * findet fuer den uebergebenen Array die Stelle der naechstliegenden ungeraden Zahl
     */
    public static int filterOddHelp(int[] m, int i, int x) {
    	
    	if(i < m.length) {
    		if(odd(m[i]) != 0) {
        		return x;
        	} else {
        		return filterOddHelp(m, i + 1, x + 1);
        	}
    	} else {
    		return x - 1;
    	}
    }
    
    /*
     * fuellt einen neuen Array mit nur den ungeraden Zahlen aus dem uebergebenen Array
     * fill wird der Methode null initialisiert uebergeben
     */
    public static int[] fillArray(int[] m, int[] fill, int i, int j) {
    	
    	j = filterOddHelp(m, j, j);
    	if(i == fill.length - 1) {
    		fill[i] = m[j];
    		return fill;
    	} else {
    		fill[i] = m[j];
    		return fillArray(m, fill, i + 1, j + 1);
    	}
    }
    
    /*
     * kuerzt den zuvor aufgefuellten Array auf die Laenge, die der Anzahl der ungeraden Zahlen im Array entspricht
     */
    public static int[] cutArray(int[] fill, int[] cut, int odd, int c) {
    	
    	if(c == odd) {
    		return cut;
    	} else {
    		cut[c] = fill[c];
    		return cutArray(fill, cut, odd, c + 1);
    	}
    }
}