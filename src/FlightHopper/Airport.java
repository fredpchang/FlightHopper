package FlightHopper;

import java.util.ArrayList;
import java.util.List;

public class Airport {

	String name;
	List<IFlight> tickets;
	Airport destination;
	
	/**
	 *  Constructor
	 */
	public Airport() {
		tickets = new ArrayList<IFlight>();
		this.destination = null;
	
	}
	public Airport(String name) {
		this.name = name;
		this.tickets = new ArrayList<>();
		this.destination = null;
	}

	/**
	 * get name
	 * @return name string
	 */
	public String getName() {
		return name;
	}


	/**
	 * set name to a value
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * get list of tickets
	 * @return list of tickets
	 */
	public List<IFlight> getTickets() {
		return tickets;
	}


	/**
	 * set tickets to be a new list
	 * @param tickets
	 */
	public void setTickets(List<IFlight> tickets) {
		this.tickets = tickets;
	}


	/**
	 * get the destination, also as next node
	 * @return destination node
	 */
	public Airport getDestination() {
		return destination;
	}

	/**
	 * set destination to be a new node
	 * @param destination
	 */
	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	/**
	 * override equal method
	 * @param o
	 * @return
	 */
	public boolean equals(Object o) {
		Airport a = (Airport) o;
		return a.name.equals(this.name);
	}
	
	
	
	
}
