package Tests;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.*;

import FlightHopper.FlightFreqParser;
import FlightHopper.FlightFreqTable;
import org.junit.Before;
import org.junit.Test;

public class FlightFreqParserTest {

//	@Test
//	 public void flightFreqParserTest() {
//		FlightFreqParser flightParse = new FlightFreqParser();
//		TreeMap flightFreqTable;		
//		String inputFile = "../Filpath/filename";
//		
//		flightFreqTable = flightParse.fileReader(inputFile);
//		
//		
//	}
	
	@Test
	
	public void freqparseTest() {
		FlightFreqParser p = new FlightFreqParser();
		System.out.println("HI");
		
		try {
			p.fileReader("files/flightFreqTable/out.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
