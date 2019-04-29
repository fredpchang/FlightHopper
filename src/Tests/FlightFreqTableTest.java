package Tests;
import static org.junit.Assert.*;

import java.util.*;

import FlightHopper.Airport;
import FlightHopper.AirportPair;
import FlightHopper.FlightFreqTable;
import FlightHopper.FlightHopper;

import org.hamcrest.*;
import org.junit.Before;
import org.junit.Test;

public class FlightFreqTableTest {

	FlightFreqTable flightFreqT;
	String startAirport;
	String endAirPort;
	AirportPair airportP1, airportP2, airportP3;
	List<AirportPair> topPlacesList;
	
	@Test
	
	public void getTopAirportListTest() {
		flightFreqT= new FlightFreqTable();
		startAirport = "Philadelphia";
		topPlacesList = new ArrayList<>();
		
		airportP1 = new AirportPair();
				
		airportP1.setStartAirport(startAirport);
		airportP1.setEndAirport("Los Angeles");
		airportP1.setFrequency(100);
		
		
		airportP2 = new AirportPair();
		airportP2.setStartAirport(startAirport);
		airportP2.setEndAirport("New York");
		airportP2.setFrequency(88);
		
		airportP3 = new AirportPair();
		airportP3.setStartAirport(startAirport);
		airportP3.setEndAirport("San Franciso");
		airportP3.setFrequency(70);

		topPlacesList.add(airportP1);
		topPlacesList.add(airportP2);
		topPlacesList.add(airportP3);
		
		AirportPair a1,a2, a3;
		a1 = new AirportPair();
		
		a1.setStartAirport(startAirport);
		a1.setEndAirport("Los Angeles");
		a1.setFrequency(100);
		
		
		a2  = new AirportPair();
		a2.setStartAirport(startAirport);
		a2.setEndAirport("New York");
		a2.setFrequency(88);
		
		a3 = new AirportPair();
		a3.setStartAirport(startAirport);
		a3.setEndAirport("San Francisco");
		a3.setFrequency(70);

		List<AirportPair> testList = new ArrayList<>();
		
		testList.add(a1);
		testList.add(a2);
		testList.add(a3);
		
		//System.out.println("list is "+flightFreqT.getTop(startAirport).size());
		System.out.println("list is "+ testList.size());
		
		assertNull(flightFreqT.getTop(startAirport));
		//assertEquals(testList.size(),flightFreqT.getTop(startAirport).size());
		
	}


	@Test
	
	public void getFreqTableTest() {
		flightFreqT= new FlightFreqTable();
		System.out.println(""+flightFreqT.getClass());
		//assertTrue(flightFreqT.getClass() instanceof FlightFreqTable);
		//assertThat(flightFreqT.getClass(),instanceof(FlightHopper.FlightFreqTable.class));
		//assert(flightFreqT.getClass() instanceof FlightHopper.FlightFreqTable);
		PriorityQueue<AirportPair> pQueue = new PriorityQueue<AirportPair>((AirportPair a, AirportPair b) -> {
			return 0 - (a.getFrequency() - b.getFrequency());
		});
		Map<String, PriorityQueue<AirportPair>> freqMap = new HashMap<>();
		
		startAirport = "Philadelphia";
		
		airportP1 = new AirportPair();
				
		airportP1.setStartAirport(startAirport);
		airportP1.setEndAirport("Los Angeles");
		airportP1.setFrequency(100);
		
		
		airportP2  = new AirportPair();
		airportP2.setStartAirport(startAirport);
		airportP2.setEndAirport("New York");
		airportP2.setFrequency(88);
		
		airportP3 = new AirportPair();
		airportP3.setStartAirport(startAirport);
		airportP3.setEndAirport("San Franciso");
		airportP3.setFrequency(70);

		pQueue.add(airportP1);
		pQueue.add(airportP2);
		pQueue.add(airportP3);
		
		freqMap.put(startAirport, pQueue);
		
		assertEquals(0,flightFreqT.getFreqTable().size());
		//flightFreqT.setFreqTable(freqMap);
		
		//assertNull(flightFreqT.getFreqTable());
		
	}

	@Test
	
	public void generateFreqMapTest() {
		flightFreqT= new FlightFreqTable();
		startAirport = "Philadelphia";
		


	}
	
	@Test
	
	private void setFreqTableTest() {
		flightFreqT= new FlightFreqTable();
		startAirport = "Philadelphia";
		
		
	}
}
