package FlightHopper;

public interface IFlight {

	/**
	 * Check if two flight are valid together.
	 * If they have overlap time then not valid
	 * @param flight flight that compares to
	 * @return true if they do not overlap, false otherwise
	 */
	public boolean checkValid(IFlight flight);

	/**
	 * Get the rank of the ticket
	 * @param priceWeight how much price contribute to rank
	 * @return flight rank
	 */
	public int getFlightRank(double priceWeight);

	/**
	 * Check if this is a direct flight with no stops
	 * @return true if direct, false if not
	 */
	public boolean isDirect();

	/**
	 * equal method to compare tickets
	 * @param o the other ticket
	 * @return their relationship
	 */
	@Override
	public boolean equals(Object o);

	/**
	 * Prints formatted flight info to console
	 */
	public void printFlight();
	

}
