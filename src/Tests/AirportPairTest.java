package Tests;
import static org.junit.Assert.*;

import java.util.*;

import FlightHopper.AirportPair;
import org.junit.Before;
import org.junit.Test;

public class AirportPairTest {

	AirportPair emptyAirport;
	
	@Before
	
	public void setup() throws Exception{
		
		emptyAirport = new AirportPair();
		
		emptyAirport.setStartAirport(null);
		emptyAirport.setEndAirport("Philadelphia");
		emptyAirport.setFrequency(10);
		
	}
	@Test
	
	public void initAirportPairTest() {
		String startAirport = "Philadelphia";
		String endAirport = "Los Angeles";
		int freq = 100;
		AirportPair airport1 = new AirportPair();
		
		assertNull(airport1.getStartAirport());
		assertNull(airport1.getEndAirport());
		assertEquals(-1,airport1.getFrequency());
		
		airport1.setStartAirport(startAirport);
		airport1.setEndAirport(endAirport);
		airport1.setFrequency(freq);
		
		assertEquals("Philadelphia",airport1.getStartAirport());
		assertEquals("Los Angeles", airport1.getEndAirport());
		assertEquals(100, airport1.getFrequency());
		
	}
}
