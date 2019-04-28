package FlightHopper;

public class TripLinkedList {
    private Airport startAirport;
    private int size;


    /**
     * constructor, init the list
     */
    public TripLinkedList() {
        size = 0;
        startAirport = null;
    }

    /**
     * get list size
     * @return list size
     */
    public int size() {
        return size;
    }

    /**
     * Get root of this list
     * @return root airport
     */
    public Airport getRoot() {
        return startAirport;
    }

    /***
     * add a node into list
     * @param node name of node we want to add
     * @return true if add successfully, false otherwise
     */
    public boolean add(String node) {

        if(this.contains(node)) return false;
        if(this.startAirport == null) {
            Airport newNode = new Airport(node);
            this.startAirport = newNode;
            size++;
            return true;
        }
        Airport cur = this.startAirport;
        while(cur.destination != null) {
            cur = cur.destination;
        }
        cur.destination = new Airport(node);
        size++;
        return true;
    }

    /**
     * remove a node
     * @param node the node we want to delete
     * @return true if remove successfully, false otherwise
     */
    public boolean remove(String node) {
        if(!this.contains(node)) return false;
        Airport target = this.get(node);
        if(size == 1) {
            this.startAirport = null;
            size--;
            return true;
        }
        Airport cur = this.startAirport;
        while(cur.destination != target) {
            cur = cur.destination;
        }
        cur.destination = cur.destination.destination;
        size--;
        return true;
    }

    /**
     * see if list is empty
     * @return true if empty, false if not
     */
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * see if a node is in the list
     * @param node the target node we want to search
     * @return return true if in, else return false
     */
    public boolean contains(String node) {
        if(size == 0) return false;
        Airport cur = this.startAirport;
        while(cur != null) {
            if(cur.name.equals(node) ) return true;
            cur = cur.destination;
        }
        return false;
    }

    /**
     * get the airport on that index
     * if not in size range return null
     * @param index index
     * @return the node on that index
     */
    public Airport get(int index) {
        if(index < 0 || index >= size) return null;
        Airport cur = this.startAirport;
        for(int i = 1; i <= index; i++) {
            cur = cur.destination;
        }
        return cur;
    }

    /**
     * get the airport by their name
     * if not in list, return null
     * @param node the node we want to get
     * @return the node
     */
    public Airport get(String node) {
        if(isEmpty()) return null;
        Airport cur = this.startAirport;
        while(cur != null) {
            if(cur.name.equals(node)) return cur;
            cur = cur.destination;
        }
        return null;
    }

    /**
     * get the root node
     * @return root node
     */
    public Airport getStartAirport() {
        return startAirport;
    }

    /**
     * set root
     * @param startAirport start airport
     */
    public void setStartAirport(Airport startAirport) {
        this.startAirport = startAirport;
    }

    /**
     * get size of list
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * set size
     * @param size list size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * override equals method
     * @param o the list to compare
     * @return whether they are same
     */
    public boolean equals(Object o) {

        TripLinkedList a = (TripLinkedList) o;
        if(this.size != a.size) return false;
        Airport cur1 = this.getStartAirport();
        Airport cur2 = a.getStartAirport();
        while(cur1 != null && cur2 != null) {
            if(!cur1.equals(cur2)) return false;
            cur1 = cur1.destination;
            cur2 = cur2.destination;
        }
        return true;
    }
}
