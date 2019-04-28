package FlightHopper;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

//need to add jar file into build path
//Select project ---> Build Path ---> Configure Build Path ---> Add ExternalJARs ---> json-simple-1.1.1.jar
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class FlightScraper {
    private Map<IFlight, List<IFlight>> cache;
    private int maxPrice = Integer.MAX_VALUE;
    private int maxDuration = Integer.MAX_VALUE;

    /**
     * Run the python scraper at run time using parameters
     * @param startAirport start airport
     * @param endAirport end airport
     * @param date the date
     * @param flex flexibility
     * @return the list of tickets
     * @throws ParseException
     * @throws IOException
     * @throws FileNotFoundException
     */
    public List<IFlight> runScraper(String startAirport, String endAirport, String date1, int flex) throws FileNotFoundException, IOException, ParseException {
    	List<IFlight> to_return = new LinkedList<IFlight>();
		String[] dateData = date1.split("/");
		if(dateData.length != 3) return null;
//		System.out.println(date1);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar date = new GregorianCalendar(Integer.valueOf(dateData[2]),Integer.valueOf(dateData[0])-1,
				Integer.valueOf(dateData[1]));
    	for (int i = 0; i <= flex; i++) {
			date.add(Calendar.DATE, i);
    		to_return.addAll(scraperPyHelper(startAirport, endAirport, sdf.format(date.getTime())));
			date.add(Calendar.DATE, -i);
    	}
//    	scraperPyHelper(startAirport, endAirport, date);
    	// expedia.py nyc mia 04/30/2019
//    	return to_return;
//		System.out.println(to_return.size());
    	return to_return;
    }

    /**
     * Run the scraper on one single day
     * @param startAirport
     * @param endAirport
     * @param date
     * @return List<IFlight>
     * @throws ParseException
     * @throws IOException
     * @throws FileNotFoundException
     */
    private List<IFlight> scraperPyHelper(String startAirport, String endAirport, String date) {
		String pythonPath = "/Users/chezhenhao/Library/Enthought/Canopy/edm/envs/User/bin/python3";

		Runtime rt = Runtime.getRuntime();
    	try {
//    		String command = pythonPath + " expedia.py " + startAirport + " " +  endAirport + " " + date;
			String command = "/Users/chezhenhao/Library/Enthought/Canopy/edm/envs/User/bin/python3 expedia.py " +
					startAirport + " " + endAirport + " " + date;
			System.out.println(command);
    		Process p = rt.exec(command);
    		p.waitFor();

//			System.out.println("finish");
			String filename= startAirport + "-" + endAirport + "-flight-results.json";
			return jsonParser(filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

//				String file = "/Users/chezhenhao/Desktop/UPenn-courses/CIT594/proj/flight/expedia.py";

//		try {
//
//			ProcessBuilder pb = new ProcessBuilder(pythonPath + "/" + "python3","expedia.py sfo phl 05/15/2019");
//
//			Process p = pb.start();
//			p.waitFor();
//			System.out.println("here");
//		}
//		catch(Exception e) {
//					System.out.println("Python error");
//		}

//			return null;
		}




    /**
     * Given the filename, parse the json file into
     * a list of flights
     * @param fileName
     * @return
     * @throws ParseException
     * @throws IOException
     * @throws FileNotFoundException
     */
    List <IFlight> jsonParser(String fileName) throws FileNotFoundException, IOException, ParseException {
    //NOTE: removed "private" word above in order to test from FlightHopper.java class!!!

		List<IFlight> re = new ArrayList<>();
        //TODO - to be done by Fred

    	/* Set up Parser */
    	//Note: need to import ison-simple jar
    	JSONParser parser = new JSONParser();
    	JSONArray jsonArray =  (JSONArray) parser.parse(new FileReader(fileName));
//    	System.out.println(jsonArray); //Note: enable to test print all content in jsonArray


    	/* Read each flight and save as IFlight object */
    	for (int i = 0 ; i < jsonArray.size() ; i++) {
    		JSONObject jo = (JSONObject) jsonArray.get(i);

    		//Number of Stops
    		String stops = (String) jo.get("stops");

    		//Ticket Price
    		String ticketPrice = (String) jo.get("ticket price");

    		//Departure City
    		String departure = (String) jo.get("departure");
    		departure = departure.substring(2);

    		//Arrival City
    		String arrival= (String) jo.get("arrival");
    		arrival = arrival.substring(2);

    		//Flight Duration
    		String flightDuration = (String) jo.get("flight duration");

    		//Airline
    		String airline = (String) jo.get("airline");

    		//Plane Type
    		String plane = (String) jo.get("plane");

    		//Detailed itinerary for flight
    		Object timings = jo.get("timings"); //need more work
    		JSONArray timingsArray = (JSONArray) timings;

    		/* Print all info to console */
//    		System.out.println("---------------- Option " + i + " ----------------");
//    		System.out.printf("[%s] ---> [%s] \n", departure, arrival);
//    		System.out.println(stops);
//    		System.out.println("$" + ticketPrice);
//    		System.out.println(flightDuration);
//    		System.out.println(airline + " " + plane);
    		for (int j = 0 ; j < timingsArray.size() ; j++) {
    			JSONObject t = (JSONObject) timingsArray.get(j);
    			String departureAirport = (String) t.get("departure_airport");
    			String departureTime = (String) t.get("departure_time");
    			String arrivalAirport = (String) t.get("arrival_airport");
    			String arrivalTime = (String) t.get("arrival_time");
//    			System.out.printf("%s (%s) --> %s (%s)", departureAirport, departureTime, arrivalAirport, arrivalTime);
//    			System.out.println("");
    		}
//    		System.out.println("\n \n");



    		/* Populate Flight objects */


    		//Common fields for both flight types
    		String startAirport = departure;
    		String endAirport = arrival;
    		String price = ticketPrice;
    		String startTime = "TBD";
    		String endTime = "TBD";
			int duration = Integer.valueOf(flightDuration.split("days")[0].trim())*24 +
					Integer.valueOf(flightDuration.split("( days | hours )")[1].trim()) ;
			duration += (Integer.valueOf(flightDuration.split("( days | hours | minutes)")[2])/60.0) > 0.5 ? 1 : 0;
//    		airline = airline; //airline is as-is
//    		plane = plane; //plane is as-is

    		/* Determine if DirectFlight or NonDirectFlight */
    		if (stops.equals("Nonstop")) {
    			//initialize unique fields
    			boolean isDirect = true;

    			//Create DirectFlight object
    			IFlight f = new DirectFlight(startAirport,endAirport,
						Double.valueOf(price), startTime, endTime, duration, true, airline,plane);
    			re.add(f);
    		}
    		else {
    			boolean isDirect = false;
    			//Create NonDirectFlight object
				int stop = Integer.valueOf(stops.split(" Stop")[0]);
//    			IFlight f = new NonDirectFlight();
				IFlight f = new NonDirectFlight(startAirport,endAirport,
						Double.valueOf(price),stop, startTime, endTime, duration, true, airline,plane);

				re.add(f);
    		}

    	}


    	return re;





    }

    /**
     * given the list of tickets, filter with max price and max duration,
     * and return the result list
     * @param maxPrice
     * @param maxDuration
     * @param rawData
     * @return
     */
    public List <IFlight> paramFilter(int maxPrice, int maxDuration, List<IFlight> rawData) {
    	List <IFlight> to_delete = new LinkedList<IFlight>();
    	for (int i = 0; i < rawData.size(); i++) {
    		if (rawData.get(i) instanceof DirectFlight) {
    			if ( ((DirectFlight)rawData.get(i)).getPrice() > maxPrice || ((DirectFlight)rawData.get(i)).getDuration() > maxDuration ) {
    				to_delete.add(rawData.get(i));
    			}
    		}
    		else if (rawData.get(i) instanceof NonDirectFlight) {
    			if ( ((NonDirectFlight)rawData.get(i)).getPrice() > maxPrice || ((NonDirectFlight)rawData.get(i)).getDuration() > maxDuration ) {
    				to_delete.add(rawData.get(i));
    			}
    		}
    	}
    	rawData.removeAll(to_delete);
        return rawData;
    }

    /**
     * get cache map
     * @return cache map
     */
    public Map<IFlight, List<IFlight>> getCache() {
        return cache;
    }

    /**
     * set cache map
     * @param cache
     */
    public void setCache(Map<IFlight, List<IFlight>> cache) {
        this.cache = cache;
    }

    /**
     * get the max price
     * @return max price
     */
    public int getMaxPrice() {
        return maxPrice;
    }

    /**
     * set max price
     * @param maxPrice
     */
    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * get max duration of flight
     * @return max duration of flight
     */
    public int getMaxDuration() {
        return maxDuration;
    }

    /**
     * set max duration of flight
     * @param maxDuration
     */
    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }
}
