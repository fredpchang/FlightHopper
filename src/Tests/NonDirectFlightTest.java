package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import FlightHopper.NonDirectFlight;
public class NonDirectFlightTest {

	@Test
	public void checkValidTest() {
		NonDirectFlight f1 = new NonDirectFlight();
		NonDirectFlight f2 = new NonDirectFlight();
		
		f1.setStartTime("201905151200");
		f1.setEndTime("201905151800");
		f2.setStartTime("201905151500");
		f2.setEndTime("201905152000");
	}
	
	@Test
	public void getFlightRankTest() {
		NonDirectFlight flight = new NonDirectFlight();
		double price = 650; //dollars
		int duration = 13; //hours
		double priceWeight = 0.3; //arbitrary weight
		
		//rank formula = (priceInDollar * priceWeight + flightDuration*50*(1-priceWeight)) * 100
		int expRank = (int) (price * priceWeight + duration*50*(1-priceWeight)) * 100;
		
		assertEquals(expRank, flight.getRank());
		
	}
	
	@Test
	public void isDirectTest() {
		NonDirectFlight flight = new NonDirectFlight();
		flight.setDirect(true);
		
		assertTrue(flight.isDirect());
	}
	
}
