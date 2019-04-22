package FlightHopper;

import java.util.*;

public interface IFlightTicketService {


    TripLinkedList generateList(List<String> userInput);
    List<IFlight> getRoutes(List<String> userInput, double priceWeight);
    List<IFlight> getTickets(String startAirport, String endAirport, String date);

}
