package FlightHopper;
import java.util.*;
public class FlightFreqTable {
    private Map<String, PriorityQueue<AirportPair>> freqTable;


    /**
     * get top several destinations from start airport
     * @param startAirport
     * @return
     */
    public List<AirportPair> getTop(String startAirport) {
        return null;
    }


    /**
     * Given the input file, read it and generate the freq table
     * @param inputFile
     * @return
     */
    private Map<String, PriorityQueue<AirportPair>> generateMap(String inputFile) {
        return null;
    }

    /**
     * get the freq table
     * @return freq table
     */
    public Map<String, PriorityQueue<AirportPair>> getFreqTable() {
        return freqTable;
    }

    /**
     * set freq table
     * @param freqTable
     */
    public void setFreqTable(Map<String, PriorityQueue<AirportPair>> freqTable) {
        this.freqTable = freqTable;
    }
}
