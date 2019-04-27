package FlightHopper;

import java.io.IOException;
import java.util.*;

import org.json.simple.parser.ParseException;

public class FlightHopper {
    public int queryType;
//    Map<String, Airport> airports = new HashMap<>();

    public static void main(String[] args) {
    	FlightScraper fs = new FlightScraper();
    	
    	try {
			fs.jsonParser("files/jsonFlights/phl-sfo-flight-results.json");
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
