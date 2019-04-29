package Tests;

import FlightHopper.Airport;
import FlightHopper.TripLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripLinkedListTest {
    TripLinkedList list;
    Airport lax, sfo, sea;
    String l = "Los Angeles",s = "San Francisco",a = "Seattle";
    @Before
    public void setUp() throws Exception {
        list = new TripLinkedList();
    }

    @Test
    public void size() {
        TripLinkedList list1 = new TripLinkedList();
        assertEquals(0, list1.size());
        assertEquals(0, list1.getSize());
        list1.add(l);
        assertEquals(1, list1.size());
        list1.setSize(10);
        assertEquals(10,list1.size());
    }

    @Test
    public void getRoot() {
        TripLinkedList list1 = new TripLinkedList();
        assertNull(list1.getRoot());
        list1.add(l);
        assertEquals(l, list1.getRoot().getName());
        Airport a = new Airport();
        a.setName("hi");
        list1.setStartAirport(a);
        assertEquals(list1.getStartAirport().getName(),"hi");
//        list1.add(l);
//        assertEquals(lax.getName(), list1.getRoot().getName());
    }

    @Test
    public void testEqual() {
        TripLinkedList list1 = new TripLinkedList();
        list1.add(l);
        Airport a = new Airport();
        a.setName("hi");
        Airport b = new Airport();
        b.setName("hello");
        list1.add("hello");
        TripLinkedList list2 = new TripLinkedList();
        list2.add(l);
        list2.add("hello");
        assertTrue(list1.equals(list2));
        list2.add("hi");
        assertFalse(list1.equals(list2));
        list2.remove("hello");
        assertFalse(list1.equals(list2));

    }

    @Test
    public void add() {
        TripLinkedList list1 = new TripLinkedList();
        assertEquals(0, list1.size());
        list1.add(l);
        assertEquals(l, list1.getRoot().getName());
        list1.add(s);
        assertEquals(list1.getRoot().getDestination().getName(), s);
    }

    @Test
    public void remove() {
        TripLinkedList list1 = new TripLinkedList();
        assertEquals(0, list1.size());
        list1.add(l);
        assertEquals(l, list1.getRoot().getName());
        list1.add(s);
        list1.add(a);
        assertEquals(true, list1.remove(a));
        assertFalse(list1.remove("sdfs"));
        assertTrue(list1.remove(s));
        assertTrue(list1.remove(l));
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
        assertEquals(l, list1.get(0).getName());
        assertEquals(s, list1.get(2).getName());
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
        assertEquals(l, list1.get(l).getName());
        assertEquals(a, list1.get("Seattle").getName());
        assertNull(list1.get("HEllo"));
    }
}