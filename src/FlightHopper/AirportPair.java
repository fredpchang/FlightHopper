package FlightHopper;

public class AirportPair {
    private String startAirport;
    private String endAirport;
    private int frequency;

    /**
     * Default constructor: initialize some fields
     */
    public AirportPair() {
    	startAirport = null;
    	frequency = -1;
    }
    /**
     * get start airport
     * @return start airport
     */
    public String getStartAirport() {
        return startAirport;
    }

    /**
     * set start airport
     * @param startAirport the name of start airport
     */
    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    /**
     * get end airport
     * @return end airport
     */
    public String getEndAirport() {
        return endAirport;
    }

    /**
     * set end airport
     * @param endAirport name of the end/destination airport
     */
    public void setEndAirport(String endAirport) {
        this.endAirport = endAirport;
    }

    /**
     * get how the frequency number for that flight route
     * @return frequency number
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * set frequency number
     * @param frequency the frequency number
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
