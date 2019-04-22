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
	
	public boolean checkValid(IFlight flight) {
		return true;
	}
	
	public int getFlightRank(double priceWeight) {
		return 0;
	}
	
	public boolean isDirect() {
		return true;
	}

	
}
