package FlightHopper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class FlightFreqParser {
    private String inputFile;


    /**
     * Given the input file name, generate the flight freq table
     * @param inputFile
     * @return
     * @throws FileNotFoundException 
     */
    public TreeMap fileReader(String inputFile) throws FileNotFoundException {
        
    	/* Create DS to hold fileRead results */
    	TreeMap<String, TreeMap<String, AirportPair>> startMap = new TreeMap<>();
    	
    	
    	
    	File file = new File(inputFile);
    	
    	Scanner scan = new Scanner(file);
    	
    	int counter = 0;
    	
    	//Removes first 2 lines
    	scan.nextLine();
    	scan.nextLine();
    	
    	scan.useDelimiter(",|\n");
    	
    	while (scan.hasNextLine() && counter > -1) {
    		
    		String id = scan.next();
    		String startAirport = scan.next();
    		String endAirport = scan.next();
    		//endAirport = endAirport.replaceAll("\n", "");
    		//System.out.println(startAirport + " ---> " + endAirport);
    		
    		//create airport object
    		AirportPair a = new AirportPair();
    		a.setStartAirport(startAirport);
    		a.setEndAirport(endAirport);
    		a.setFrequency(1);
    		
    		
    		//add to map
    		
    		//if new start airport --> create new startAirport AND pq
    		if (!startMap.containsKey(startAirport)) {
    			//create new pq within each startAirport
    			TreeMap<String, AirportPair> pq = new TreeMap<>();
    			//add AirportPair to pq
    			pq.put(endAirport, a);
    			
    			//add to start airport
    			startMap.put(startAirport, pq);
    		}
    		//if existing start airport
    		else {
    			//if new end airport --> create new pq
    			if (!startMap.get(startAirport).containsKey(endAirport)) {
        			//add AirportPair to pq
        			startMap.get(startAirport).put(endAirport, a);
    			}
    			else {
        			//get existing frequency and + 1
        			int freq = startMap.get(startAirport).get(endAirport).getFrequency() + 1;
        			//update frequency
        			startMap.get(startAirport).get(endAirport).setFrequency(freq);;
    			}
    		}
    		
    		
    		counter++;
    	}
    	
    	
    	scan.close();
    	//NOTE, will need to save this result in a freq table locally!
    	
    	return startMap;
    	//return null;
    }
}
