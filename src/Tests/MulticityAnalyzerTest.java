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
		lax.setName("Los Angeles");
		sfo.setName("San Francisco");
		sea.setName("Seattle");

		userInputMul.add("07/15/2019");
		userInputMul.add("lax");
		userInputMul.add("0");
		userInputMul.add("pek");
		userInputMul.add("2");
		userInputMul.add("hkg");

		f1 = new DirectFlight();
		f1.setDuration(17);
		f1.setStartAirport(lax.getName());
		f1.setEndAirport("Beijing");
		f1.setPrice(557.7);
		f2 = new DirectFlight();
		f2.setDuration(4);
		f2.setStartAirport("Beijing");
		f2.setEndAirport("Hong Kong");
		f2.setPrice(157.8);
		f3 = new DirectFlight();
		f3.setDuration(1);
		f3.setStartAirport(sfo.getName());
		f3.setEndAirport(sea.getName());
		f3.setPrice(200);
		f4 = new DirectFlight();
		f4.setDuration(10);
		f4.setStartAirport(sfo.getName());
		f4.setEndAirport(sea.getName());
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
		first.add(f2);
		second.add(f1);
		second.add(f4);
		third.add(f2);
		third.add(f3);
		fourth.add(f2);
		fourth.add(f4);
		l.add(fourth);
		l.add(first);
//		first.add()
		MulticityAnalyzer m = new MulticityAnalyzer();

		List<List<IFlight>> re = m.getOptimalRoutesOfMultiCities(userInputMul);
		List<IFlight> r = re.get(0);
		assertTrue(r.get(0) instanceof NonDirectFlight);
		NonDirectFlight flight1 = (NonDirectFlight) r.get(0);
		assertEquals(flight1.getPrice(), f1.getPrice(),10);
		assertEquals(flight1.getDuration(), f1.getDuration());
		assertTrue(r.get(1) instanceof DirectFlight);
		DirectFlight flight2 = (DirectFlight) r.get(1);
		assertEquals(flight2.getPrice(), f2.getPrice(),10);
		assertEquals(flight2.getDuration()*1.0, f2.getDuration()*1.0,1);
//		assertEquals(l, );

//		List<String> userInputMul1 = new ArrayList<>();
//		userInputMul1.add("05/15/2019");
//		userInputMul1.add("Los Angeles");
//		userInputMul1.add("0");
//		userInputMul1.add("San Francisco");
//		userInputMul1.add("2");
//		// no end airport
//		assertNull(m.getOptimalRoutesOfMultiCities(userInputMul1));
//
//		List<String> userInputMul2 = new ArrayList<>();
////		userInputMul2.add("05/15/2019");
//		userInputMul2.add("Los Angeles");
//		userInputMul2.add("0");
//		userInputMul2.add("San Francisco");
//		userInputMul2.add("2");
//		userInputMul2.add("Seattle");
//		// no start date
//		assertNull(m.getOptimalRoutesOfMultiCities(userInputMul2));
//
//		List<String> userInputMul3 = new ArrayList<>();
//		userInputMul3.add("05/15/2019");
//		userInputMul3.add("Los Angeles");
//		userInputMul3.add("0");
//		userInputMul3.add("San Francisco");
////		userInputMul3.add("2");
//		userInputMul3.add("Seattle");
//		// no stay time during for city in the middle
//		assertNull(m.getOptimalRoutesOfMultiCities(userInputMul3));

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
		MulticityAnalyzer m = new MulticityAnalyzer();
		TripLinkedList myTLL = m.generateList(userInputMul);
		assertEquals(myTLL.size(),3);
		Airport root = myTLL.getRoot();
		assertTrue(root.getTickets().get(0) instanceof NonDirectFlight);
		NonDirectFlight flight1 = (NonDirectFlight) root.getTickets().get(0);
		assertEquals(flight1.getPrice(), f1.getPrice(),10);
		assertEquals(flight1.getDuration(), f1.getDuration());
		Airport cur = root.getDestination();
		assertTrue(cur.getTickets().get(0) instanceof DirectFlight);
		DirectFlight flight2 = (DirectFlight) cur.getTickets().get(0);
		assertEquals(flight2.getPrice(), f2.getPrice(),10);
		System.out.println(flight2);
		assertEquals(flight2.getDuration()*1.0, f2.getDuration()*1.0,1);
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
//		List<IFlight> re = m.getRoute(userInputMul, 1);
//		assertEquals(re.get(0), fourth.get(0));
//		assertEquals(re.get(1), fourth.get(1));
//		// weight is 0, shortest duration possible, first one
//		re = m.getRoute(userInputMul, 0);
//		assertEquals(re.get(0), first.get(0));
//		assertEquals(re.get(1), first.get(1));
//		// half and half, still first route is best
//		re = m.getRoute(userInputMul, 0.5);
//		assertEquals(re.get(0), first.get(0));
//		assertEquals(re.get(1), first.get(1));
//		MulticityAnalyzer m = new MulticityAnalyzer(userInput);
//		assertEquals(l, m.getTickets("Los Angeles", "San Francisco", "20190422"));
//		List<String> input = new ArrayList<>();
//		input.add()
		m.generateList(userInputMul);
		List<IFlight> r = m.getRoute(userInputMul, 1);
//		List<IFlight> r = re.get(0);
		assertTrue(r.get(0) instanceof NonDirectFlight);
		NonDirectFlight flight1 = (NonDirectFlight) r.get(0);
		assertEquals(flight1.getPrice(), f1.getPrice(),10);
		assertEquals(flight1.getDuration(), f1.getDuration());

		assertTrue(r.get(1) instanceof DirectFlight);
		DirectFlight flight2 = (DirectFlight) r.get(1);
		assertEquals(flight2.getPrice(), f2.getPrice(),10);
		assertEquals(flight2.getDuration()*1.0, f2.getDuration()*1.0,1);
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
		userInput.add("Los Angeles");
		userInput.add("San Francisco");
		userInput.add("New York");
		List<IFlight> l = new LinkedList<IFlight>();
//		IFlight f1 = new DirectFlight();
//		IFlight f2 = new DirectFlight();
//		l.add(f1);
//		l.add(f2);
		MulticityAnalyzer m = new MulticityAnalyzer(userInput);
//		assertEquals(l, m.getTickets("Los Angeles", "San Francisco", "20190422"));
		List<IFlight> r = m.getTickets("lax","pek","07/15/2019");
//		List<IFlight> r = re.get(0);
		assertTrue(r.get(0) instanceof NonDirectFlight);
		NonDirectFlight flight1 = (NonDirectFlight) r.get(0);
		assertEquals(flight1.getPrice(), f1.getPrice(),10);
		assertEquals(flight1.getDuration(), f1.getDuration());
		r = m.getTickets("pek","hkg","07/17/2019");

		assertTrue(r.get(0) instanceof DirectFlight);
		DirectFlight flight2 = (DirectFlight) r.get(0);
		assertEquals(flight2.getPrice(), f2.getPrice(),10);
		assertEquals(flight2.getDuration()*1.0, f2.getDuration()*1.0,1);
	}

}
