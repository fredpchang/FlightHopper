package Tests;

import FlightHopper.Airport;
import FlightHopper.TripLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripLinkedListTest {
    TripLinkedList list;
    Airport lax, sfo, sea;
    @Before
    public void setUp() throws Exception {
        list = new TripLinkedList();
    }

    @Test
    public void size() {
        TripLinkedList list1 = new TripLinkedList();
        assertEquals(0, list1.size());
        list1.add(lax);
        assertEquals(1, list1.size());
    }

    @Test
    public void getRoot() {
        TripLinkedList list1 = new TripLinkedList();
        assertNull(list1.getRoot());
        list1.add(lax);
        assertEquals(lax, list1.getRoot());
        list1.add(sfo);
        assertEquals(lax, list1.getRoot());
    }

    @Test
    public void add() {
        TripLinkedList list1 = new TripLinkedList();
        assertEquals(0, list1.size());
        list1.add(lax);
        assertEquals(lax, list1.getRoot());
        list1.add(sfo);
        assertEquals(list1.getRoot().getDestination(), sfo);
    }

    @Test
    public void remove() {
        TripLinkedList list1 = new TripLinkedList();
        assertEquals(0, list1.size());
        list1.add(lax);
        assertEquals(lax, list1.getRoot());
        list1.add(sfo);
        list1.add(sea);
        assertEquals(true, list1.remove(sfo));
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void contains() {
    }
}