package Tests;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.*;

import FlightHopper.AirportPair;
import FlightHopper.FlightFreqParser;
import FlightHopper.FlightFreqTable;
import org.junit.Before;
import org.junit.Test;

public class FlightFreqParserTest {

	@SuppressWarnings("rawtypes")
	@Test
	 public void flightFreqParserTest() {
		FlightFreqParser flightParse = new FlightFreqParser();
		String inputFile = "../Filpath/filename";
		
		//flightFreqTable = flightParse.fileReader(inputFile);
		
		try {
			flightParse.fileReader(inputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	
	public void freqparseTest() {
		FlightFreqParser p = new FlightFreqParser();
		TreeMap<String, TreeMap<String, AirportPair>> flightFreqTable = new TreeMap<>();
		
		try {
			flightFreqTable = p.fileReader("files/flightFreqTable/out.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNull(flightFreqTable);
	}
	
		
}
