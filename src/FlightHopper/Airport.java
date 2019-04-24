package FlightHopper;

import java.util.ArrayList;
import java.util.List;

public class Airport {

	String name;
	List<IFlight> tickets;
	Airport destination;
	
	
	public Airport() {
		tickets = new ArrayList<IFlight>();
		this.destination = null;
	
	}
	public Airport(String name) {
		this.name = name;
		this.tickets = new ArrayList<>();
		this.destination = null;
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
