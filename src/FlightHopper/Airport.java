package FlightHopper;

import java.util.List;

public class Airport {

	String name;
	List<IFlight> tickets;
	Airport destination;
	
	/**
	 *  Constructor
	 */
	public Airport() {
	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<IFlight> getTickets() {
		return tickets;
	}


	public void setTickets(List<IFlight> tickets) {
		this.tickets = tickets;
	}


	public Airport getDestination() {
		return destination;
	}


	public void setDestination(Airport destination) {
		this.destination = destination;
	}
	
	
	
	
	
}
