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
	String startAirport, startAirport2;
	String endAirPort;
	AirportPair airportP1, airportP2, airportP3;
	List<AirportPair> topPlacesList;
	PriorityQueue<AirportPair> pQueue;

	
<<<<<<< HEAD
	@Before
	 public void setUp() {
		String inputFile1 = "../Filpath/filename";
		String inputFile = "files/flightFreqTable/out.csv";
		
		pQueue = new PriorityQueue<AirportPair>((AirportPair a, AirportPair b) -> {
			return 0 - (a.getFrequency() - b.getFrequency());
		});
		
		flightFreqT = new FlightFreqTable();
		startAirport = "PHL";
		
		airportP1 = new AirportPair();				
=======
	@Test
	
	public void getTopAirportListTest() {
		flightFreqT= new FlightFreqTable();
		startAirport = "Philadelphia";
		topPlacesList = new ArrayList<>();
		
		airportP1 = new AirportPair();
				
>>>>>>> 0761d400153ad104abab6ca3f2e8029e9dbf007c
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
<<<<<<< HEAD
=======
		
		//System.out.println("list is "+flightFreqT.getTop(startAirport).size());
		System.out.println("list is "+ testList.size());
		
		assertNull(flightFreqT.getTop(startAirport));
		//assertEquals(testList.size(),flightFreqT.getTop(startAirport).size());
>>>>>>> 0761d400153ad104abab6ca3f2e8029e9dbf007c
		
		assertFalse(testList.equals(flightFreqT.getTop(startAirport2)));
	}


	@Test
	
	public void getFreqTableTest() {
<<<<<<< HEAD
=======
		flightFreqT= new FlightFreqTable();
		System.out.println(""+flightFreqT.getClass());
		//assertTrue(flightFreqT.getClass() instanceof FlightFreqTable);
		//assertThat(flightFreqT.getClass(),instanceof(FlightHopper.FlightFreqTable.class));
		//assert(flightFreqT.getClass() instanceof FlightHopper.FlightFreqTable);
		PriorityQueue<AirportPair> pQueue = new PriorityQueue<AirportPair>((AirportPair a, AirportPair b) -> {
			return 0 - (a.getFrequency() - b.getFrequency());
		});
>>>>>>> 0761d400153ad104abab6ca3f2e8029e9dbf007c
		Map<String, PriorityQueue<AirportPair>> freqMap = new HashMap<>();

		pQueue.add(airportP1);
		pQueue.add(airportP2);
		pQueue.add(airportP3);
		
		freqMap.put(startAirport, pQueue);
		//System.out.println("freq map size "+freqMap.size());
		
		flightFreqT.setFreqTable(freqMap);
		
		assertTrue(freqMap.equals(flightFreqT.getFreqTable()));
		//assertEquals(freqMap.size(), flightFreqT.getFreqTable().size());
		
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
<<<<<<< HEAD

		assertNotEquals(freqMap, freqtest1.getFreqTable());
=======
		
		assertEquals(0,flightFreqT.getFreqTable().size());
		//flightFreqT.setFreqTable(freqMap);
		
		//assertNull(flightFreqT.getFreqTable());
>>>>>>> 0761d400153ad104abab6ca3f2e8029e9dbf007c
		
	}

	@Test
	
<<<<<<< HEAD
	public void freqTableListTest() {
		FlightFreqTable freqtable = new FlightFreqTable();
		startAirport = "ANC";
		List<AirportPair> list = freqtable.getTop(startAirport);
		//System.out.println("size of list " +list.size());
		//System.out.println("size of list " +list);
		int i=0;
		//while(i<list.size()) {
		//	System.out.println("top  "+list.get(i).getEndAirport() +" with freq "+ list.get(i).getFrequency());
			i++;
		//}
	}
	
	@Test
	
=======
>>>>>>> 0761d400153ad104abab6ca3f2e8029e9dbf007c
	public void generateFreqMapTest() {
		flightFreqT= new FlightFreqTable();
		startAirport = "Philadelphia";
		
<<<<<<< HEAD
		
=======

>>>>>>> 0761d400153ad104abab6ca3f2e8029e9dbf007c

	}
	
	@Test
	
<<<<<<< HEAD
	public void setFreqTableTest() {
		Map<String, PriorityQueue<AirportPair>> freqMap = new HashMap<>();

		pQueue.add(airportP1);
		pQueue.add(airportP2);
		pQueue.add(airportP3);
		
		freqMap.put(startAirport, pQueue);

		flightFreqT.setFreqTable(freqMap);
		assertTrue(freqMap.equals(flightFreqT.getFreqTable()));
		//assertFalse(freqMap)
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
		
		//System.out.println(flightFreqT.getFreqTable().size());
		
		AirportPair a1,a2, a3;
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
		
		
		
		assertTrue(testList.equals(flightFreqT.getTop(startAirport)));
		//assertTrue(freqMap.equals(flightFreqT.getFreqTable()));
		
	}
	
	
=======
	private void setFreqTableTest() {
		flightFreqT= new FlightFreqTable();
		startAirport = "Philadelphia";
		
		
	}
>>>>>>> 0761d400153ad104abab6ca3f2e8029e9dbf007c
}
