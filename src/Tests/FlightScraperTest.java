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
		DirectFlight df1 = new DirectFlight();
		df1.setPrice(123.4);
		df1.setDuration(3);
		DirectFlight df2 = new DirectFlight();
		df2.setPrice(43.4);
		df2.setDuration(13);
		DirectFlight df3 = new DirectFlight();
		df3.setPrice(87.4);
		df3.setDuration(4);
		DirectFlight df4 = new DirectFlight();
		df4.setPrice(423.4);
		df4.setDuration(2);
		DirectFlight df5 = new DirectFlight();
		df5.setPrice(123.4);
		df5.setDuration(344);
		DirectFlight df6 = new DirectFlight();
		df6.setPrice(8.4);
		df6.setDuration(788);
		NonDirectFlight n1 = new NonDirectFlight();
		n1.setPrice(46.2);
		n1.setDuration(244);
		NonDirectFlight n2 = new NonDirectFlight();
		n2.setPrice(67.2);
		n2.setDuration(12);
		NonDirectFlight n3 = new NonDirectFlight();
		n3.setPrice(16.2);
		n3.setDuration(4);
		NonDirectFlight n4 = new NonDirectFlight();
		n4.setPrice(646.2);
		n4.setDuration(9);
		NonDirectFlight n5 = new NonDirectFlight();
		n5.setPrice(467.2);
		n5.setDuration(24);
		List <IFlight> l1 = new LinkedList<IFlight>();
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
		List <IFlight>  l2 = tst.paramFilter(134, 24, l1);
//		assertTrue(l2.size() == 5);
	}
	
	@Test
	public void testParamFilter2() throws FileNotFoundException, IOException, ParseException {
		FlightScraper tst = new FlightScraper();
		
		List <IFlight>  l1 = tst.jsonParser("nyc-mia-20190430.json");
		List <IFlight>  l2 = tst.paramFilter(134, 24, l1);
		assertTrue(l2.size() == 0);
	}
	
	@Test
	public void testParamFilter3() throws FileNotFoundException, IOException, ParseException {
		FlightScraper tst = new FlightScraper();
		
		List <IFlight>  l1 = tst.jsonParser("nyc-mia-20190430.json");
		List <IFlight>  l2 = tst.paramFilter(600, 24, l1);
		assertTrue(l2.size() == 2);
	}
	
	
	

}