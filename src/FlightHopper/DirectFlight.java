package FlightHopper;


public class DirectFlight implements IFlight {

	Airport startAirport;
	Airport endAirport;
	double price;
	String startTime; //format: yyyymmddhhmm
	String endTime; //format: yyyymmddhhmm
	int duration;
	int rank;
	boolean isDirect;
	String airline;
	String plane;

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
	 * @return
	 */
	public int getFlightRank(double priceWeight) {
		return 0;
	}
	/**
	 * Check if this is a direct flight with no stops
	 * @return true if direct, false if not
	 */
	public boolean isDirect() {
		return true;
	}


	@Override
	public boolean equals(Object o) {
		NonDirectFlight a = (NonDirectFlight) o;
		return this.startAirport.getName().equals(a.startAirport.getName())
				&& this.endAirport.getName().equals(a.endAirport.getName())
				&& this.startTime.equals(a.startTime)
				&& this.endTime.equals(a.endTime)
				&& this.price == a.price
				&& this.airline.equals(a.airline);
	}


	/**
	 * get start airport
	 * @return start airport
	 */
	public Airport getStartAirport() {
		return startAirport;
	}

	/**
	 * set start airport to some value
	 * @param startAirport
	 */
	public void setStartAirport(Airport startAirport) {
		this.startAirport = startAirport;
	}

	/**
	 * get end airport
	 * @return end airport
	 */
	public Airport getEndAirport() {
		return endAirport;
	}

	/**
	 * set end airport
	 * @param endAirport
	 */
	public void setEndAirport(Airport endAirport) {
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
	 * get departure time
	 * @return departure time
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * set departure time to something
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
	 * @param rank
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
	 * @param airline
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
	 * @param plane
	 */
	public void setPlane(String plane) {
		this.plane = plane;
	}
}
