package FlightHopper;
import java.util.*;
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
     */
    public List<IFlight> runScraper(String startAirport, String endAirport, String date, int flex) {
        return null;
    }

    /**
     * Run the scraper on one single day
     * @param startAirport
     * @param endAirport
     * @param date
     * @return
     */
    private List<IFlight> scraperPyHelper(String startAirport, String endAirport, String date) {
        return null;
    }

    /**
     * Given the filename, parse the json file into
     * a list of flights
     * @param fileName
     * @return
     */
    private List <IFlight> jsonParser(String fileName) {
        return null;
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
        return null;
    }

    public Map<IFlight, List<IFlight>> getCache() {
        return cache;
    }

    public void setCache(Map<IFlight, List<IFlight>> cache) {
        this.cache = cache;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }
}
