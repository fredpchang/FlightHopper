package FlightHopper;

public class DirectFlight {

	Airport startAirport;
	Airport endAirport;
	double price;
	String startTime;
	String endTime;
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

	
}
