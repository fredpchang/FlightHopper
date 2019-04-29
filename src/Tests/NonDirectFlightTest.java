package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import FlightHopper.Airport;
import FlightHopper.DirectFlight;
import FlightHopper.NonDirectFlight;
public class NonDirectFlightTest {

	//Set up default flights
	NonDirectFlight f1, f2, f3;

	@Before
	public void setUp() {

		//Initialize airports
		f1 = new NonDirectFlight();
		f2 = new NonDirectFlight();
		f3 = new NonDirectFlight();

		//Set up flights start and end PHL-LAX-SFO-SEA
		f1.setStartAirport("PHL");
		f1.setEndAirport("LAX");
		f2.setStartAirport("LAX");
		f2.setEndAirport("SFO");
		f3.setStartAirport("SFO");
		f3.setEndAirport("SEA");

		//Set up flight prices
		f1.setPrice(200);
		f2.setPrice(50);
		f3.setPrice(80);

		//Set up durations
		f1.setDuration(5);
		f2.setDuration(1);
		f3.setDuration(2);

		//Set all to direct flights
		f1.setDirect(false);
		f2.setDirect(false);
		f3.setDirect(false);

		//Set up airlines
		f1.setAirline("UA");
		f2.setAirline("AA");
		f3.setAirline("AL");

		//Set plane
		f1.setPlane("Boeing 737-800");
		f2.setPlane("Airbus A320");
		f3.setPlane("Airbus A321");

		/* Unique */
		//Set stops
		f1.setStops(2);
		f2.setStops(3);
		f3.setStops(4);

	}

	@Test
	public void checkValidTest() {
		NonDirectFlight flight1 = new NonDirectFlight();
		NonDirectFlight flight2 = new NonDirectFlight();

		flight1.setStartTime("20190515");
		flight1.setEndTime("20190515");
		flight2.setStartTime("20190515");
		flight2.setEndTime("20190515");
		flight1.getStartTime();
		flight1.getEndTime();

		assertTrue(flight1.checkValid(flight2));

	}

	@Test
	public void getFlightRankTest() {
		NonDirectFlight flight = new NonDirectFlight();
		double price = 650; //dollars
		int duration = 13; //hours
		double priceWeight = 0.3; //arbitrary weight
		flight.setRank(65000);

		//rank formula = (priceInDollar * priceWeight + flightDuration*50*(1-priceWeight)) * 100
		int expRank = (int) (price * priceWeight + duration*50*(1-priceWeight)) * 100;

		assertEquals(expRank, flight.getRank());

		flight.getFlightRank(priceWeight);

	}

	@Test
	public void startAirportTest() {

		assertEquals("PHL", f1.getStartAirport());
	}

	@Test
	public void endAirportTest() {

		assertEquals("LAX", f1.getEndAirport());
	}

	@Test
	public void priceTest() {

		int output = (int) f3.getPrice();

		assertEquals(80, output);

	}

	@Test
	public void routingTest() {
		ArrayList<String> routing = new ArrayList();
		routing.add("1");
		routing.add("2");
		routing.add("3");
		f1.setRouting(routing);
		assertEquals(routing, f1.getRouting());
	}

	@Test
	public void flightDurationTest() {
		f1.setFlightDuration("0 days 5 hours 32 minutes");
		assertEquals("0 days 5 hours 32 minutes", f1.getFlightDuration());
	}

	@Test
	public void durationTest() {
		assertEquals(5, f1.getDuration());
	}

	@Test
	public void isDirectTest() {

		assertEquals(false, f1.isDirect());
	}

	@Test
	public void airlineTest() {

		assertEquals("UA", f1.getAirline());
	}

	@Test
	public void planeTest() {

		assertEquals("Airbus A320", f2.getPlane());
	}

	@Test
	public void stopsTest() {
		assertEquals(3, f2.getStops());
	}

	@Test
	public void equalsTest() {
		String startAirport = "LAX";
		String endAirport = "SFO";
		double price = 500;
		int stops = 1;
		ArrayList<String> routing = new ArrayList<String>();
		routing.add("routing A");
		routing.add("routing B");
		String startTime = "20190520";
		String endTime = "20190521";
		String flightDuration = "0 days 5 hours 32 minutes";
		int duration = 5;
		int rank = 2500;
		boolean isDirect = false;
		String airline = "United";
		String plane = "Being 737 Max";

		NonDirectFlight e1 = new NonDirectFlight(
												startAirport,
												endAirport,
												price,
												stops,
												routing,
												startTime,
												endTime,
												flightDuration,
												duration,
												rank,
												isDirect,
												airline,
												plane
											);
		
		NonDirectFlight e2 = new NonDirectFlight(
				startAirport,
				endAirport,
				price,
				stops,
				routing,
				startTime,
				endTime,
				flightDuration,
				duration,
				rank,
				isDirect,
				airline,
				plane
			);
		
		DirectFlight e3 = new DirectFlight(
				startAirport,
				endAirport,
				price,
				routing,
				startTime,
				endTime,
				flightDuration,
				duration,
				rank,
				isDirect,
				airline,
				plane
			);
		
		assertTrue(e1.equals(e2));
		assertTrue(e1.equals(e3));
		
	}

	@Test
	public void constructorTestAndPrintTest() {

		String startAirport = "LAX";
		String endAirport = "SFO";
		double price = 500;
		int stops = 1;
		ArrayList<String> routing = new ArrayList<String>();
		routing.add("routing A");
		routing.add("routing B");
		String startTime = "20190520";
		String endTime = "20190521";
		String flightDuration = "0 days 5 hours 32 minutes";
		int duration = 5;
		int rank = 2500;
		boolean isDirect = false;
		String airline = "United";
		String plane = "Being 737 Max";

		NonDirectFlight f = new NonDirectFlight(
												startAirport,
												endAirport,
												price,
												stops,
												routing,
												startTime,
												endTime,
												flightDuration,
												duration,
												rank,
												isDirect,
												airline,
												plane
											);

		//Test printflight
		f.printFlight();
		f.toString();

		assertEquals(airline, f.getAirline());
	}









}
