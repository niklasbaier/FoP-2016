public class DoublyLinkedList {

    Entry head;
    int size;

    /**
     * constructor empty DoublyLinkedList
     */
    public DoublyLinkedList() {
        //TODO
    	head = null;
    	size = 0;
    }
    
    
    /**
     * Returns the number of elements in this list.
     * @return number of elements in this list
     */
    public int size(){
        //TODO
    }    

    /**
     * Appends a new element with value info to the end of this list
     * @param info value of the new element
     */
    public void add(int info) {
        //TODO
    	Entry add = new Entry(null, null, info);
    	if(head == null) {
    		head = add;
    		add.prev = head;
    		return;
    	}
    	Entry tmp = new Entry(null, null, 0);
    	tmp = head;
    	while(tmp.next != null) {
    		tmp = tmp.next;
    	}
    	add.prev = tmp;
    	tmp.next = add;
    }

    /**
     * Inserts a new element with value info
     * at the specified position in this list.
     * @param index position where the element is inserted, from 0 ... list.size()-1
     * @param info value of the new element
     */
    public void add(int index, int info) {
        //TODO
    	if(index < 0) {
    		return;
    	}
    	if(index > listLength() - 1) {
    		add(info);
    		return;
    	}
    	Entry add = new Entry(null, null, info);
    	Entry tmp = new Entry(null, null, 0);
    	Entry tmp2 = new Entry(null, null, 0);
    	tmp = head;
    	tmp2 = head.next;
    	if(index == 0) {
    		head = add;
    		add.prev = head;
    		add.next = tmp;
    		tmp.prev = add;
    		tmp.next = tmp2;
    		tmp2.prev = tmp;
    		return;
    	}
    	int counter = 0;
    	while(counter < index - 1) {
    		tmp = tmp.next;
    		tmp2 = tmp2.next;
    		counter++;
    	}
    	add.prev = tmp;
    	tmp.next = add;
    	add.next = tmp2;
    }


    /**
     * Removes and returns the element at position index from this list.
     * @param index position of the element that is removed
     * @return value of the removed element
     */
    public int remove(int index) {
        //TODO
    }
    
    /**
     * shifts the list the specified number of positions to the left
     * example: [1,5,6,7] ---shift(2)---> [6,7,1,5]
     * @param index number of position to shift, from 0 to size-1
     */
    public void shiftLeft(int index){
        //TODO
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
    	int counter = 0;
    	tmp = head;
    	while(tmp != null) {
    		tmp = tmp.next;
    		counter++;
    	}
    	return counter;
    }
    
    public static void main(String[] args) {
	//TODO 
    	//Entry e = new Entry();
    	//System.out.println(e.elem);
    	DoublyLinkedList d = new DoublyLinkedList();
    	System.out.println(d.toString());
    	for(int i = 1; i <= 5; i++) {
    		d.add(i);
    	}
    	System.out.println(d.toString());
    	System.out.println("Laenge: " + d.listLength());
    }

    class Entry {

        Entry prev;
        Entry next;
        int elem;

        public Entry(Entry prev, Entry next, int elem) {
            this.prev = prev;
            this.next = next;
            this.elem = elem;
        }
        public Entry() {
        	this.prev = null;
        	this.next = null;
        	this.elem = 0;
        }

    }
}
 
