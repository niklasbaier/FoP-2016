public class SymmetricStack {

    private int[] data;
    private int first;
    private int last;

    public SymmetricStack() {
        // TODO
    	setData(new int[4]);	// wie in der VL
    	setFirst(-1);
    	setLast(-1);
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getNumberOfElements() {
        // TODO
    	if(getFirst() == -1) {
    		return 0;
    	}
    	// Normalfall
    	int ftmp = getFirst();
    	int counter = 1;
    	if(sonderfall() == false) {
    		// Position von first soll nicht veraendert werden;
        	while(ftmp != getLast()) {
        		ftmp++;
        		counter++;
        	}
        	return counter;
    	} else {
    		// Sonderfall
    		// Anzahl Elemente von first bis Ende
    		while(ftmp < getData().length - 1) {
    			ftmp++;
    			counter++;
    		}
    		// Anzahl Elemente von Anfang bis last
    		for(int i = 0; i <= getLast(); i++) {
    			counter++;
    		}
    		return counter;
    	}
    }

    public void increase() {
        // TODO
    	if(isFull() == true) {
    		int n = getData().length;
    		int[] tmp = new int[2*n];
    		int ftmp = getFirst();
    		// Uebertragen der Elemente von first bis Ende
    		int i = n/2;
    		if(sonderfall() == true) {
        		for(; ftmp < n && ftmp != getLast(); i++, ftmp++) {
        			tmp[i] = getData()[ftmp];
        		}
        		// Uebertragen der Elemente von Anfang bis last
        		for(int j = 0; j <= getLast(); j++, i++) {
        			tmp[i] = getData()[j];
        		}
    		} else {
    			for(; ftmp < n; i++, ftmp++) {
    				tmp[i] = getData()[ftmp];
    			}
    		}
    		setData(tmp);
    		setFirst(n/2);
    		setLast(getFirst() + n - 1);
    	}
    }

    public void decrease() {
        // TODO
    	if(getNumberOfElements() <= getData().length/4) {
    		int n = getData().length;
    		int[] tmp = new int[n/2];
    		int ftmp = getFirst();
    		int counter = -1;
    		for(int i = n/8; ftmp <= getLast(); i++, ftmp++, counter++) {
    			tmp[i] = getData()[ftmp];
    		}
    		setData(tmp);
    		setFirst(n/8);
    		setLast(getFirst() + counter);
    	}
    }

    public boolean isEmpty() {
        // TODO
    	if(getNumberOfElements() == 0) {
    		return true;
    	}
    	return false;
    }

    public boolean isFull() {
        // TODO
    	if(getNumberOfElements() == getData().length) {
    		return true;
    	}
    	return false;
    }

    public void prepend(int x) {
        // TODO
    	// Stack ist leer
    	if(isEmpty() == true) {
    		getData()[getData().length/2] = x;
    		setFirst(getData().length/2);
    		setLast(getData().length/2);
    		return;
    	}
    	// Stack ist nicht leer
    	// Ueberpruefen, ob Stack voll
    	if(isFull() == true) {
    		increase();
    	}
    	// first wird vom Anfang auf das Ende gesetzt
    	if(getFirst() == 0) {
    		setFirst(getData().length - 1);
    		getData()[getFirst()] = x;
    		return;
    	}
    	int tmp = getFirst();
    	getData()[--tmp] = x;
    	setFirst(getFirst() - 1);
    }

    public void append(int x) {
        // TODO
    	// Stack ist leer
    	if(isEmpty() == true) {
    		getData()[getData().length/2] = x;
    		setFirst(getData().length/2);
    		setLast(getData().length/2);
    		return;
    	}
    	// Stack ist nicht leer
    	// Ueberpruefen, ob Stack voll
    	if(isFull() == true) {
    		increase();
    	}
    	// last wird vom Ende auf den Anfang gesetzt
    	if(getLast() == getData().length - 1) {
    		setLast(0);
    		getData()[getLast()] = x;
    		return;
    	}
    	int tmp = getLast();
    	getData()[++tmp] = x;
    	setLast(getLast() + 1);
    }

    public void removeFirst() {
        // TODO
    	// ist der Array leer, wird er wieder auf seine Ursprungsgroesse zurueckgesetzt
    	if(getFirst() == getLast()) {
    		setFirst(-1);
    		setLast(-1);
    		return;
    	}
    	if(getFirst() < getData().length - 1) {
        	setFirst(getFirst() + 1);
        	
    	} else if(getFirst() == getData().length - 1) {
    		setFirst(0);
    	}
    	if(getNumberOfElements() <= getData().length/4) {
    		decrease();
    	}
    }

    public void removeLast() {
        // TODO
    	// ist der Array leer, wird er wieder auf seine Ursprungsgroesse zurueckgesetzt
    	if(getLast() == getFirst()) {
    		setLast(-1);
    		setFirst(-1);
    		return;
    	}
    	if(getLast() > getFirst()) {
    		setLast(getLast() - 1);
    	} else if(getLast() > 0) {
    		setLast(getLast() - 1);
    	} else if(getLast() == 0) {
    		setLast(getData().length - 1);
    	}
    	if(getNumberOfElements() <= getData().length/4) {
    		decrease();
    	}
    }
    
    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < data.length; i++) {
            if (first <= last && (i < first || i > last))
                out += "* ";
            if (first <= last && i > first && i < last)
                out += " " + data[i];
            if (first > last && i > last && i < first)
                out += "* ";
            if (first > last && (i > first || i < last))
                out += " " + data[i];
            if (i == first)
                out = out + "(" + data[i];
            if (i == last)
                out += (first == last ? "" : " " + data[i]) + ")";
        }
        return out;
    }
    
    // HILFSMETHODEN
    
    public boolean sonderfall() {
    	if(getFirst() > getLast()) {
    		return true;
    	}
    	return false;
    }
}
