package FlightHopper;

import java.util.ArrayList;
import java.util.List;

public class NonDirectFlight implements IFlight {

	String startAirport;
	String endAirport;
	double price;
	int stops;
	ArrayList<String> routing; //formatted form for printing
	String startTime; //format: yyyymmdd
	String endTime; //format: yyyymmdd
	String flightDuration; //string form for printing
	int duration;
	int rank;
	boolean isDirect;
	String airline;
	String plane;

	/**
	 * default constructor
	 */
	public NonDirectFlight() {

	}

	/**
	 * constructor: initialized with some of these fields
	 * @param startAirport name of start airport
	 * @param endAirport name of end airport
	 * @param price ticket price
	 * @param stops number of stops
	 * @param routing list of routes string
	 * @param startTime start time string
	 * @param endTime end time string
	 * @param flightDuration flight duration string
	 * @param duration flight duration in integer
	 * @param rank flight rank
	 * @param isDirect whether this is direct flight
	 * @param airline name of the airline
	 * @param plane plane type
	 */
	public NonDirectFlight(String startAirport,
						   String endAirport,
						   double price,
						   int stops,
						   ArrayList<String> routing,
						   String startTime,
						   String endTime,
						   String flightDuration,
						   int duration,
						   int rank,
						   boolean isDirect,
						   String airline,
						   String plane
	) {

		this.startAirport = startAirport;
		this.endAirport = endAirport;
		this.price = price;
		this.stops = stops;
		this.routing = routing;
		this.startTime = startTime;
		this.endTime = endTime;
		this.flightDuration = flightDuration;
		this.duration = duration;
		this.rank = rank;
		this.isDirect = isDirect;
		this.airline = airline;
		this.plane = plane;
	}

	/**
	 * print method for flight
	 */
	@Override
	public void printFlight(){

		System.out.printf("[%s] -----%shrs----> [%s] $%s \n", this.getStartAirport(), this.getDuration(), this.getEndAirport(), this.price);
		String year = this.getStartTime().substring(0, 4);
		String month = this.getStartTime().substring(4, 6);
		String day = this.getStartTime().substring(6, 8);
		System.out.println(year + "/" + month + "/" + day);
		System.out.println(this.stops + " stops");
		System.out.println(this.getAirline() + " " + this.getPlane());
		for (String i : this.getRouting()) {
			System.out.println(i);
		}
		System.out.println();
	}

	/**
	 * get the start airport
	 * @return start airport
	 */
	public String getStartAirport() {
		return startAirport;
	}

	/**
	 * set start airport
	 * @param startAirport name of start airport
	 */
	public void setStartAirport(String startAirport) {
		this.startAirport = startAirport;
	}

	/**
	 * get end airport
	 * @return end airport
	 */
	public String getEndAirport() {
		return endAirport;
	}

	/**
	 * set end airport
	 * @param endAirport end airport name
	 */
	public void setEndAirport(String endAirport) {
		this.endAirport = endAirport;
	}

	/**
	 * get ticket price
	 * @return ticket price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * set ticket price
	 * @param price ticket price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * get how many stops there are
	 * @return how many stops
	 */
	public int getStops() {
		return stops;
	}

	/**
	 * set stop number
	 * @param stops stop number
	 */
	public void setStops(int stops) {
		this.stops = stops;
	}

	/**
	 * get the flight segments
	 * @return list of flight segments
	 */
	public ArrayList<String> getRouting() {
		return routing;
	}

	/**
	 * set flight segments
	 * @param routing flight segments
	 */
	public void setRouting(ArrayList<String> routing) {
		this.routing = routing;
	}

	/**
	 * get the flight duration string
	 * @return flight duration string
	 */
	public String getFlightDuration() {
		return flightDuration;
	}

	/**
	 * set the flight duration string
	 * @param flightDuration flight duration string
	 */
	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}

	/**
	 * departure time from start airport
	 * @return departure time
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * set departure time
	 * @param startTime departure time
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * get arrival time
	 * @return arrival time
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * set arrival time
	 * @param endTime arrival time
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * get flight duration
	 * @return flight duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * set flight duration
	 * @param duration flight duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * get rank of this ticket, used for choosing best offer
	 * @return rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * set rank
	 * @param rank flight rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	/**
	 * Check if two flight are valid together.
	 * If they have overlap time then not valid
	 * @param flight flight that compares to
	 * @return true if they do not overlap, false otherwise
	 */

	/**
	 * check whether two tickets are valid together
	 * @param flight flight that compares to
	 * @return valid or not
	 */
	@Override
	public boolean checkValid(IFlight flight) {
		return true;
	}
	/**
	 * Get the rank of the ticket
	 * @param priceWeight how much price contribute to rank
	 * @return flight rank
	 */
	@Override
	public int getFlightRank(double priceWeight) {
		this.rank = (int) (100 * (this.getPrice()*priceWeight +
				this.getDuration()*50*(1-priceWeight)));
		return this.rank;
	}
	/**
	 * Check if this is a direct flight with no stops
	 * @return true if direct, false if not
	 */
	public boolean isDirect() {
		return false;
	}

	/**
	 * set if is direct
	 * @param isDirect whether is direct
	 */
	public void setDirect(boolean isDirect) {
		this.isDirect = isDirect;
	}

	/**
	 * get airline name
	 * @return airline name
	 */
	public String getAirline() {
		return airline;
	}

	/**
	 * set airline name
	 * @param airline name of airline
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}

	/**
	 * get plane type
	 * @return plane type
	 */
	public String getPlane() {
		return plane;
	}

	/**
	 * set plane type
	 * @param plane plane type
	 */
	public void setPlane(String plane) {
		this.plane = plane;
	}



	/**
	 * Check if this is a direct flight with no stops
	 * @return true if direct, false if not
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof DirectFlight) {
			DirectFlight a = (DirectFlight) o;
			return this.startAirport.equals(a.startAirport)
					&& this.endAirport.equals(a.endAirport)
					&& this.startTime.equals(a.startTime)
					&& this.endTime.equals(a.endTime)
					&& this.price == a.price
					&& this.airline.equals(a.airline)
					&& this.plane.equals(a.plane)
					&& this.duration == a.duration
					&& this.startTime.equals(a.startTime)
					&& this.endTime.equals(a.endTime);
		}
		else {
			NonDirectFlight a = (NonDirectFlight) o;
			return this.startAirport.equals(a.startAirport)
					&& this.endAirport.equals(a.endAirport)
					&& this.startTime.equals(a.startTime)
					&& this.endTime.equals(a.endTime)
					&& this.price == a.price
					&& this.airline.equals(a.airline)
					&& this.startTime.equals(a.startTime)
					&& this.endTime.equals(a.endTime);
		}

	}


	@Override
	public String toString() {
		return "NonDirectFlight{" +
				"startAirport='" + startAirport + '\'' +
				", endAirport='" + endAirport + '\'' +
				", price=" + price +
				", stops=" + stops +
				", duration=" + duration +
				", isDirect=" + isDirect +
				", airline='" + airline + '\'' +
				", plane='" + plane + '\'' +
				'}' + "\n";
	}
}
