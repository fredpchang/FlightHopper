package FlightHopper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;


public class FlightHopper {
    public int queryType;
//    List<Airport> airports = new ArrayList<>();

//    Map<String, Airport> airports = new HashMap<>();

    public static void main(String[] args) {


        System.out.println("Welcome to Flight Hopper!");
        Scanner scanner = new Scanner(System.in);
        FlightHopper flightHopper = new FlightHopper();
        System.out.println("Loading...");
        FlightFreqTable freqTable = new FlightFreqTable();
        System.out.println("Auto-Recommendation System Ready!");
        while(1==1) {
            System.out.print("Press (1) for Direct Flight (2) for Multicity \n");
            int query = scanner.nextInt();
            scanner.nextLine();
            while(query != 1 && query != 2) {
                System.out.println("Please enter number 1 or 2");
                query = scanner.nextInt();
                scanner.nextLine();
                continue;
            }
            flightHopper.queryType = query;
            // two city
            if(flightHopper.queryType == 1) {
                List<String> userInput = new ArrayList<>();
//                String input;
                System.out.println("Welcome to direct ticket search engine!");
                System.out.println("Please enter the start airport (e.g. PHL)");
                String input = scanner.nextLine().toUpperCase();
                userInput.add(input);

                //Print out list of top recommendations
                System.out.printf("Here are some popular destinations from [%s]: \n", input);
                List<AirportPair> top = freqTable.getTop(input);
                for (AirportPair a : top) {
                    System.out.println(a.getEndAirport());
                }

                System.out.println("Please enter the end airport (e.g. LAX)");
                userInput.add(scanner.nextLine().toUpperCase());
                System.out.println("Please enter the day you want to travel, format is mm/dd/20yy");
                String date = scanner.nextLine();
                while(!Pattern.compile("^(0[1-9]|1[012])[/](0[1-9]|[12][0-9]|3[01])[/](20)\\d\\d$")
                .matcher(date).find()) {
                    System.out.println("Invalid date: please enter a date in format : mm/dd/20yy");
                    date = scanner.nextLine();
                }
                userInput.add(date);
//                userInput.add(scanner.nextLine());
                System.out.println("Please enter the flexibility of the flight (days), if none enter 0");
                String digit = scanner.nextLine();
//                System.out.println(Pattern.compile("\\d+").matcher(digit).find());
                while(!Pattern.compile("^[0-9]*$").matcher(digit).find()) {
                    System.out.println("Invalid input: please enter a number");
                    digit = scanner.nextLine();
                }
                userInput.add(digit);
                digit = "a";
                System.out.println("Please enter max price ($), if none enter -1");
                digit = scanner.nextLine();
//                System.out.println(Pattern.compile("\\d+").matcher(digit).find());
                while(!Pattern.compile("^-?[0-9]*$").matcher(digit).find()) {
                    System.out.println("Invalid input: please enter a number");
                    digit = scanner.nextLine();
                }
                userInput.add(digit);
                digit = "a";
                System.out.println("Please enter max flight duration (hours), if none enter -1");
                digit = scanner.nextLine();
//                System.out.println(Pattern.compile("\\d+").matcher(digit).find());
                while(!Pattern.compile("^-?[0-9]*$").matcher(digit).find()) {
                    System.out.println("Invalid input: please enter a number");
                    digit = scanner.nextLine();
                }
                userInput.add(digit);
                digit = "a";
                System.out.println(userInput);
                DirectAnalyzer da = new DirectAnalyzer();
//                System.out.println(da.getOptimalRoutesOfTwoCities(userInput));
                List<IFlight> ls = da.getOptimalRoutesOfTwoCities(userInput);
                if(ls.size() == 0) {
        			System.out.println("Invalid flight search. Please try another query.");
                	continue;
                }
                else {
                	System.out.println("\n\n\n");
                    System.out.println("Here are the top offers we found:");
                }
                
                int counter = 0;
                for(IFlight f : ls) {
                    
                    if (counter == 0) {
                        System.out.println("==================================== ITINERARY (CHEAPEST) ====================================");
                    }
                    else if (counter == 1) {
                        System.out.println("==================================== ITINERARY (SHORTEST) ====================================");
                    }
                    else {
                        System.out.println("------------------------------ ITINERARY ------------------------------");
                    }

                    f.printFlight();
                    System.out.println();
                    
                    if (counter == 1) {
                        System.out.println("==================================== OTHER RECOMMENDATIONS ====================================");
                    }
                    
                    counter++;

                }

                System.out.println("Press q quit program, press any other key to return to main menu");
                String choice = scanner.nextLine().toUpperCase();
                if(choice.equals("Q")) break;
                else {
                    continue;
                }
            }
            // multiple cities
            else {
                List<String> userInput = new ArrayList<>();
                int cityNum = 0;
                System.out.println("Welcome to multi city itinerary generator");
                System.out.println("Please enter the day you want to start you trip, format is xx/xx/20xx");
                String date = scanner.nextLine();
                String regex = "^(0[1-9]|1[012])[/](0[1-9]|[12][0-9]|3[01])[/](20)\\d\\d$";
                while(!Pattern.compile(regex).matcher(date).find()) {
                    System.out.println(date);
                    System.out.println("Invalid date: please enter a date in format : mm/dd/20yy");
                    date = scanner.nextLine();
                }
                userInput.add(date);
                System.out.println("Please enter the start airport");
                String airport = scanner.nextLine().toUpperCase();
                userInput.add(airport);
                cityNum++;
                System.out.println("Please enter the flexibility of the flight, if none enter 0");
                String digit = scanner.nextLine();
//                System.out.println(Pattern.compile("\\d+").matcher(digit).find());
                while(!Pattern.compile("^[0-9]*$").matcher(digit).find()) {
                    System.out.println("Invalid input: please enter a number");
                    digit = scanner.nextLine();
                }
                userInput.add(digit);
                digit = "a";
                while (true) {
                    System.out.printf("Here are some popular destinations from [%s]: \n", airport);
                    List<AirportPair> top = freqTable.getTop(airport);
                    for (AirportPair a : top) {
                        System.out.println(a.getEndAirport());
                    }
                    System.out.println("Please enter the airport you want to arrive");
                    airport = scanner.nextLine().toUpperCase();
                    userInput.add(airport);
                    cityNum++;
                    System.out.println("Is this your final destination, Y/N");
                    String yn = scanner.nextLine().toUpperCase();
                    if(yn.equals("Y")) {
                        break;
                    }
                    System.out.println("Please enter how many days you want to stay here");
                    digit = scanner.nextLine();
//                System.out.println(Pattern.compile("\\d+").matcher(digit).find());
                    while(!Pattern.compile("^[0-9]*$").matcher(digit).find()) {
                        System.out.println("Invalid input: please enter a number");
                        digit = scanner.nextLine();
                    }
                    userInput.add(digit);
                    digit = "a";
                }
//                System.out.println(userInput);
                MulticityAnalyzer ma = new MulticityAnalyzer();
                List<List<IFlight>> ls = ma.getOptimalRoutesOfMultiCities(userInput);
                if(ls.size() == 0) {
        			System.out.println("Invalid flight search. Please try another query.");
                	continue;
                }
                if(ls.get(0).size() != cityNum - 1) {
        			System.out.println("Invalid flight search. Please try another query.");
                	continue;
                }
                System.out.println("\n\n\n");
                System.out.println("Here are top itineraries we generated for you:");
                
                int counter = 0;
                for(List<IFlight> f : ls) {
                    
                    if (counter == 0) {
                        System.out.println("==================================== ITINERARY (CHEAPEST) ====================================");
                    }
                    else if (counter == 1) {
                        System.out.println("==================================== ITINERARY (SHORTEST) ====================================");
                    }
                    else {
                        System.out.println("------------------------------ ITINERARY ------------------------------");
                    }
                    double price = 0;
                    int hour = 0;
                    for(IFlight f1 : f ) {
                        if(f1 instanceof DirectFlight) {
                        	price += ((DirectFlight) f1).getPrice();
                        	hour += ((DirectFlight) f1).getDuration();
                        }
                        else {
                        	price += ((NonDirectFlight) f1).getPrice();
                        	hour += ((NonDirectFlight) f1).getDuration();
                        }
                    }
                    
                    System.out.println("$" + price + " (" + hour + "hrs)");
                    for(IFlight f1 : f ) {
                    	f1.printFlight();
                    }
                    
                    if (counter == 1) {
                        System.out.println("==================================== OTHER RECOMMENDATIONS ====================================");
                    }
                    
                    counter++;

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
