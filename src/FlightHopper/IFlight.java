package FlightHopper;

public interface IFlight {

	public boolean checkValid(IFlight flight);
	
	public int getFlightRank(double priceWeight);
	
	public boolean isDirect();
	
	
}
