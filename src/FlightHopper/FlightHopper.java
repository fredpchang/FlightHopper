package FlightHopper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class FlightHopper {
    public int queryType;
//    List<Airport> airports = new ArrayList<>();

//    Map<String, Airport> airports = new HashMap<>();

    public static void main(String[] args) {
    	FlightScraper fs = new FlightScraper();

        System.out.println("Welcome to Flight Hopper!");
        Scanner scanner = new Scanner(System.in);
        FlightHopper flightHopper = new FlightHopper();
        IFlightTicketService twoCity = new DirectAnalyzer();
        IFlightTicketService mulCity = new MulticityAnalyzer();
        FlightFreqTable freqTable = new FlightFreqTable();
        System.out.println("Loading...");
        freqTable.generateMap("files/flightFreqTable/out.csv");
        System.out.println("Auto-Recommendation System Ready!");
        while(1==1) {
            System.out.print("Press (1) for Direct Flight (2) for Multicity \n");
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
                System.out.println("Please enter the start airport (e.g. PHL)");
                String input = scanner.nextLine();
                userInput.add(input);
                
                //Print out list of top recommendations
                System.out.printf("Here are some popular destinations from [%s]: \n", userInput);
                List<AirportPair> top = freqTable.getTop(input);
                for (AirportPair a : top) {
                	System.out.println(a.getEndAirport());
                }
                
                System.out.println("Please enter the end airport (e.g. LAX)");
                userInput.add(scanner.nextLine());
                System.out.println("Please enter the day you want to travel, format is mm/dd/20yy");
                userInput.add(scanner.nextLine());
                System.out.println("Please enter the flexibility of the flight (days), if none enter 0");
                userInput.add(scanner.nextLine());
                System.out.println("Please enter max price ($), if none enter -1");
                userInput.add(scanner.nextLine());
                System.out.println("Please enter max flight duration (hours), if none enter -1");
                userInput.add(scanner.nextLine());
                System.out.println(userInput);
                DirectAnalyzer da = new DirectAnalyzer();
                System.out.println("Here are the top offers we found:");
//                System.out.println(da.getOptimalRoutesOfTwoCities(userInput));
                List<IFlight> ls = da.getOptimalRoutesOfTwoCities(userInput);
                for(IFlight f : ls) {
                	System.out.println("------------------------------");
                	f.printFlight();
                	System.out.println();
				}

                System.out.println("Press q quit program, press any other key to return to main menu");
                String choice = scanner.nextLine();
                if(choice.equals("q")) break;
                else {
                    continue;
                }
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
//                System.out.println(userInput);
                MulticityAnalyzer ma = new MulticityAnalyzer();
                System.out.println("Here are top itineraries we generated for you:");
				List<List<IFlight>> ls = ma.getOptimalRoutesOfMultiCities(userInput);
				for(List<IFlight> f : ls) {
					System.out.println("---------------");
					for(IFlight f1 : f ) {
						f1.printFlight();
					}
					System.out.println("---------------");

				}
                System.out.println("Press q quit program, press any other key to return to main menu");
                String choice = scanner.nextLine();
                if(choice.equals("q")) break;
                else {
                    continue;
                }
            }
        }
        System.out.println("Thanks for using FlightHopper.");
        scanner.close();

//		MulticityAnalyzer ma = new MulticityAnalyzer();
//		List<String> userInput = new ArrayList<>();
//		userInput.add("06/01/2019");
//		userInput.add("phl");
//		userInput.add("0");
//		userInput.add("sfo");
//		userInput.add("2");
////		userInput.add("tpe");
////		userInput.add("5");
//		userInput.add("lax");
//		System.out.println(ma.getOptimalRoutesOfMultiCities(userInput));

    }
}
