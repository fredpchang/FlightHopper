package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import FlightHopper.*;
import org.junit.Before;
import org.junit.Test;

public class MulticityAnalyzerTest {

	List<String> userInputMul;
	DirectFlight f1, f2, f3, f4;
	Airport lax, sfo, sea;
	@Before
	public void setUp() throws Exception {
		userInputMul = new ArrayList<>();
		lax = new Airport(); sfo = new Airport(); sea = new Airport();
		lax.setName("LAX");
		sfo.setName("SFO");
		sea.setName("SEA");

		userInputMul.add("05/15/2019");
		userInputMul.add("LAX");
		userInputMul.add("0");
		userInputMul.add("SFO");
		userInputMul.add("2");
		userInputMul.add("SEA");

		f1 = new DirectFlight();
		f1.setDuration(3);
		f1.setStartAirport(lax);
		f1.setEndAirport(sfo);
		f1.setPrice(100);
		f2 = new DirectFlight();
		f2.setDuration(1);
		f2.setStartAirport(lax);
		f2.setEndAirport(sfo);
		f2.setPrice(1000);
		f3 = new DirectFlight();
		f3.setDuration(1);
		f3.setStartAirport(sfo);
		f3.setEndAirport(sea);
		f3.setPrice(200);
		f4 = new DirectFlight();
		f4.setDuration(10);
		f4.setStartAirport(sfo);
		f4.setEndAirport(sea);
		f4.setPrice(50);
	}
	@Test
	public void getOptimalRoutesOfMultiCities() {
		List<List<IFlight>> l = new ArrayList<>();
		List<IFlight> first = new ArrayList<>();
		List<IFlight> second = new ArrayList<>();
		List<IFlight> third = new ArrayList<>();
		List<IFlight> fourth = new ArrayList<>();
		first.add(f1);
		first.add(f3);
		second.add(f1);
		second.add(f4);
		third.add(f2);
		third.add(f3);
		fourth.add(f2);
		fourth.add(f4);
		l.add(fourth);
		l.add(first);
		MulticityAnalyzer m = new MulticityAnalyzer();
		assertEquals(l, m.getOptimalRoutesOfMultiCities(userInputMul));

		List<String> userInputMul1 = new ArrayList<>();
		userInputMul1.add("05/15/2019");
		userInputMul1.add("LAX");
		userInputMul1.add("0");
		userInputMul1.add("SFO");
		userInputMul1.add("2");
		// no end airport
		assertNull(m.getOptimalRoutesOfMultiCities(userInputMul1));

		List<String> userInputMul2 = new ArrayList<>();
//		userInputMul2.add("05/15/2019");
		userInputMul2.add("LAX");
		userInputMul2.add("0");
		userInputMul2.add("SFO");
		userInputMul2.add("2");
		userInputMul2.add("SEA");
		// no start date
		assertNull(m.getOptimalRoutesOfMultiCities(userInputMul2));

		List<String> userInputMul3 = new ArrayList<>();
		userInputMul3.add("05/15/2019");
		userInputMul3.add("LAX");
		userInputMul3.add("0");
		userInputMul3.add("SFO");
//		userInputMul3.add("2");
		userInputMul3.add("SEA");
		// no stay time during for city in the middle
		assertNull(m.getOptimalRoutesOfMultiCities(userInputMul3));

	}
	
	@Test
	public void generateListTest() {
		List<IFlight> first = new ArrayList<>();
		List<IFlight> second = new ArrayList<>();
		first.add(f1);
		first.add(f2);
		second.add(f3);
		second.add(f4);
		lax.setTickets(first);
		sfo.setTickets(second);
		lax.setDestination(sfo);
		sfo.setDestination(sea);
		TripLinkedList myTLL = new TripLinkedList();
		myTLL.setStartAirport(lax);
		MulticityAnalyzer m = new MulticityAnalyzer();
		assertEquals(myTLL, m.generateList(userInputMul));
	}
	
	@Test
	public void getRouteTest() {
		List<List<IFlight>> l = new ArrayList<>();
		List<IFlight> first = new ArrayList<>();
		List<IFlight> second = new ArrayList<>();
		List<IFlight> third = new ArrayList<>();
		List<IFlight> fourth = new ArrayList<>();
		first.add(f1);
		first.add(f3);
		second.add(f1);
		second.add(f4);
		third.add(f2);
		third.add(f3);
		fourth.add(f2);
		fourth.add(f4);
		MulticityAnalyzer m = new MulticityAnalyzer();
		// invalid weight
		assertNull(m.getRoute(userInputMul, -1));
		assertNull(m.getRoute(userInputMul, 12));
		// weight is 1, get the cheapest possible, fourth route
		List<IFlight> re = m.getRoute(userInputMul, 1);
		assertEquals(re.get(0), fourth.get(0));
		assertEquals(re.get(1), fourth.get(1));
		// weight is 0, shortest duration possible, first one
		re = m.getRoute(userInputMul, 0);
		assertEquals(re.get(0), first.get(0));
		assertEquals(re.get(1), first.get(1));
		// half and half, still first route is best
		re = m.getRoute(userInputMul, 0.5);
		assertEquals(re.get(0), first.get(0));
		assertEquals(re.get(1), first.get(1));
	}


	/*
	This function involves run a scraper py file at run time to scrape data online,
	there are no way for us to predict the result because flight information changes
	all the time. So we have no idea how to write the test here.
	Usually the method involves I/O is not testable so this is the case!!!
	 */
	@Test
	public void getTicketsTest() {
		List<String> userInput = new LinkedList<String>();
		userInput.add("LAX");
		userInput.add("SFO");
		userInput.add("JFK");
		List<IFlight> l = new LinkedList<IFlight>();
		IFlight f1 = new DirectFlight();
		IFlight f2 = new DirectFlight();
		l.add(f1);
		l.add(f2);
		MulticityAnalyzer m = new MulticityAnalyzer(userInput);
		assertEquals(l, m.getTickets("LAX", "SFO", "20190422"));
	}

}
