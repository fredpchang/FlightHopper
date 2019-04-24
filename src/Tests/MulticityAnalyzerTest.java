package Tests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import FlightHopper.DirectAnalyzer;
import FlightHopper.DirectFlight;
import FlightHopper.IFlight;
import FlightHopper.MulticityAnalyzer;
import FlightHopper.TripLinkedList;

public class MulticityAnalyzerTest {

	@Test
	public void getOptimalRoutesOfMultiCities() {
		List<String> userInput = new LinkedList<String>();
		userInput.add("LAX");
		userInput.add("SFO");
		userInput.add("JFK");
		List<IFlight> l = new LinkedList<IFlight>();
		IFlight f1 = new DirectFlight();
		IFlight f2 = new DirectFlight();
		l.add(f1);
		l.add(f2);
		MulticityAnalyzer m = new MulticityAnalyzer(userInput);
		assertEquals(l, m.getOptimalRoutesOfMultiCities(userInput));
	}
	
	@Test
	public void generateListTest() {
		List<String> userInput = new LinkedList<String>();
		userInput.add("LAX");
		userInput.add("SFO");
		userInput.add("JFK");
		TripLinkedList myTLL = new TripLinkedList();
		MulticityAnalyzer m = new MulticityAnalyzer(userInput);
		assertEquals(myTLL, m.generateList(userInput));
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
		MulticityAnalyzer m = new MulticityAnalyzer(userInput);
		assertEquals(l, m.getRoute(userInput, 900));
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
		MulticityAnalyzer m = new MulticityAnalyzer(userInput);
		assertEquals(l, m.getTickets("LAX", "SFO", "20190422"));
	}

}
