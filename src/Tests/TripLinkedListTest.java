package Tests;

import FlightHopper.Airport;
import FlightHopper.TripLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripLinkedListTest {
    TripLinkedList list;
    Airport lax, sfo, sea;
    String l = "LAX",s = "SFO",a = "SEA";
    @Before
    public void setUp() throws Exception {
        list = new TripLinkedList();
    }

    @Test
    public void size() {
        TripLinkedList list1 = new TripLinkedList();
        assertEquals(0, list1.size());
        list1.add(l);
        assertEquals(1, list1.size());
    }

    @Test
    public void getRoot() {
        TripLinkedList list1 = new TripLinkedList();
        assertNull(list1.getRoot());
        list1.add(l);
        assertEquals(lax.getName(), list1.getRoot().getName());
        list1.add(l);
        assertEquals(lax.getName(), list1.getRoot().getName());
    }

    @Test
    public void add() {
        TripLinkedList list1 = new TripLinkedList();
        assertEquals(0, list1.size());
        list1.add(l);
        assertEquals(lax.getName(), list1.getRoot().getName());
        list1.add(s);
        assertEquals(list1.getRoot().getDestination().getName(), sfo.getName());
    }

    @Test
    public void remove() {
        TripLinkedList list1 = new TripLinkedList();
        assertEquals(0, list1.size());
        list1.add(l);
        assertEquals(lax.getName(), list1.getRoot().getName());
        list1.add(s);
        list1.add(a);
        assertEquals(true, list1.remove(s));
    }

    @Test
    public void isEmpty() {
        TripLinkedList list1 = new TripLinkedList();
        assertTrue(list1.isEmpty());
        list1.add(l);
        assertFalse(list1.isEmpty());
    }

    @Test
    public void contains() {
        TripLinkedList list1 = new TripLinkedList();
        assertEquals(0, list1.size());
        assertFalse(list1.contains(l));
        list1.add(l);
        assertTrue(list1.contains(l));
        list1.add(a);
        list1.add(s);
        assertFalse(list1.contains("Hello"));
    }

    @Test
    public void get() {
        TripLinkedList list1 = new TripLinkedList();
        assertEquals(0, list1.size());
//        assertFalse(list1.contains(l));
        list1.add(l);
//        assertTrue(list1.contains(l));
        list1.add(a);
        list1.add(s);
        assertEquals(null, list1.get(100));
        assertNull(list1.get(-1));
        assertEquals(lax.getName(), list1.get(0).getName());
        assertEquals(sfo.getName(), list1.get(2).getName());
    }

    @Test
    public void get1() {
        TripLinkedList list1 = new TripLinkedList();
        assertEquals(0, list1.size());
//        assertFalse(list1.contains(l));
        list1.add(l);
//        assertTrue(list1.contains(l));
        list1.add(a);
        list1.add(s);
        assertEquals(lax.getName(), list1.get("LAX"));
        assertEquals(sea.getName(), list1.get("SEA"));
        assertNull(list1.get("HEllo"));
    }
}