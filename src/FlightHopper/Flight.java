package FlightHopper;

public interface Flight {

	public boolean checkValid(Flight flight);
	
	public int getFlightRank(double priceWeight);
	
	public boolean isDirect();
	
	
}
