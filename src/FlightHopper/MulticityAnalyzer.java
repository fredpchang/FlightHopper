package FlightHopper;

import com.sun.deploy.util.StringUtils;

import java.text.SimpleDateFormat;
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
        userInput = new ArrayList<>();
    }


//    MulticityAnalyzer(List<String> userInput) {
//        tripLinkedList = generateList(userInput);
//    }
    /***
     * Overall function. Given user input generate a list
     * of possible itineraries
     * @param userInput include multiple cities and how long they
     *                  want to stay
     */
    public List<List<IFlight>> getOptimalRoutesOfMultiCities(List<String> userInput) {
        generateList(userInput);
        double weight = 0;
        for(int i = 0 ; i <4; i++) {
            List<IFlight> temp = this.getRoute(userInput, weight);
            routesSelctions.add(new ArrayList<>(temp));
            weight += 0.25;
        }
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
        if(userInput.size() % 2==0) return null;

        String[] dateData = userInput.get(0).split("/");
        if(dateData.length != 3) return null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar date = new GregorianCalendar(Integer.valueOf(dateData[2]),Integer.valueOf(dateData[1])-1,
                Integer.valueOf(dateData[0]));
//        date.setTime(new Date()); // Now use today date.
//        String startAirport = userInput.get(1);
        int flex = Integer.valueOf(userInput.get(2));
        this.tripLinkedList.add(userInput.get(1));
        //deal with start node
        List<IFlight> temp = new ArrayList<>();
        for(int i = 0; i <= flex; i++) {
            date.add(Calendar.DATE, i);
            temp.addAll(this.getTickets(userInput.get(1),
                    userInput.get(3), sdf.format(date.getTime())));
            date.add(Calendar.DATE, -i);
        }
        tripLinkedList.getRoot().setTickets(new ArrayList<>(temp));
//        date.add(Calendar.DATE, 0-flex);
        for(int i = 3; i < userInput.size()-1; i+=2) {
            List<IFlight> t = new ArrayList<>();
            this.tripLinkedList.add(userInput.get(i));
            //0 flex date
            date.add(Calendar.DATE, Integer.valueOf(userInput.get(i+1)));
            for(int j = 0; j <= flex; j++) {
                //add flex
                date.add(Calendar.DATE, j);
                // get tickets and add to t
                t.addAll(this.getTickets(userInput.get(i),
                        userInput.get(i+2), sdf.format(date.getTime())));
                //subtract flex
                date.add(Calendar.DATE, -j);
            }
            // put all tickets in target node
            this.tripLinkedList.get((i-1)/2).setTickets(
                    new ArrayList<>(t)
            );
        }
        this.tripLinkedList.add(userInput.get(userInput.size()-1));
//        // how to add date
//        date.add(Calendar.DATE, 5);
//        String output = sdf.format(date.getTime());
////        System.out.println(output);
        return tripLinkedList;
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
        Airport cur = this.tripLinkedList.getRoot();
        List<IFlight> re = new ArrayList<>();
        while(cur.destination != null) {
            // sort in ascending by price weight
            PriorityQueue<IFlight> pq = new PriorityQueue<>((IFlight a, IFlight b) -> {
                return a.getFlightRank(priceWeight) - b.getFlightRank(priceWeight);
            });
            // add all ticket into pq and sort
            pq.addAll(cur.getTickets());
            // get the top 5 tickets
            for(int i = 0; i < pq.size() && i < 5; i++) {
                re.add(pq.poll());
            }
            // add those back to pq so that we don't poll tickets out and lose that entirely
            pq.addAll(re);
            cur = cur.getDestination();
        }
        return re;
    }
    /***
     * Run scraper using start, end and date, to get the json file
     * and then parse into a list of tickets
     * @param startAirport start airport
     * @param endAirport end airport
     * @param date the date on these flight
     * @return
     */
    @Override
    public List<IFlight> getTickets(String startAirport, String endAirport, String date) {
        return this.scraper.runScraper(startAirport, endAirport, date, 0);
    }

}
