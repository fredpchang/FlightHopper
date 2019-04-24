package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import FlightHopper.DirectFlight;

public class DirectFlightTest {
	
	@Test
	public void checkValidTest() {
		DirectFlight f1 = new DirectFlight();
		DirectFlight f2 = new DirectFlight();
		
		f1.setStartTime("201905151200");
		f1.setEndTime("201905151800");
		f2.setStartTime("201905151500");
		f2.setEndTime("201905152000");
	}
	
	@Test
	public void getFlightRankTest() {
		DirectFlight flight = new DirectFlight();
		double price = 650; //dollars
		int duration = 13; //hours
		double priceWeight = 0.3; //arbitrary weight
		
		//rank formula = (priceInDollar * priceWeight + flightDuration*50*(1-priceWeight)) * 100
		int expRank = (int) (price * priceWeight + duration*50*(1-priceWeight)) * 100;
		
		assertEquals(expRank, flight.getRank());
		
	}
	
	@Test
	public void isDirectTest() {
		DirectFlight flight = new DirectFlight();
		flight.setDirect(true);
		
		assertTrue(flight.isDirect());
	}
	
}
