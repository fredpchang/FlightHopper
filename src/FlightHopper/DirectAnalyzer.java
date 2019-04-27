package FlightHopper;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

public class DirectAnalyzer implements IFlightTicketService {
    TripLinkedList tripLinkedList;
    List<IFlight> routesSelctions;
    FlightScraper scraper;
    List<String> userInput;


    /**
     * default constructor, init some fields
     */
    public DirectAnalyzer() {
        tripLinkedList = new TripLinkedList();
        routesSelctions = new ArrayList<>();
        scraper = new FlightScraper();
        userInput = new ArrayList<>();
    }


    /**
     * take in userinput and set that to be userInput fields
     * and also init some other fields
     * @param userInput list of user input
     */
    public DirectAnalyzer(List<String> userInput) {
        this.userInput = userInput;
        tripLinkedList = generateList(this.userInput);
        routesSelctions = new ArrayList<>();
        scraper = new FlightScraper();
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
        Set<IFlight> re = new HashSet<IFlight>();
        double priceWeight = 0;
        for(int i = 0; i < 4; i++) {
            re.addAll(this.getRoute(userInput, priceWeight));
            priceWeight += 0.25;
        }
        this.routesSelctions.addAll(re);
        return routesSelctions;
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
        String startAirport = userInput.get(0), endAirport = userInput.get(1),
                date = userInput.get(2), flexibility = userInput.get(3);
        int maxPrice = Integer.valueOf(userInput.get(4))
                , maxDuration = Integer.valueOf(userInput.get(5));
        if(maxPrice == -1) maxPrice = Integer.MAX_VALUE;
        if(maxDuration == -1) maxDuration = Integer.MAX_VALUE;
        int flex = Integer.valueOf(flexibility);
        Set<IFlight> re = new HashSet<IFlight>();
        double priceWeight = 0;
        for(int i = 0; i < 4; i++) {
            re.addAll(this.getRoute(userInput, priceWeight));
            priceWeight += 0.25;
        }
        //TODO finish this graph, even though it's trivial

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
        String startAirport = userInput.get(0), endAirport = userInput.get(1),
                date = userInput.get(2), flexibility = userInput.get(3);
        int maxPrice = Integer.valueOf(userInput.get(4))
                , maxDuration = Integer.valueOf(userInput.get(5));
        if(maxPrice == -1) maxPrice = Integer.MAX_VALUE;
        if(maxDuration == -1) maxDuration = Integer.MAX_VALUE;
        int flex = Integer.valueOf(flexibility);

        List<IFlight> tickets = this.getTickets(startAirport, endAirport, date, flexibility,
                maxPrice, maxDuration);
        tickets.sort((IFlight a, IFlight b) -> {
            return a.getFlightRank(priceWeight) - b.getFlightRank(priceWeight);
        });
        List<IFlight> result = new ArrayList<IFlight>();
        for(int i = 0; i < 5; i++) {
            result.add(tickets.get(i));
        }
        return result;
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

        try {
            return this.scraper.runScraper(startAirport, endAirport, date, 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
        int flex = Integer.valueOf(flexibility);
        List<IFlight> rawData = this.getTickets(startAirport, endAirport, date);
        List<IFlight> filtered = this.scraper.paramFilter(maxPrice, maxFlightTime, rawData);
        return filtered;
    }

    /***
     * check if a ticket satisfy the filter condition
     * @param f
     * @param maxFlightTime max flight time
     * @param price max price
     * @return return true if satisfy both, return false otherwise
     */
    private boolean checkValid(IFlight f, int maxFlightTime, int price) {
        if(f.isDirect()) {
            DirectFlight df = (DirectFlight) f;
            return df.getDuration() <= maxFlightTime && df.getPrice() <= price;
        }
        else {
            NonDirectFlight ndf = (NonDirectFlight) f;
            return ndf.getDuration() <= maxFlightTime && ndf.getPrice() <= price;
        }
    }

    public List<String> getUserInput() {
        return userInput;
    }

    public void setUserInput(List<String> userInput) {
        this.userInput = userInput;
    }
}
