package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import FlightHopper.*;
import org.junit.Before;
import org.junit.Test;

public class DirectAnalyzerTest {

	List<String> userInputTwo, userInputMul;
	NonDirectFlight f1, f3, f4, f5, f6;
	DirectFlight f2;
	Airport lax, pek, sea;
	@Before
	public void setUp() throws Exception {
		userInputTwo = new ArrayList<>();
		userInputMul = new ArrayList<>();
		lax = new Airport(); pek = new Airport(); sea = new Airport();
		lax.setName("Los Angeles");
		pek.setName("Beijing");
		sea.setName("Seattle");
		userInputTwo.add("lax");
		userInputTwo.add("pek");
		userInputTwo.add("07/15/2019");
		userInputTwo.add("0");
		userInputTwo.add("-1");
		userInputTwo.add("-1");

		f1 = new NonDirectFlight();
		f1.setDuration(17);
		f1.setStartAirport(lax.getName());
		f1.setEndAirport(pek.getName());
		f1.setPrice(557.70);
		f1.setAirline("");
		f1.setPlane("");
		f1.setDirect(false);
		f1.setEndTime("");
		f1.setStartTime("");
		f1.setFlightDuration("");
		f1.setStops(0);
		f2 = new DirectFlight();
		f2.setDuration(13);
		f2.setStartAirport(lax.getName());
		f2.setEndAirport(pek.getName());
		f2.setPrice(732.7);
		f2.setAirline("");
		f2.setPlane("");
		f2.setDirect(true);
		f2.setEndTime("");
		f2.setStartTime("");

		f3 = new NonDirectFlight();
		f3.setDuration(48);
		f3.setStartAirport(lax.getName());
		f3.setEndAirport(pek.getName());
		f3.setPrice(832.46);
		f3.setAirline("");
		f3.setPlane("");
		f3.setDirect(false);
		f3.setEndTime("");
		f3.setStartTime("");
		f3.setFlightDuration("");
		f3.setStops(0);
	}

	@Test
	public void testContructor() {
		List<String> l = new ArrayList<>();
		l.add("hi");
		DirectAnalyzer d = new DirectAnalyzer(l);
		assertEquals(d.getUserInput().get(0), "hi");
		List<String> l1 = new ArrayList<>();
		l1.add("hello");
		d.setUserInput(l1);
		assertEquals(d.getUserInput().get(0), "hello");
	}

	@Test
	public void testCheckValid() {
		DirectAnalyzer d = new DirectAnalyzer();
		assertTrue(d.checkValid(f1, 100,1000));
		assertFalse(d.checkValid(f1, 1, 1000));
		assertFalse(d.checkValid(f1, 1000,1));
	}

	@Test
	public void getOptimalRoutesOfTwoCitiesTest() {
		List<IFlight> l = new LinkedList<IFlight>();
		l.add(f1);
		l.add(f2);
		l.add(f3);
		DirectAnalyzer d = new DirectAnalyzer();
		IFlight ff1 = d.getOptimalRoutesOfTwoCities(userInputTwo).get(0);
		assertTrue(ff1 instanceof NonDirectFlight);
		NonDirectFlight cff1 = (NonDirectFlight) ff1;
		assertEquals(cff1.getDuration(),f1.getDuration());
		assertEquals(cff1.getPrice(), f1.getPrice(),10);
		List<String> testInput = new ArrayList<>();
		testInput.add("lax");
		testInput.add("pek");
		testInput.add("07/15/2019");
		testInput.add("0");
		testInput.add("-1");
		testInput.add("-1");
		List<IFlight> re = d.getOptimalRoutesOfTwoCities(testInput);
		ff1 = re.get(re.size()-1);
		assertTrue(ff1 instanceof NonDirectFlight);
		cff1 = (NonDirectFlight) ff1;
		assertEquals(cff1.getDuration(),22);
//		assertEquals(cff1.getPrice(), 763.0,10);
//		// no max price and no max duration, all flights are okay
//		List<IFlight> l1 = new ArrayList<>();
//		l1.add(f1);
//		l1.add(f2);
//		l1.add(f3);
//		assertEquals(f1, d.getOptimalRoutesOfTwoCities(testInput).get(0));
//		List<String> testInput1 = new ArrayList<>();
//		testInput1.add("lax");
//		testInput1.add("pek");
//		testInput1.add("07/15/2019");
//		testInput1.add("0");
//		testInput1.add("600");
//		testInput1.add("0");
//		// only filter max price, only f1 valid
//		List<IFlight> l2 = new ArrayList<>();
//		l2.add(f1);
//		assertEquals(f1, d.getOptimalRoutesOfTwoCities(testInput1).get(0));
//
//		List<String> testInput2 = new ArrayList<>();
//		testInput2.add("lax");
//		testInput2.add("pek");
//		testInput2.add("07/15/2019");
//		testInput2.add("0");
//		testInput2.add("0");
//		testInput2.add("15");
//		// on filter max duration only f2 valid
//		List<IFlight> l3 = new ArrayList<>();
//		l3.add(f2);
//		assertEquals(f2, d.getOptimalRoutesOfTwoCities(testInput2).get(0));
	}

	@Test
	public void generateListTest() {

		TripLinkedList myTLL = new TripLinkedList();
		//empty
		DirectAnalyzer d = new DirectAnalyzer();
		assertNull(d.generateList(new ArrayList<>()));
		// not enough required fields
		List<String> testInput = new ArrayList<>();
		testInput.add("Los Angeles");
		assertNull(d.generateList(testInput));
		myTLL.setStartAirport(lax);
		myTLL.add("San Francisco");
		// normal
		TripLinkedList re = d.generateList(userInputTwo);
//		assertEquals(null, re.getRoot());
//		assertEquals(myTLL.getRoot().getDestination(), re.getRoot().getDestination());
	}

	@Test
	public void getRouteTest() {
		List<IFlight> l = new LinkedList<IFlight>();
		l.add(f1);
		l.add(f3);
		DirectAnalyzer d = new DirectAnalyzer();
		// weight should within 0 to 1
		assertNull(d.getRoute(userInputTwo, -1));
		assertNull(d.getRoute(userInputTwo, 12));
		List<IFlight> re = d.getRoute(userInputTwo, 1);
		// cheapest on top
		IFlight f = re.get(0);

		assertTrue(f instanceof NonDirectFlight);
		NonDirectFlight cf = (NonDirectFlight) f;
		assertEquals(cf.getDuration(),f1.getDuration());
		assertEquals(cf.getPrice(), f1.getPrice(), 10);
//		assertEquals(l.get(0), re.get(0));
//		// weight 0.25 f1 is better
//		re = d.getRoute(userInputTwo,0.25);
//		assertEquals(l.get(0), re.get(0));
//		// weight 0.75 f1 is better
//		re = d.getRoute(userInputTwo, 0.75);
//		assertEquals(l.get(0), re.get(0));
//		// shortest duration on top
//		re = d.getRoute(userInputTwo, 0);
//		assertEquals(l.get(1), re.get(0));


	}


	/*
	This function involves run a scraper py file at run time to scrape data online,
	there are no way for us to predict the result because flight information changes
	all the time. So we have no idea how to write the test here.
	Usually the method involves I/O is not testable so this is the case!!!
	 */
	@Test
	public void getTicketsTest() {
		List<IFlight> l = new LinkedList<IFlight>();
		l.add(f1);
		l.add(f2);
		l.add(f3);
		l.add(f4);
		DirectAnalyzer d = new DirectAnalyzer();
		IFlight f = d.getTickets("lax", "pek", "07/15/2019").get(0);

		assertTrue(f instanceof NonDirectFlight);
		NonDirectFlight cf = (NonDirectFlight) f;
		assertEquals(cf.getDuration(),f1.getDuration());
		assertEquals(cf.getPrice(), f1.getPrice(), 10);
	}


}
