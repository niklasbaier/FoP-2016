public class HeadList {

    Entry head;

    /**
     * constructor empty HeadList
     */
    public HeadList() {
        head = null;
    }

    /**
     * Appends a new element with value info to the end of this list
     * @param info value of the new element
     */
    public void add(int info) {
        //TODO
    	// neuer Knoten wird erstellt
    	Entry entry = new Entry(head, null, info);
    	// erstes Listenelement
    	if(head == null) {
    		head = entry;
    		// head zeigt ja zu Beginn auf null und erst nach der Erstellung des ersten
    		// Knotens auf diesen
    		entry.first = head;
    		return;
    	}
    	// ein temporaerer neuer Knoten wird initialisiert, der auf head zeigt
    	Entry tmp = new Entry(null, null, 0);
    	tmp = head;
    	// tmp soll nicht auf das letzte Listenelement (null) zeigen, sondern auf das vorherige,
    	// sodass tmp.next dann auf das hintenangefuegte neue Listenelement zeigen kann
    	while(tmp.next != null) {
    		tmp = tmp.next;
    	}
    	// tmp.next zeigt jetzt auf null, diese Stelle im Speicher wird nun vom neuen Eintrag eingenommen
    	tmp.next = entry;
    }

    /**
     * Removes and returns the element at position index from this list.
     * @param index position of the element that is removed
     * @return value of the removed element
     */
    public int remove(int index) {

        //TODO
    	// leere Liste
    	if(head == null) {
    		return Integer.MIN_VALUE;
    	}
    	// ungueltiger Index
    	if(index < 0 || index > listLength() - 1) {
    		return Integer.MIN_VALUE;
    	}
    	int elem;
    	// erstes Listenelement (head muss nun auf das Element hinter dem urspruenglich ersten
    	// Element zeigen)
    	if(index == 0) {
    		elem = head.elem;
    		head = head.next;
    		// first Referenzen werden auf den neuen head gesetzt
    		if(listLength() == 0) {
    			return elem;
    		}
    		setHead(head);
    		return elem;
    	}
    	int count = 0;
    	Entry tmp = new Entry(null, null, 0);
    	tmp = head;
    	// letztes Listenelement
    	if(index == listLength() - 1) {
    		while(count < index - 1) {
        		tmp = tmp.next;
        		count++;
        	}
    		// tmp2 zeigt nun auf das Element, das geloescht werden soll, waehrend tmp auf das vorhergehende
    		// Element zeigt
        	elem = tmp.next.elem;
        	tmp.next = null;
        	return elem;
    	}
    	// restliche Listenelemente (next des Elements, das vor dem zu loeschenden Element liegt, muss nun
    	// auf das Element dahinter zeigen)
    	while(count < index - 1) {
    		tmp = tmp.next;
    		count++;
    	}
    	elem = tmp.next.elem;
    	tmp.next = tmp.next.next;
    	return elem;
    }

    /**
     * sets the head of each list element to newHead
     * @param newHead reference to the new head
     */
    private void setHead(Entry newHead) {

        //TODO
    	Entry tmp = new Entry(null, null, 0);
    	tmp = head;
    	while(tmp.next != null) {
    		tmp.first = newHead;
    		tmp = tmp.next;
    	}
    }

    /**
     * reverse the list
     * example: [1,2,3,4,5] --> [5,4,3,2,1], [] --> [], [1] --> [1]
     */
    public void reverse() {

        //TODO
    	if(head == null) {
    		return;
    	}
    	if(listLength() == 1) {
    		return;
    	}
    	Entry tmp = new Entry(null, null, 0);
    	Entry tmp2 = new Entry(null, null, 0);
    	// wird einen Verweis auf das letzte Element der urspruenglichen Liste zugewiesen bekommen,
    	// sodass nach Abschluss der Schleife head auf das nun erste Listenelement zeigen kann
    	Entry tmp3 = new Entry(null, null, 0);
    	tmp3 = head;
    	int counter = 0;
    	int l = listLength();
    	
    	while(counter < l) {
    		tmp = head;
    		tmp2 = head;
    		int counter2 = 0;
    		// tmp auf letztes Element setzen
    		while(counter2 < l - 1 - counter) {
    			tmp = tmp.next;
    			counter2++;
    		}
    		// tmp3 zeigt nun auf das letzte Element der urspruenglichen Liste
    		if(counter == 0) {
    			tmp3 = tmp;
    		}
    		// tmp2 auf vorletztes Element setzen
    		int counter3 = 0;
    		while(counter3 < l - 2 - counter) {
    			tmp2 = tmp2.next;
    			counter3++;
    		}
    		// letztes Element zeigt auf vorletztes
    		tmp.next = tmp2;
    		// vorletztes Element zeigt auf null
    		tmp2.next = null;
    		counter++;
    	}
    	head = tmp3;
    	// Anpassung der first pointer an neuen head
    	setHead(head);
    }

    @Override
    public String toString() {
        String out = "[";
        if (head != null) {
            out += head.elem;
            Entry tmp = head.next;
            while (tmp != null) {
                out = out + "," + tmp.elem;
                tmp = tmp.next;
            }
        }
        out += "]";
        return out;
    }
    
    // Hilfsmethoden
    public int listLength() {
    	Entry tmp = new Entry(null, null, 0);
    	tmp = head;
    	int counter = 0;
    	while(tmp != null) {
    		counter++;
    		tmp = tmp.next;
    	}
    	return counter;
    }
   
    public static void main(String[] args) {
        HeadList l = new HeadList();
        System.out.println("empty list: " + l.toString());
        // Test implementation
    }

    class Entry {

        Entry first;
        Entry next;
        int elem;

        public Entry(Entry first, Entry next, int elem) {
            this.first = first;
            this.next = next;
            this.elem = elem;
        }
        
    }

}
 
