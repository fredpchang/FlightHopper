package FlightHopper;
import java.util.*;

public class DirectFlight implements IFlight {

	String startAirport;
	String endAirport;
	double price;
	String startTime; //format: yyyymmddhhmm
	String endTime; //format: yyyymmddhhmm
	int duration;
	int rank;
	boolean isDirect;
	String airline;
	String plane;
	ArrayList<String> routing; //string of routing for printing
	String flightDuration; //string form for printing

	/**
	 * default constructor
	 */
	public DirectFlight() {
		
	}

	/**
	 * build a DirectFlight object with some fields
	 * @param startAirport name of start airport
	 * @param endAirport name of end airport
	 * @param price ticket price
	 * @param routing array of string that include the ticket route
	 * @param startTime departure time
	 * @param endTime arrival time
	 * @param flightDuration total flight duration of this ticket in string format
	 * @param duration total flight duration of this ticket in integer
	 * @param rank the rank of this ticket, used for ticket comparing
	 * @param isDirect indicate whether this is a direct flight
	 * @param airline the name of flight
	 * @param plane plane type
	 */
	public DirectFlight(String startAirport,
						String endAirport,
						double price,
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
	 * Check if two flight are valid together.
	 * If they have overlap time then not valid
	 * @param flight flight that compares to
	 * @return true if they do not overlap, false otherwise
	 */
	public boolean checkValid(IFlight flight) {
		return true;
	}
	/**
	 * Get the rank of the ticket
	 * @param priceWeight how much price contribute to rank
	 * @return the flight rank with this price weight
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
		return true;
	}


	/**
	 * compare whether two tickets are the same
	 * @param o the ticket we compare to
	 * @return their relationship
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


	/**
	 * get start airport
	 * @return start airport
	 */
	public String getStartAirport() {
		return startAirport;
	}

	/**
	 * set start airport to some value
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
	 * @param endAirport name of end airport
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
	 * get departure time
	 * @return departure time
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * set departure time to something
	 * @param startTime start time string
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
	 * @param endTime end time string
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
	 * get the rank of this ticket, use to choose best offer
	 * @return rank
	 */
	public int getRank() {
		return rank;
	}

	public void setDirect(boolean isDirect) {
		this.isDirect = isDirect;
	}
	/**
	 * set rank to something
	 * @param rank ticket rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
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
	 * @param airline airline name
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
	 * to string method
	 * @return the string to represent this flight
	 */
	@Override
	public String toString() {
		return "DirectFlight{" +
				"startAirport='" + startAirport + '\'' +
				", endAirport='" + endAirport + '\'' +
				", price=" + price +
				", duration=" + duration +
				", isDirect=" + isDirect +
				", airline='" + airline + '\'' +
				", plane='" + plane + '\'' +
				'}' + "\n";
	}

	/**
	 * get the routing
	 * @return routes array
	 */
	public ArrayList<String> getRouting() {
		return routing;
	}

	/**
	 * set the routing array
	 * @param routing routing array
	 */
	public void setRouting(ArrayList<String> routing) {
		this.routing = routing;
	}

	/**
	 * Print Flight method for flight tickets
	 */
	@Override
	public void printFlight(){


		System.out.printf("[%s] ---> [%s] \n", this.getStartAirport(), this.getEndAirport());
		System.out.println("Stops: Nonstop");
		System.out.println("Price: $" + this.price);
		System.out.println("Duration: " + this.getDuration());
		System.out.println(this.getAirline() + " " + this.getPlane());
		String year = this.getStartTime().substring(0, 4);
		String month = this.getStartTime().substring(4, 6);
		String day = this.getStartTime().substring(6, 8);
		System.out.println(year + "/" + month + "/" + day);
		System.out.println(routing.get(0));


		return;
	}
}
