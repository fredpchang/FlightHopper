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

    public List<List<IFlight>> getOptimalRoutesOfMultiCities(List<String> userInput) {
        return null;
    }
    @Override
    public TripLinkedList generateList(List<String> userInput) {
        return null;
    }

    @Override
    public List<IFlight> getRoutes(List<String> userInput, double priceWeight) {
        return null;
    }

    @Override
    public List<IFlight> getTickets(String startAirport, String endAirport, String date) {
        return null;
    }

}
