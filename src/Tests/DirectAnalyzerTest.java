package Tests;

import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import FlightHopper.DirectAnalyzer;
import FlightHopper.DirectFlight;
import FlightHopper.IFlight;
import FlightHopper.TripLinkedList;

public class DirectAnalyzerTest {

	@Test
	public void getOptimalRoutesOfTwoCitiesTest() {
		List<String> userInput = new LinkedList<String>();
		userInput.add("LAX");
		userInput.add("SFO");
		userInput.add("JFK");
		List<IFlight> l = new LinkedList<IFlight>();
		IFlight f1 = new DirectFlight();
		IFlight f2 = new DirectFlight();
		l.add(f1);
		l.add(f2);
		DirectAnalyzer d = new DirectAnalyzer(userInput);
		assertEquals(l, d.getOptimalRoutesOfTwoCities(userInput));
	}
	
	@Test
	public void generateListTest() {
		List<String> userInput = new LinkedList<String>();
		userInput.add("LAX");
		userInput.add("SFO");
		userInput.add("JFK");
		TripLinkedList myTLL = new TripLinkedList();
		DirectAnalyzer d = new DirectAnalyzer(userInput);
		assertEquals(myTLL, d.generateList(userInput));
	}
	
	@Test
	public void getRouteTest() {
		List<String> userInput = new LinkedList<String>();
		userInput.add("LAX");
		userInput.add("SFO");
		userInput.add("JFK");
		List<IFlight> l = new LinkedList<IFlight>();
		IFlight f1 = new DirectFlight();
		IFlight f2 = new DirectFlight();
		l.add(f1);
		l.add(f2);
		DirectAnalyzer d = new DirectAnalyzer(userInput);
		assertEquals(l, d.getRoute(userInput, 900));
	}
	
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
		DirectAnalyzer d = new DirectAnalyzer(userInput);
		assertEquals(l, d.getTickets("LAX", "SFO", "20190422"));
	}

	
}
