package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import FlightHopper.DirectFlight;
import FlightHopper.NonDirectFlight;

public class DirectFlightTest {

	//Set up default flights
	DirectFlight f1, f2, f3;

	@Before
	public void setUp() {

		//Initialize airports
		f1 = new DirectFlight();
		f2 = new DirectFlight();
		f3 = new DirectFlight();
		
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
		f1.setDirect(true);
		f2.setDirect(true);
		f3.setDirect(true);

		//Set up airlines
		f1.setAirline("UA");
		f2.setAirline("AA");
		f3.setAirline("AL");

		//Set plane
		f1.setPlane("Boeing 737-800");
		f2.setPlane("Airbus A320");
		f3.setPlane("Airbus A321");

	}

	@Test
	public void checkValidTest() {
		DirectFlight flight1 = new DirectFlight();
		DirectFlight flight2 = new DirectFlight();

		//dateandtime format: yyyymmdd
		flight1.setStartTime("20190515");
		flight1.setEndTime("20190515");
		flight2.setStartTime("20190516");
		flight2.setEndTime("20190517");

		assertTrue(flight1.checkValid(flight2));
	}

	@Test
	public void getFlightRankTest() {
		DirectFlight flight = new DirectFlight();
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
	public void durationTest() {

		assertEquals(5, f1.getDuration());
	}

	@Test
	public void isDirectTest() {

		assertEquals(true, f1.isDirect());
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
	public void equalsTest() {
		assertTrue(!f1.equals(f2));
	}
	
	@Test
	public void constructorTestAndPrintTest() {
		
		String startAirport = "LAX";
		String endAirport = "SFO";
		double price = 500;
		ArrayList<String> routing = new ArrayList<String>();
		routing.add("routing A");
		routing.add("routing B");
		String startTime = "20190520";
		String endTime = "20190521";
		String flightDuration = "0 days 5 hours 32 minutes";
		int duration = 5;
		int rank = 2500;
		boolean isDirect = true;
		String airline = "United";
		String plane = "Being 737 Max";
		
		DirectFlight f = new DirectFlight(
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
		
		//Test printflight
		f.printFlight();
		f.toString();
		f.setRouting(routing);
		f.getRouting();
		f.getEndTime();
		
		assertEquals(airline, f.getAirline());
	}





}
