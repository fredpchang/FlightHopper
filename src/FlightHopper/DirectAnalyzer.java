package FlightHopper;

import java.util.*;

public class DirectAnalyzer implements IFlightTicketService {
    TripLinkedList tripLinkedList;
    List<List<IFlight>> routesSelctions;
    FlightScraper scraper;
    List<String> userInput;

    DirectAnalyzer() {
        tripLinkedList = new TripLinkedList();
        routesSelctions = new ArrayList<>();
        scraper = new FlightScraper();
        userInput = new ArrayList<>();
    }
    DirectAnalyzer(List<String> userInput) {
        this.userInput = userInput;
        tripLinkedList = generateList(this.userInput);
    }

    public List<IFlight> getOptimalRoutesOfTwoCities(List<String> userInput) {
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

    private List<IFlight> getTickets(String startAirport, String endAirport, String date,
                                     String flexibility, int maxPrice, int maxFlightTime) {
        return null;
    }

    private boolean checkValid(IFlight f, int maxFlightTime, int price) {
        return false;
    }
}
