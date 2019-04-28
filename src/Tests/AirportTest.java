package Tests;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import FlightHopper.Airport;
import FlightHopper.DirectFlight;
import FlightHopper.IFlight;

public class AirportTest {

	@Test
	public void testName() {
		
		Airport a = new Airport();
		a.setName("Los Angeles");
		
		assertEquals("Los Angeles", a.getName());
		
	}
	
	@Test
	public void testTickets() {
		List<IFlight> tickets = new LinkedList<IFlight>();
		IFlight f1 = new DirectFlight();
		IFlight f2 = new DirectFlight();
		
		tickets.add(f1);
		tickets.add(f2);
		
		Airport a = new Airport();
		a.setTickets(tickets);
		
		assertEquals(tickets, a.getTickets());
			
	}
	
	@Test
	public void testDestination() {
		Airport a1 = new Airport();
		Airport a2 = new Airport();
		a1.setDestination(a2);
		
		assertEquals(a2, a1.getDestination());
		
	}
	
	
}
