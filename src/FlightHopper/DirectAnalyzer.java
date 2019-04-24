package FlightHopper;

import java.util.*;

public class DirectAnalyzer implements IFlightTicketService {
    TripLinkedList tripLinkedList;
    List<List<IFlight>> routesSelctions;
    FlightScraper scraper;
    List<String> userInput;

    public DirectAnalyzer() {
        tripLinkedList = new TripLinkedList();
        routesSelctions = new ArrayList<>();
        scraper = new FlightScraper();
        userInput = new ArrayList<>();
    }
    
    public DirectAnalyzer(List<String> userInput) {
        this.userInput = userInput;
        tripLinkedList = generateList(this.userInput);
    }

    /***
     * The overall function, given the user input and give you
     * the overall List of tickets to choose from
     * @param userInput include cities user want to visit. In this class we only allow two,
     *                  and also could have searching condition like max price and flight
     *                  duration
     * @return the collection of ticket that satisfy the condition
     */
    public List<IFlight> getOptimalRoutesOfTwoCities(List<String> userInput) {
        return null;
    }

    /***
     * given the user input which include like which city they want
     * to visit and how long they stay, return the tripLinkedList.
     * TripLinkedList is like a graph to store the source
     * data.
     * @param userInput
     * @return
     */
    @Override
    public TripLinkedList generateList(List<String> userInput) {
        return null;
    }
    /***
     * Given the user input, and also have the priceWeight which indicate
     * how to measure the ticket rank.
     * Get the itinerary base on user input and also the way we
     * measure the rank
     * @param userInput include list of cities user want to go and how long they stay
     * @param priceWeight how much price would contribute to rank of the ticket
     * @return
     */
    @Override
    public List<IFlight> getRoute(List<String> userInput, double priceWeight) {
        return null;
    }
    /***
     * Run scarper using start, end and date, to get the json file
     * and then parse into a list of tickets
     * @param startAirport start airport
     * @param endAirport end airport
     * @param date the date on these flight
     * @return
     */
    @Override
    public List<IFlight> getTickets(String startAirport, String endAirport, String date) {
        return null;
    }

    /***
     * get list of tickets, but allow some filter condition
     * @param startAirport
     * @param endAirport
     * @param date
     * @param flexibility how many flexibility day does user allow
     * @param maxPrice the max price user could allow
     * @param maxFlightTime the max flight time user want to take
     * @return
     */
    private List<IFlight> getTickets(String startAirport, String endAirport, String date,
                                     String flexibility, int maxPrice, int maxFlightTime) {
        return null;
    }

    /***
     * check if a ticket satisfy the filter condition
     * @param f
     * @param maxFlightTime max flight time
     * @param price max price
     * @return return true if satisfy both, return false otherwise
     */
    private boolean checkValid(IFlight f, int maxFlightTime, int price) {
        return false;
    }
}
