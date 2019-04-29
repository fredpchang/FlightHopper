package FlightHopper;
import java.io.FileNotFoundException;
import java.util.*;

public class FlightFreqTable {
    private Map<String, PriorityQueue<AirportPair>> freqTable 
    = new HashMap<>();
    
    private static int TOP_DEST =5;

    /**
     * get top several destinations from start airport
     * @param startAirport
     * @return
     */
    public List<AirportPair> getTop(String startAirport) {
    	Map<String, PriorityQueue<AirportPair>> getFreqTableMap = this.freqTable;
    	//Map<String, PriorityQueue<AirportPair>> getFreqTableMap = getFreqTable() ;
    	List<AirportPair> topFreqList = new ArrayList<>();
    	// check if the freq table size is 0
    	if (getFreqTableMap.isEmpty())
    		return topFreqList;
    	
    	if(getFreqTableMap.containsKey(startAirport)) {
    		PriorityQueue<AirportPair> retpq = new PriorityQueue<AirportPair>();
    		retpq = getFreqTableMap.get(startAirport);
    		if(retpq.size() < TOP_DEST) {
    			int listsize = retpq.size();
    			for(int i=0; i < listsize; i++) {
    				AirportPair topAP = new AirportPair();
    				topAP = retpq.poll();
    				topFreqList.add(topAP);
    				}
    		}
    		else {

    			for(int i=0; i < TOP_DEST; i++) {
    				AirportPair topAP = new AirportPair();
    				topAP = retpq.poll();
    				topFreqList.add(topAP);
    				}
    			
    		}
    		 return topFreqList;
    	}
    		
    	return topFreqList;
    	//return null;
    }


    /**
     * Given the input file, read it and generate the freq table
     * @param inputFile
     * @return
     */
    
	public Map<String, PriorityQueue<AirportPair>> generateMap(String inputFile) {

    	FlightFreqParser parserOp = new FlightFreqParser();
    	//String inputFile= "files/flightFreqTable/out.csv";
    	TreeMap<String, TreeMap<String, AirportPair>> freqMap = new TreeMap<>();
    	try {
			
    		freqMap = parserOp.fileReader(inputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//System.out.println("freq map key set " +freqMap.keySet());
    	//System.out.println("tree map size "+freqMap.keySet().size());
    	/*
    	 * for each key in the tree map add the destination in
    	 * priority queue order in freqTable Map<air, pq>
    	 */
    	for (String it : freqMap.keySet()) {
			// get the list of airport pairs for the freq map key
    		TreeMap<String, AirportPair> ap = freqMap.get(it);
    		PriorityQueue<AirportPair> pq = new PriorityQueue<AirportPair>((AirportPair a, AirportPair b) -> {
    			return 0 - (a.getFrequency() - b.getFrequency());
    		});
    			for (String in : ap.keySet()) {
    				// add the airport list to the priority queue
    				pq.add(ap.get(in));
    			
    			}

    			// add the start airport and pq to the map freqTable	
    			freqTable.put(it, pq);
    	}
    	// done generating the freq table map
    	
    	//System.out.println("map keys "+freqTable.keySet());
    	//System.out.println("map keys size "+freqTable.keySet().size());
    	//System.out.println("generated start map size "+freqMap.size());
        return freqTable;
        	
    }

    /**
     * get the freq table
     * @return freq table
     */
    public Map<String, PriorityQueue<AirportPair>> getFreqTable() {
    	//String inputFile= "files/flightFreqTable/out.csv";
    	
    	//freqTable = generateMap(inputFile);
    	//setFreqTable(freqTable);
    	return freqTable;
    	//return null;
    }

    /**
     * set freq table
     * @param freqTable
     */
    public void setFreqTable(Map<String, PriorityQueue<AirportPair>> freqTable) {
        this.freqTable = freqTable;
    }
}