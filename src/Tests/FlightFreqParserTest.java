package Tests;
import static org.junit.Assert.*;

import java.util.*;

import FlightHopper.FlightFreqParser;
import FlightHopper.FlightFreqTable;
import org.junit.Before;
import org.junit.Test;

public class FlightFreqParserTest {

	@Test
	 public void flightFreqParserTest() {
		FlightFreqParser flightParse;
		FlightFreqTable flightFreqTable;		
		String inputFile = "../Filpath/filename";
		
		flightFreqTable = flightParse.fileReader(inputFile);
		
		
	}
}
