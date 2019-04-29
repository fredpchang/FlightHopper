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
        List<IFlight> re = new ArrayList<IFlight>();
        double priceWeight = 1;
        for(int i = 0; i < 4; i++) {
            List<IFlight> temp = this.getRoute(userInput, priceWeight);
            // only care about top 3
            int j = 0;
            for(IFlight f : temp) {
                if(j>=3) break;
                if(!re.contains(f)) {
                    re.add(f);
                    j++;
                }
            }

            priceWeight -= 0.25;
        }
        this.routesSelctions = new ArrayList<>();
        this.routesSelctions.addAll(re);
//        Collections.sort(re,(IFlight a, IFlight b) -> {
//            a.getFlightRank()
//        });
        return routesSelctions;
    }

    /***
     * given the user input which include like which city they want
     * to visit and how long they stay, return the tripLinkedList.
     * TripLinkedList is like a graph to store the source
     * data.
     * @param userInput the user input from main method which conclude the query condition
     * @return the trip linked list for this flight route
     */
    @Override
    public TripLinkedList generateList(List<String> userInput) {
        if(userInput.size()==0 || userInput.size() != 6) return null;
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
     * @return the list of tickets for this route
     */
    @Override
    public List<IFlight> getRoute(List<String> userInput, double priceWeight) {
        if(priceWeight<0 || priceWeight>1) return null;
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
//        List<IFlight> result = new ArrayList<IFlight>();
//        for(int i = 0; i < 5; i++) {
//            result.add(tickets.get(i));
//        }
        return tickets;
    }
    /***
     * Run scarper using start, end and date, to get the json file
     * and then parse into a list of tickets
     * @param startAirport start airport
     * @param endAirport end airport
     * @param date the date on these flight
     * @return the list of ticket from this start to end on that particular date
     */
    @Override
    public List<IFlight> getTickets(String startAirport, String endAirport, String date) {


        return this.scraper.runScraper(startAirport, endAirport, date, 0);

    }

    /***
     * get list of tickets, but allow some filter condition
     * @param startAirport name of start airport
     * @param endAirport name of end airport
     * @param date the date of flights
     * @param flexibility how many flexibility day does user allow
     * @param maxPrice the max price user could allow
     * @param maxFlightTime the max flight time user want to take
     * @return the list of flights that satisfies all these conditions takes in
     */
    private List<IFlight> getTickets(String startAirport, String endAirport, String date,
                                     String flexibility, int maxPrice, int maxFlightTime) {

        int flex = Integer.valueOf(flexibility);
        List<IFlight> rawData = this.scraper.runScraper(startAirport,endAirport, date,flex);
        List<IFlight> filtered = this.scraper.paramFilter(maxPrice, maxFlightTime, rawData);
        return filtered;


    }

    /***
     * check if a ticket satisfy the filter condition
     * @param f the ticket to compare with
     * @param maxFlightTime max flight time
     * @param price max price
     * @return return true if satisfy both, return false otherwise
     */
    public boolean checkValid(IFlight f, int maxFlightTime, int price) {
        if(f.isDirect()) {
            DirectFlight df = (DirectFlight) f;
            return df.getDuration() <= maxFlightTime && df.getPrice() <= price;
        }
        else {
            NonDirectFlight ndf = (NonDirectFlight) f;
            return ndf.getDuration() <= maxFlightTime && ndf.getPrice() <= price;
        }
    }

    /**
     * get the user input
     * @return user input list
     */
    public List<String> getUserInput() {
        return userInput;
    }

    /**
     * set the user input
     * @param userInput user input
     */
    public void setUserInput(List<String> userInput) {
        this.userInput = userInput;
    }
}
