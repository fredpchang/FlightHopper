package FlightHopper;

import java.util.List;

public class Airport {

	String name;
	List<Flight> tickets;
	Airport destination;
	
	
	public Airport() {
	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Flight> getTickets() {
		return tickets;
	}


	public void setTickets(List<Flight> tickets) {
		this.tickets = tickets;
	}


	public Airport getDestination() {
		return destination;
	}


	public void setDestination(Airport destination) {
		this.destination = destination;
	}
	
	
	
	
	
}
