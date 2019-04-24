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
     * @return
     */
    public int size() {
        return -1;
    }

    /**
     * Get root of this list
     * @return
     */
    public Airport getRoot() {
        return null;
    }

    /***
     * add a node into list
     * @param node
     * @return true if add successfully, false otherwise
     */
    public boolean add(String node) {
        return false;
    }

    /**
     * remove a node
     * @param node
     * @return true if remove successfully, false otherwise
     */
    public boolean remove(String node) {
        return false;
    }

    /**
     * see if list is empty
     * @return true if empty, false if not
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * see if a node is in the list
     * @param node
     * @return return true if in, else return false
     */
    public boolean contains(String node) {
        return false;
    }

    /**
     * get the airport on that index
     * if not in size range return null
     * @param index
     * @return
     */
    public Airport get(int index) {
        return null;
    }

    /**
     * get the airport by their name
     * if not in list, return null
     * @param node
     * @return
     */
    public Airport get(String node) {
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
     * @param startAirport
     */
    public void setStartAirport(Airport startAirport) {
        this.startAirport = startAirport;
    }

    /**
     * get size of list
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * set size
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * override equals method
     * @param o
     * @return
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
