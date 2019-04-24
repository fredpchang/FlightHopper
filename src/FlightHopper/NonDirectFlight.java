package FlightHopper;

import java.util.List;

public class NonDirectFlight implements IFlight {

	Airport startAirport;
	Airport endAirport;
	double price;
	int stops;
	List<Airport> stopAirport;
	List<String> arriveTimeList;
	List<String> endTimeList;
	String startTime;
	String endTime;
	int duration;
	int rank;
	boolean isDirect;
	String airline;
	String plane;

	/**
	 * get the start airport
	 * @return start airport
	 */
	public Airport getStartAirport() {
		return startAirport;
	}

	/**
	 * set start airport
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

	/**
	 * get list of stop airport
	 * @return list of stop airport
	 */
	public List<Airport> getStopAirport() {
		return stopAirport;
	}

	/**
	 * set stop airport
	 * @param stopAirport
	 */
	public void setStopAirport(List<Airport> stopAirport) {
		this.stopAirport = stopAirport;
	}

	/**
	 * get the arrival times of stops
	 * @return arrival times of stops
	 */
	public List<String> getArriveTimeList() {
		return arriveTimeList;
	}

	/**
	 * set arrival times of stops
	 * @param arriveTimeList
	 */
	public void setArriveTimeList(List<String> arriveTimeList) {
		this.arriveTimeList = arriveTimeList;
	}

	/**
	 * get list of when take off from stops
	 * @return list of take off time
	 */
	public List<String> getEndTimeList() {
		return endTimeList;
	}

	/**
	 * set list of take off times for stops
	 * @param endTimeList
	 */
	public void setEndTimeList(List<String> endTimeList) {
		this.endTimeList = endTimeList;
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
		return 0;
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
	
	
	
	
}
