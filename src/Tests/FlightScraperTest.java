//package Tests;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import FlightHopper.Airport;
//import FlightHopper.DirectFlight;
//import FlightHopper.FlightScraper;
//import FlightHopper.IFlight;
//
//public class FlightScraperTest {
//
//	FlightScraper s;
//	List<IFlight> list;
//
//	String startAirport = "Philadelphia";
//	String endAirport = "Los Angeles";
//	String date = "201905151800"; //format: yyyymmddhhmm
//	int flex = 1;
//
//	DirectFlight f1, f2, f3, f4;
//	Airport phl, lax, sfo;
//
//	@Before
//	public void setUp() throws Exception{
//
//		s = new FlightScraper();
//
//		list = new LinkedList<IFlight>();
//
//		phl = new Airport();
//		phl.setName("Philadelphia");
//		phl.setDestination(sfo);
//
//		lax = new Airport();
//		lax.setName("Los Angeles");
//		lax.setDestination(sfo);
//
//
//		sfo = new Airport();
//		sfo.setName("San Francisco");
//
//	}
//
//	@Test
//	public void testRunScraper() {
//		List<IFlight> output = s.runScraper(startAirport, endAirport, date, flex);
//
//		List<IFlight> expected = new LinkedList<IFlight>();
//		//add to expected list below
//		expected.add(f1);
//		expected.add(f2);
//		expected.add(f3);
//
//		assertTrue(expected.equals(output));
//
//	}
//
//	@Test
//	public void testCache() {
//
//		Map <IFlight, List<IFlight>> expected = new HashMap<IFlight, List<IFlight>>();
//		expected.put(f1, list);
//
//		assertTrue(expected.equals(s.getCache()));
//
//	}
//
//	@Test
//	public void testMaxPrice() {
//		s.setMaxPrice(1000);
//
//		assertEquals(1000, s.getMaxPrice());
//
//	}
//
//	@Test
//	public void testMaxDuration() {
//		s.setMaxDuration(5);
//
//		assertEquals(5, s.getMaxDuration());
//	}
//
//
//}
