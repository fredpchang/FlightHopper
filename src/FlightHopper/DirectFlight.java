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


	public Airport getStartAirport() {
		return startAirport;
	}

	public void setStartAirport(Airport startAirport) {
		this.startAirport = startAirport;
	}

	public Airport getEndAirport() {
		return endAirport;
	}

	public void setEndAirport(Airport endAirport) {
		this.endAirport = endAirport;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setDirect(boolean direct) {
		isDirect = direct;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}
}
