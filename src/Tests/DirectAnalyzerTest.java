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
	DirectFlight f1, f2, f3, f4;
	Airport lax, sfo, sea;
	@Before
	public void setUp() throws Exception {
		userInputTwo = new ArrayList<>();
		userInputMul = new ArrayList<>();
		lax = new Airport(); sfo = new Airport(); sea = new Airport();
		lax.setName("Los Angeles");
		sfo.setName("San Francisco");
		sea.setName("Seattle");
		userInputTwo.add("Los Angeles");
		userInputTwo.add("San Francisco");
		userInputTwo.add("05/15/2019");
		userInputTwo.add("0");
		userInputTwo.add("500");
		userInputTwo.add("10");

		userInputMul.add("05/15/2019");
		userInputMul.add("Los Angeles");
		userInputMul.add("0");
		userInputMul.add("San Francisco");
		userInputMul.add("2");
		userInputMul.add("Seattle");

		f1 = new DirectFlight();
		f1.setDuration(3);
		f1.setStartAirport(lax);
		f1.setEndAirport(sfo);
		f1.setPrice(100);
		f2 = new DirectFlight();
		f2.setDuration(3);
		f2.setStartAirport(lax);
		f2.setEndAirport(sfo);
		f2.setPrice(1000);
		f3 = new DirectFlight();
		f3.setDuration(1);
		f3.setStartAirport(lax);
		f3.setEndAirport(sfo);
		f3.setPrice(200);
		f4 = new DirectFlight();
		f4.setDuration(100);
		f4.setStartAirport(lax);
		f4.setEndAirport(sfo);
		f4.setPrice(100);
	}

	@Test
	public void getOptimalRoutesOfTwoCitiesTest() {
		List<IFlight> l = new LinkedList<IFlight>();
		l.add(f1);
//		l.add(f2);
		l.add(f3);
		DirectAnalyzer d = new DirectAnalyzer(userInputTwo);
		assertEquals(l, d.getOptimalRoutesOfTwoCities(userInputTwo));
		List<String> testInput = new ArrayList<>();
		testInput.add("Los Angeles");
		testInput.add("San Francisco");
		testInput.add("05/15/2019");
		testInput.add("0");
		testInput.add("0");
		testInput.add("0");
		// no max price and no max duration, all flights are okay
		List<IFlight> l1 = new ArrayList<>();
		l1.add(f1);
		l1.add(f2);
		l1.add(f3);
		l1.add(f4);
		assertEquals(l1, d.getOptimalRoutesOfTwoCities(testInput));
		List<String> testInput1 = new ArrayList<>();
		testInput1.add("Los Angeles");
		testInput1.add("San Francisco");
		testInput1.add("05/15/2019");
		testInput1.add("0");
		testInput1.add("500");
		testInput1.add("0");
		// only filter max price, f2 is invalid
		List<IFlight> l2 = new ArrayList<>();
		l2.add(f1);
		l2.add(f3);
		l2.add(f4);
		assertEquals(l2, d.getOptimalRoutesOfTwoCities(testInput1));

		List<String> testInput2 = new ArrayList<>();
		testInput2.add("Los Angeles");
		testInput2.add("San Francisco");
		testInput2.add("05/15/2019");
		testInput2.add("0");
		testInput2.add("0");
		testInput2.add("4");
		// on filter max duration f4 is invalid
		List<IFlight> l3 = new ArrayList<>();
		l3.add(f1);
		l3.add(f2);
		l3.add(f3);
		assertEquals(l3, d.getOptimalRoutesOfTwoCities(testInput2));
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
		assertEquals(myTLL.getRoot(), re.getRoot());
		assertEquals(myTLL.getRoot().getDestination(), re.getRoot().getDestination());
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
		assertEquals(l.get(0), re.get(0));
		// weight 0.25 f1 is better
		re = d.getRoute(userInputTwo,0.25);
		assertEquals(l.get(0), re.get(0));
		// weight 0.75 f1 is better
		re = d.getRoute(userInputTwo, 0.75);
		assertEquals(l.get(0), re.get(0));
		// shortest duration on top
		re = d.getRoute(userInputTwo, 0);
		assertEquals(l.get(1), re.get(0));


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
		assertEquals(l, d.getTickets("Los Angeles", "San Francisco", "05/15/2019"));
	}

	
}
