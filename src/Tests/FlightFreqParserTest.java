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

<<<<<<< HEAD
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
=======
	@Test
	 public void flightFreqParserTest() throws FileNotFoundException{
		
		FlightFreqParser flightParse = new FlightFreqParser();
		String inputFile = "../invalid/filepath/filename";
		flightParse.fileReader(inputFile);
>>>>>>> 0761d400153ad104abab6ca3f2e8029e9dbf007c
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	
<<<<<<< HEAD
	public void freqparseTest() {
		FlightFreqParser p = new FlightFreqParser();
		TreeMap<String, TreeMap<String, AirportPair>> flightFreqTable = new TreeMap<>();
		
		try {
			flightFreqTable = p.fileReader("files/flightFreqTable/out.csv");
=======
	public void flightFreqParseFileTest() {
		FlightFreqParser flightParse = new FlightFreqParser();
		TreeMap<String, TreeMap<String, AirportPair>> fileParseTree= new TreeMap<>();
		String inputFile= "files/flightFreqTable/out.csv";
		try {
			fileParseTree = flightParse.fileReader(inputFile);
>>>>>>> 0761d400153ad104abab6ca3f2e8029e9dbf007c
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
		
		assertNull(flightFreqTable);
=======
		assertNull(fileParseTree);
>>>>>>> 0761d400153ad104abab6ca3f2e8029e9dbf007c
	}
	
		
}
