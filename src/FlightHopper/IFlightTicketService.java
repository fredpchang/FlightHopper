package FlightHopper;

import java.util.*;

public interface IFlightTicketService {

    /***
     * given the user input which include like which city they want
     * to visit and how long they stay, return the tripLinkedList.
     * TripLinkedList is like a graph to store the source
     * data.
     * @param userInput
     * @return
     */
    TripLinkedList generateList(List<String> userInput);

    /***
     * Given the user input, and also have the priceWeight which indicate
     * how to measure the ticket rank.
     * Get the itinerary base on user input and also the way we
     * measure the rank
     * @param userInput include list of cities user want to go and how long they stay
     * @param priceWeight how much price would contribute to rank of the ticket
     * @return
     */
    List<IFlight> getRoute(List<String> userInput, double priceWeight);

    /***
     * Run scarper using start, end and date, to get the json file
     * and then parse into a list of tickets
     * @param startAirport start airport
     * @param endAirport end airport
     * @param date the date on these flight
     * @return
     */
    List<IFlight> getTickets(String startAirport, String endAirport, String date);

}
