package FlightHopper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.json.simple.parser.ParseException;

public class FlightHopper {
    public int queryType;
//    Map<String, Airport> airports = new HashMap<>();

    public static void main(String[] args) {
//    	FlightScraper fs = new FlightScraper();
    	
//    	try {
//			fs.jsonParser("files/jsonFlights/phl-sfo-flight-results.json");
//		} catch (IOException | ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	FlightScraper tst = new FlightScraper();
		String[] dates = {"04/30/2019", "04/31/2019"};
		try {
			tst.runScraper("sfo", "nyc", dates);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
