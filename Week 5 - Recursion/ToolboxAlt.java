public class ToolboxAlt extends MiniJava {

	/*
	 * berechnet die Summe aller ganzen geraden Zahlen von 0 bis einschliesslich n, falls n >= 0
	 * berechnet die Summe aller ganzen Zahlen von n bis 0, falls n < 0
	 * n aus [-10^4, +10^4]
	 */
    public static int evenSum(int n) {
        // TODO
    	
    	// n ist ungerade (FIX: Modulo)
    	if(n % 2 != 0) {
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
     * multipliziert zwei Integer x und y und liefert das Ergebnis zurück
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
    			return y;
    		} else {
    			return -y - multiplication(x + 1, -y);
    		}
    	} else {
    		if(x == -1) {
    			return -y;
    		} else {
    			return -y + multiplication(x + 1, y);
    		}
    	}
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
     * gibt die Anzahl an ungeraden Integern aus dem Array zurück
     */
    public static int numberOfOddIntegers(int[] m) {
        // TODO
    	int l = m.length;
    	int i = -1;
    	int p = 0;
    	return numberOfOddIntegersHelp(m, i, l, p);
    }

    /*
     * Ergebnis Array enthält genau alle ungeraden Integer aus dem Array
     */
    public static int[] filterOdd(int[] m) {
        // TODO
    	int l = m.length;
    	int odd = numberOfOddIntegers(m);
    	int i = 0;
    	int[] fill = new int[l];
    	int[] cut = new int[odd];
    	return cutArray(fillArray(m, fill, i, i), cut, odd, i);
    }
    
    
    // HILFSMETHODEN
    
    public static void reverseHelp(int[] m, int i, int l) {
    	
    	int x;
    	
    	if(m.length % 2 == 0) {
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
     * überprüft, ob ein Integer gerade oder ungerade ist
     */
    public static int oddIntegers(int i) {

    	if(i % 2 != 0) {
    		return 1;
    	} else {
    		return 0;
    	}
    }

    public static int numberOfOddIntegersHelp(int[] m, int i, int l, int p) {
    	
    	if(i == l - 1) {
    		return p;
    	} else {
        	return p + numberOfOddIntegersHelp(m, i + 1, l, oddIntegers(m[i + 1]));
    	}
    }
    
    /*
     * findet für den übergebenen Array die Stelle der nächstliegenden ungeraden Zahl
     */
    public static int filterOddHelp(int[] m, int i, int x) {
    	
    	if(i < m.length) {
    		if(m[i] % 2 != 0) {
        		return x;
        	} else {
        		return filterOddHelp(m, i + 1, x + 1);
        	}
    	} else {
    		return x - 1;
    	}
    }
    
    /*
     * füllt einen neuen Array mit nur den ungeraden Zahlen aus dem übergebenen Array
     * fill wird der Methode null initialisiert übergeben
     */
    public static int[] fillArray(int[] m, int[] fill, int i, int j) {
    	
    	j = filterOddHelp(m, j, j);
    	if(i == fill.length - 1) {
    		return fill;
    	} else {
    		fill[i] = m[j];
    		return fillArray(m, fill, i + 1, j + 1);
    	}
    }
    
    /*
     * kürzt den zuvor aufgefüllten Array auf die Länge, die der Anzahl der ungeraden Zahlen im Array entspricht
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
