//package Tests;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import FlightHopper.Airport;
//import FlightHopper.DirectFlight;
//
//public class DirectFlightTest {
//
//	//Set up default airports
//	Airport phl, lax, sfo, sea;
//
//	//Set up default flights
//	DirectFlight f1, f2, f3;
//
//	@Before
//	public void setUp() {
//		//Set up airports
//		phl.setName("Philadelphia");
//		lax.setName("Los Angeles");
//		sfo.setName("San Francisco");
//		sea.setName("Seattle");
//
//		//Set up flights start and end PHL-LAX-SFO-SEA
//		f1.setStartAirport(phl);
//		f1.setEndAirport(lax);
//		f2.setStartAirport(lax);
//		f2.setEndAirport(sfo);
//		f3.setStartAirport(sfo);
//		f3.setEndAirport(sea);
//
//		//Set up flight prices
//		f1.setPrice(200);
//		f2.setPrice(50);
//		f3.setPrice(80);
//
//		//Set up durations
//		f1.setDuration(5);
//		f2.setDuration(1);
//		f3.setDuration(2);
//
//		//Set all to direct flights
//		f1.setDirect(true);
//		f2.setDirect(true);
//		f3.setDirect(true);
//
//		//Set up airlines
//		f1.setAirline("UA");
//		f2.setAirline("AA");
//		f3.setAirline("AL");
//
//		//Set plane
//		f1.setPlane("Boeing 737-800");
//		f2.setPlane("Airbus A320");
//		f3.setPlane("Airbus A321");
//
//	}
//
//	@Test
//	public void checkValidTest() {
//		DirectFlight flight1 = new DirectFlight();
//		DirectFlight flight2 = new DirectFlight();
//
//		//dateandtime format: yyyymmddhhmm
//		flight1.setStartTime("201905151200");
//		flight1.setEndTime("201905151800");
//		flight2.setStartTime("201905151500");
//		flight2.setEndTime("201905152000");
//
//		assertTrue(flight1.checkValid(flight2));
//	}
//
//	@Test
//	public void getFlightRankTest() {
//		DirectFlight flight = new DirectFlight();
//		double price = 650; //dollars
//		int duration = 13; //hours
//		double priceWeight = 0.3; //arbitrary weight
//
//		//rank formula = (priceInDollar * priceWeight + flightDuration*50*(1-priceWeight)) * 100
//		int expRank = (int) (price * priceWeight + duration*50*(1-priceWeight)) * 100;
//
//		assertEquals(expRank, flight.getRank());
//
//	}
//
//	@Test
//	public void startAirportTest() {
//
//		assertEquals("Philadelphia", f1.getStartAirport());
//	}
//
//	@Test
//	public void endAirportTest() {
//
//		assertEquals("Los Angeles", f1.getEndAirport());
//	}
//
//	@Test
//	public void priceTest() {
//
//		int output = (int) f3.getPrice();
//
//		assertEquals(80, output);
//
//	}
//
//	@Test
//	public void durationTest() {
//
//		assertEquals(5, f1.getDuration());
//	}
//
//	@Test
//	public void isDirectTest() {
//
//		assertEquals(true, f1.isDirect());
//	}
//
//	@Test
//	public void airlineTest() {
//
//		assertEquals("UA", f1.getAirline());
//	}
//
//	@Test
//	public void planeTest() {
//
//		assertEquals("Boeing 737-800", f2.getPlane());
//	}
//
//
//
//
//
//}
