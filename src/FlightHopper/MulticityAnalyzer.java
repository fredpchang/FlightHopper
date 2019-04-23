package FlightHopper;

import java.util.*;

public class MulticityAnalyzer implements IFlightTicketService {

    TripLinkedList tripLinkedList;
    List<List<IFlight>> routesSelctions;
    FlightScraper scraper;
    List<String> userInput;
    MulticityAnalyzer() {
        tripLinkedList = new TripLinkedList();
        routesSelctions = new ArrayList<>();
        scraper = new FlightScraper();

    }


    MulticityAnalyzer(List<String> userInput) {
        tripLinkedList = generateList(userInput);
    }
    /***
     * Overall function. Given user input generate a list
     * of possible itineraries
     * @param userInput include multiple cities and how long they
     *                  want to stay
     */
    public List<List<IFlight>> getOptimalRoutesOfMultiCities(List<String> userInput) {
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



}
