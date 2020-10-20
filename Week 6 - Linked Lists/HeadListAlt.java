public class HeadListAlt {

    Entry head;

    /**
     * constructor empty HeadList
     */
    public HeadListAlt() {
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
    	// erstes Listenelement NOCHMAL SCHAUEN
    	if(head == null) {
    		head = entry;
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
    	// VORUEBERLEGUNG: Da ich nicht weiss, ob der Garbage Collector ein Listenelement, das lediglich
    	// uebersprungen wurde, loescht (da dieses ja durch first und next noch Referenzen zu Listenelementen
    	// besitzt), setze ich diese zusaetzlich noch auf null
    	// leere Liste
    	if(head == null) {
    		return Integer.MIN_VALUE;
    	}
    	// ungueltiger Index
    	if(index < 0 || index > listLength() - 1) {
    		return Integer.MIN_VALUE;
    	}
    	int elem;
    	Entry tmp = new Entry(null, null, 0);
    	tmp = head;
    	// erstes Listenelement (head muss nun auf das Element hinter dem urspruenglich ersten
    	// Element zeigen)
    	if(index == 0) {
    		elem = head.elem;
    		head = head.next;
    		// Referenzen des uebersprungenen (geloeschten) Listenelements werden auf null gesetzt
    		tmp.next = null;
    		tmp.first = null;
    		tmp = null;
    		// first Referenzen werden auf den neuen head gesetzt
    		if(head == null) {
    			return Integer.MIN_VALUE;
    		}
    		setHead(head);
    		return elem;
    	}
    	int count = 0;
    	Entry tmp2 = new Entry(null, null, 0);
    	tmp2 = tmp;
    	// letztes Listenelement
    	if(index == listLength() - 1) {
    		while(count < index - 1) {
        		tmp = tmp.next;
        		tmp2 = tmp.next;
        		count++;
        	}
    		// tmp2 zeigt nun auf das Element, das geloescht werden soll, waehrend tmp auf das vorhergehende
    		// Element zeigt
        	elem = tmp.next.elem;
        	tmp2.next = null;
        	tmp2.first = null;
        	tmp2 = null;
        	tmp.next = null;
        	return elem;
    	}
    	// restliche Listenelemente (next des Elements, das vor dem zu loeschenden Element liegt, muss nun
    	// auf das Element dahinter zeigen
    	while(count < index - 1) {
    		tmp = tmp.next;
    		tmp2 = tmp2.next;
    		count++;
    	}
    	tmp2 = tmp2.next;
    	elem = tmp.next.elem;
    	tmp.next = tmp.next.next;
    	tmp2.next = null;
    	tmp2.first = null;
    	tmp2 = null;
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
    	tmp = head;
    	while(tmp.next != null) {
    		tmp = tmp.next;
    	}
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
        HeadListAlt l = new HeadListAlt();
        System.out.println("empty list: " + l);
        // Test implementation
        l.add(4);
        System.out.println(l);
        l.remove(0);
        System.out.println(l);
        l.add(3);
        l.add(25);
        l.add(6);
        l.add(10);
        System.out.println(l);
        System.out.println(l.remove(0));
        System.out.println(l);
        System.out.println(l.remove(3));
        System.out.println(l);
        System.out.println(l.remove(1));
        System.out.println(l);
        System.out.println(l.remove(1));
        System.out.println(l);
        System.out.println(l.remove(0));
        System.out.println(l);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        System.out.println(l);
        l.reverse();
        System.out.println(l);
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
 
