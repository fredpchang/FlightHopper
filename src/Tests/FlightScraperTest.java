package Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import FlightHopper.DirectFlight;
import FlightHopper.FlightScraper;
import FlightHopper.IFlight;
import FlightHopper.NonDirectFlight;

public class FlightScraperTest {

	//This test is based on retrieving real-time expedia flight information, and cna change at any time
	@Test
	public void test() throws FileNotFoundException, IOException, ParseException {
		FlightScraper tst = new FlightScraper();
		String date = "04/30/2019";
		List<IFlight> l1 = tst.runScraper("nyc", "mia", date, 0);
		List<IFlight> l2 = tst.jsonParser("nyc-mia-20190430.json");
		
		assertEquals(l1.size() , l2.size());
	}
	
	@Test
	public void testParamFilter() {
		FlightScraper tst = new FlightScraper();
		DirectFlight df1 = new DirectFlight("sfo","nyc",123.4,null,"12","15","3",3,12,true,"AA","boeing");
		DirectFlight df2 = new DirectFlight("sfo","nyc",43.4,null,"12","15","3",13,12,true,"AA","boeing");
		DirectFlight df3 = new DirectFlight("sfo","nyc",87.4,null,"12","15","3",4,12,true,"AA","boeing");
		DirectFlight df4 = new DirectFlight("sfo","nyc",423.4,null,"12","15","3",2,12,true,"AA","boeing");
		DirectFlight df5 = new DirectFlight("sfo","nyc",123.4,null,"12","15","3",344,12,true,"AA","boeing");
		DirectFlight df6 = new DirectFlight("sfo","nyc",8.4,null,"12","15","3",788,12,true,"AA","boeing");

		
		NonDirectFlight n1 = new NonDirectFlight("sfo","nyc",46.2, 2, null,"12","13", "244", 244,45,false,"AA","boeing");
		NonDirectFlight n2 = new NonDirectFlight("sfo","nyc",67.2, 2, null,"12","13", "244", 12,45,false,"AA","boeing");
		NonDirectFlight n3 = new NonDirectFlight("sfo","nyc",16.2, 2, null,"12","13", "244", 4,45,false,"AA","boeing");
		NonDirectFlight n4 = new NonDirectFlight("sfo","nyc",646.2, 2, null,"12","13", "244", 9,45,false,"AA","boeing");
		NonDirectFlight n5 = new NonDirectFlight("sfo","nyc",746.2, 2, null,"12","13", "244", 24,45,false,"AA","boeing");

		List <IFlight>  l1 = new LinkedList<IFlight>();
		l1.add(df1);
		l1.add(df2);
		l1.add(df3);
		l1.add(df4);
		l1.add(df5);
		l1.add(df6);
		l1.add(n1);
		l1.add(n2);
		l1.add(n3);
		l1.add(n4);
		l1.add(n5);
		// System.out.println(l1.size());
		List <IFlight>  l2 = tst.paramFilter(134, 24, l1);
		assertTrue(l2.size() == 5);
	}
	
	@Test
	public void testParamFilter2() throws FileNotFoundException, IOException, ParseException {
		FlightScraper tst = new FlightScraper();
		
		List <IFlight>  l1 = tst.jsonParser("nyc-mia-20190430test.json");
//		System.out.println(l1.size());
//		assertEquals(l1.get(0).g);
		assertEquals(l1.size(),35);
		List <IFlight>  l2 = tst.paramFilter(134, 24, l1);
		assertTrue(l2.size() == 0);
	}
	
	@Test
	public void test3() throws FileNotFoundException, IOException, ParseException {
		FlightScraper tst = new FlightScraper();
		DirectFlight df1 = new DirectFlight("lax","nyc",123.4,null,"12","15","3",3,12,true,"AA","boeing");
		DirectFlight df2 = new DirectFlight("nyc","sfo",43.4,null,"12","15","3",13,12,true,"AA","boeing");
		NonDirectFlight n1 = new NonDirectFlight("sfo","lax",46.2, 2, null,"12","13", "244", 244,45,false,"AA","boeing");
		NonDirectFlight n2 = new NonDirectFlight("lax","sfo",67.2, 2, null,"12","13", "244", 12,45,false,"AA","boeing");
		NonDirectFlight n3 = new NonDirectFlight("sfo","nyc",16.2, 2, null,"12","13", "244", 4,45,false,"AA","boeing");
		List <IFlight>  l1 = new LinkedList<IFlight>();
		l1.add(df1);
		l1.add(df2);
		l1.add(n1);
		l1.add(n2);
		l1.add(n3);
		List <IFlight>  l2 = tst.paramFilter(134, 24, l1);
		System.out.println(l2.size());
		
		assertTrue(l2.size() == 4);
	}
	
//	@Test
//	public void testeException() {
//			FlightScraper tst = new FlightScraper();
//			assertNull(tst.jsonParser("nyc-mia-20190430error.json"));
//	}
	

}