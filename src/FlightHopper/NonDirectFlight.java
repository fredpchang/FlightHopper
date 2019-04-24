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
	String startTime; //format: yyyymmddhhmm
	String endTime; //format: yyyymmddhhmm
	int duration;
	int rank;
	boolean isDirect;
	String airline;
	String plane;
	
	
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
	public int getStops() {
		return stops;
	}
	public void setStops(int stops) {
		this.stops = stops;
	}
	public List<Airport> getStopAirport() {
		return stopAirport;
	}
	public void setStopAirport(List<Airport> stopAirport) {
		this.stopAirport = stopAirport;
	}
	public List<String> getArriveTimeList() {
		return arriveTimeList;
	}
	public void setArriveTimeList(List<String> arriveTimeList) {
		this.arriveTimeList = arriveTimeList;
	}
	public List<String> getEndTimeList() {
		return endTimeList;
	}
	public void setEndTimeList(List<String> endTimeList) {
		this.endTimeList = endTimeList;
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
	public void setDirect(boolean isDirect) {
		this.isDirect = isDirect;
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
