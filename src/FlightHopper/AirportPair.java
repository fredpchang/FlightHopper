package FlightHopper;

public class AirportPair {
    private String startAirport;
    private String endAirport;
    private int frequency;

    /**
     * get start airport
     * @return start airport
     */
    public String getStartAirport() {
        return startAirport;
    }

    /**
     * set start airport
     * @param startAirport
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
     * @param endAirport
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
     * @param frequency
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
