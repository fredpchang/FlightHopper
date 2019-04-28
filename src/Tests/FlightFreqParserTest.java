package Tests;
import static org.junit.Assert.*;

import java.util.*;
import java.io.*;

import FlightHopper.AirportPair;
import FlightHopper.FlightFreqParser;
import FlightHopper.FlightFreqTable;
import org.junit.Before;
import org.junit.Test;

public class FlightFreqParserTest {

	@Test
	 public void flightFreqParserTest() throws FileNotFoundException{
		
		FlightFreqParser flightParse = new FlightFreqParser();
		String inputFile = "../invalid/filepath/filename";
		flightParse.fileReader(inputFile);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	
	public void flightFreqParseFileTest() {
		FlightFreqParser flightParse = new FlightFreqParser();
		TreeMap<String, TreeMap<String, AirportPair>> fileParseTree= new TreeMap<>();
		String inputFile= "files/flightFreqTable/out.csv";
		try {
			fileParseTree = flightParse.fileReader(inputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull(fileParseTree);
	}
}
