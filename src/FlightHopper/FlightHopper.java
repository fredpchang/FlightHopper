package FlightHopper;

import java.util.*;

public class FlightHopper {
    public int queryType;
    List<Airport> airports = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Flight Hopper!");
        Scanner scanner = new Scanner(System.in);
        FlightHopper flightHopper = new FlightHopper();
        IFlightTicketService twoCity = new DirectAnalyzer();
        IFlightTicketService mulCity = new MulticityAnalyzer();
        while(1==1) {
            System.out.println("1. I want to find flights between two cities!");
            System.out.println("2. I want to generate an itinerary for multiple cities");
            System.out.println("Please enter the number of function you want to use");
            int query = scanner.nextInt();
            scanner.nextLine();
            if(query != 1 && query != 2) {
                System.out.println("Please enter number 1 or 2");
                continue;
            }
            flightHopper.queryType = query;
            // two city
            if(flightHopper.queryType == 1) {
                List<String> userInput = new ArrayList<>();
//                String input;
                System.out.println("Welcome to direct ticket search engine!");
                System.out.println("Please enter the start airport");
                userInput.add(scanner.nextLine());
                System.out.println("Please enter the end airport");
                userInput.add(scanner.nextLine());
                System.out.println("Please enter the day you want to travel, format is xx/xx/20xx");
                userInput.add(scanner.nextLine());
                System.out.println("Please enter the flexibility of the flight, if none enter 0");
                userInput.add(scanner.nextLine());
                System.out.println("Please enter max price, if none enter -1");
                userInput.add(scanner.nextLine());
                System.out.println("Please enter max flight duration in int hours, if none enter -1");
                userInput.add(scanner.nextLine());
                System.out.println(userInput);
                // TO DO
            }
            // multiple cities
            else {
                List<String> userInput = new ArrayList<>();
                System.out.println("Welcome to multi city itinerary generator");
                System.out.println("Please enter the day you want to start you trip, format is xx/xx/20xx");
                userInput.add(scanner.nextLine());
                System.out.println("Please enter the start airport");
                userInput.add(scanner.nextLine());
                System.out.println("Please enter the flexibility of the flight, if none enter 0");
                userInput.add(scanner.nextLine());
                //                boolean finish = false;
                while (true) {
                    System.out.println("Please enter the airport you want to arrive");
                    userInput.add(scanner.nextLine());
                    System.out.println("Is this your final destination, Y/N");
                    String yn = scanner.nextLine();
                    if(yn.equals("Y")) {
                        break;
                    }
                    System.out.println("Please enter how many days you want to stay here");
                    userInput.add(scanner.nextLine());
                }
                System.out.println(userInput);
            }
        }
    }
}
