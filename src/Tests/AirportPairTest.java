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
		emptyAirport.setEndAirport("PHL");
		emptyAirport.setFrequency(10);
		
	}
	@Test
	
	public void initAirportPairTest() {
		String startAirport = "PHL";
		String endAirport = "LAX";
		int freq = 100;
		AirportPair airport1 = new AirportPair();
		
		assertNull(airport1.getStartAirport());
		assertNull(airport1.getEndAirport());
		assertEquals(-1,airport1.getFrequency());
		
		airport1.setStartAirport(startAirport);
		airport1.setEndAirport(endAirport);
		airport1.setFrequency(freq);
		
		assertEquals("PHL",airport1.getStartAirport());
		assertEquals("LAX", airport1.getEndAirport());
		assertEquals(100, airport1.getFrequency());
		
	}
}