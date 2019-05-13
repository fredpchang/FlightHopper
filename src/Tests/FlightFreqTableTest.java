package Tests;
import static org.junit.Assert.*;

import java.util.*;

import FlightHopper.Airport;
import FlightHopper.AirportPair;
import FlightHopper.FlightFreqTable;
import org.junit.Before;
import org.junit.Test;

public class FlightFreqTableTest {

	FlightFreqTable flightFreqT;
	String startAirport, startAirport2;
	String endAirPort;
	AirportPair airportP1, airportP2, airportP3;
	List<AirportPair> topPlacesList;
	PriorityQueue<AirportPair> pQueue;

	
	@Before
	 public void setUp() {
		String inputFile1 = "../Filpath/filename"; //some arbitrary invalid filepath
		String inputFile = "files/flightFreqTable/out.csv"; //proper filepath

		pQueue = new PriorityQueue<AirportPair>((AirportPair a, AirportPair b) -> {
			return 0 - (a.getFrequency() - b.getFrequency());
		});
		
		flightFreqT = new FlightFreqTable();
		startAirport = "PHL";
		System.out.println("freq map size "+flightFreqT.getFreqTable().size());
		
		airportP1 = new AirportPair();				
		airportP1.setStartAirport(startAirport);
		airportP1.setEndAirport("LAX");
		airportP1.setFrequency(100);
		
		
		airportP2 = new AirportPair();
		airportP2.setStartAirport(startAirport);
		airportP2.setEndAirport("JFK");
		airportP2.setFrequency(88);
		
		airportP3 = new AirportPair();
		airportP3.setStartAirport(startAirport);
		airportP3.setEndAirport("SFO");
		airportP3.setFrequency(70);
	
		flightFreqT.generateMap(inputFile1);
		flightFreqT.generateMap(inputFile);

	}
	
	@Test
	public void getTopAirportListTest() {
		
		startAirport2 = "ANC";
		topPlacesList = new ArrayList<>();
		topPlacesList.add(airportP1);
		topPlacesList.add(airportP2);
		topPlacesList.add(airportP3);
		
		AirportPair a1,a2, a3;
		a1 = new AirportPair();
		
		a1.setStartAirport(startAirport2);
		a1.setEndAirport("LAX");
		a1.setFrequency(100);
		
		
		a2  = new AirportPair();
		a2.setStartAirport(startAirport2);
		a2.setEndAirport("JFK");
		a2.setFrequency(88);
		
		a3 = new AirportPair();
		a3.setStartAirport(startAirport2);
		a3.setEndAirport("SFO");
		a3.setFrequency(70);

		List<AirportPair> testList = new ArrayList<>();
		
		testList.add(a1);
		testList.add(a2);
		testList.add(a3);
		
		assertFalse(testList.equals(flightFreqT.getTop(startAirport2)));
	}


	@Test
	public void getFreqTableTest() {
		Map<String, PriorityQueue<AirportPair>> freqMap = new HashMap<>();

		pQueue.add(airportP1);
		pQueue.add(airportP2);
		pQueue.add(airportP3);
		
		freqMap.put(startAirport, pQueue);
		
		flightFreqT.setFreqTable(freqMap);
		
		assertTrue(freqMap.equals(flightFreqT.getFreqTable()));
		
	}
	
	@Test
	public void freqtableTest() {
		FlightFreqTable freqtest1 = new FlightFreqTable();
		PriorityQueue<AirportPair> pQueue = new PriorityQueue<AirportPair>((AirportPair a, AirportPair b) -> {
			return 0 - (a.getFrequency() - b.getFrequency());
		});
		Map<String, PriorityQueue<AirportPair>> freqMap = new HashMap<>();
		
		startAirport = "PHL";
		
		airportP1 = new AirportPair();
				
		airportP1.setStartAirport(startAirport);
		airportP1.setEndAirport("LAX");
		airportP1.setFrequency(100);
		
		
		airportP2  = new AirportPair();
		airportP2.setStartAirport(startAirport);
		airportP2.setEndAirport("JFK");
		airportP2.setFrequency(88);
		
		airportP3 = new AirportPair();
		airportP3.setStartAirport(startAirport);
		airportP3.setEndAirport("SFO");
		airportP3.setFrequency(70);

		pQueue.add(airportP1);
		pQueue.add(airportP2);
		pQueue.add(airportP3);
		
		freqMap.put(startAirport, pQueue);

		assertNotEquals(freqMap, freqtest1.getFreqTable());
		
	}
	
	@Test
	
	public void freqTableListTest() {
		FlightFreqTable freqtable = new FlightFreqTable();
		startAirport = "ANC";
		List<AirportPair> list = freqtable.getTop(startAirport);
		assertFalse(list.isEmpty());
	
	}
	
	@Test
	
	public void generateFreqMapTest() {
		flightFreqT= new FlightFreqTable();
		startAirport = "Philadelphia";
		
		

	}
	
	@Test
	
	public void setFreqTableTest() {
		Map<String, PriorityQueue<AirportPair>> freqMap = new HashMap<>();

		pQueue.add(airportP1);
		pQueue.add(airportP2);
		pQueue.add(airportP3);
		
		freqMap.put(startAirport, pQueue);

		flightFreqT.setFreqTable(freqMap);
		assertTrue(freqMap.equals(flightFreqT.getFreqTable()));
	}
	
	@Test	
	public void getTopListTest2() {
		Map<String, PriorityQueue<AirportPair>> freqMap = new HashMap<>();
		
		startAirport2 = "JFK";
		
		pQueue.add(airportP1);
		pQueue.add(airportP2);
		pQueue.add(airportP3);

		freqMap.put(startAirport, pQueue);

		flightFreqT.setFreqTable(freqMap);
		
		AirportPair a1,a2,a3;
		a1 = new AirportPair();
		
		a1.setStartAirport(startAirport);
		a1.setEndAirport("LAX");
		a1.setFrequency(100);
		
		
		a2  = new AirportPair();
		a2.setStartAirport(startAirport);
		a2.setEndAirport("JFK");
		a2.setFrequency(88);
		
		a3 = new AirportPair();
		a3.setStartAirport(startAirport);
		a3.setEndAirport("SFO");
		a3.setFrequency(70);

		List<AirportPair> testList = new ArrayList<>();
		
		assertTrue(flightFreqT.getTop(startAirport2).isEmpty());
		testList.add(a1);
		testList.add(a2);
		testList.add(a3);
		
		
		assertFalse(flightFreqT.getTop(startAirport).isEmpty());
		
	}
	
	
	
}