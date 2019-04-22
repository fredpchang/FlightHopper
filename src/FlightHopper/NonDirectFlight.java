package FlightHopper;

import java.util.List;

public class NonDirectFlight {

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
	public boolean isDirect() {
		return isDirect;
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
