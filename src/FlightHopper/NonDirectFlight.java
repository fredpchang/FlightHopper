package FlightHopper;

import java.util.ArrayList;
import java.util.List;

public class NonDirectFlight implements IFlight {

	String startAirport;
	String endAirport;
	double price;
	int stops;
	ArrayList<String> routing; //formatted form for printing
	String startTime; //format: yyyymmddhhmm
	String endTime; //format: yyyymmddhhmm
	String flightDuration; //string form for printing
	int duration;
	int rank;
	boolean isDirect;
	String airline;
	String plane;

	public NonDirectFlight() {

	}

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


	@Override
	public void printFlight(){

		System.out.printf("[%s] ---> [%s] \n", this.getStartAirport(), this.getEndAirport());
		System.out.println("Stops: " + this.stops);
		System.out.println("Price: $" + this.price);
		System.out.println("Duration (hrs): " + this.getDuration());
		System.out.println(this.getAirline() + " " + this.getPlane());
		for (String i : this.getRouting()){
			System.out.println(i);
		}
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
	 * @param startAirport
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
	 * @param endAirport
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
	 * @param price
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
	 * @param stops
	 */
	public void setStops(int stops) {
		this.stops = stops;
	}

	public ArrayList<String> getRouting() {
		return routing;
	}

	public void setRouting(ArrayList<String> routing) {
		this.routing = routing;
	}

	public String getFlightDuration() {
		return flightDuration;
	}

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
	 * @param startTime
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
	 * @param endTime
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
	 * @param duration
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
	 * @param rank
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
	@Override
	public boolean checkValid(IFlight flight) {
		return false;
	}
	/**
	 * Get the rank of the ticket
	 * @param priceWeight how much price contribute to rank
	 * @return
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

//	@Override
//	public boolean equals(Object o) {
//		NonDirectFlight a = (NonDirectFlight) o;
//		return this.startAirport.getName().equals(a.startAirport.getName())
//				&& this.endAirport.getName().equals(a.endAirport.getName())
//				&& this.startTime.equals(a.startTime)
//				&& this.endTime.equals(a.endTime)
//				&& this.price == a.price
//				&& this.airline.equals(a.airline);
//	}
	public boolean isDirect() {
		return false;
	}

	/**
	 * set if is direct
	 * @param isDirect
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
	 * @param airline
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}

	/**
	 * get plane type
	 * @return
	 */
	public String getPlane() {
		return plane;
	}

	/**
	 * set plane type
	 * @param plane
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
