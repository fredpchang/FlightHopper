package FlightHopper;


public class DirectFlight implements IFlight {

	String startAirport;
	String endAirport;
	double price;
	String startTime; //format: yyyymmddhhmm
	String endTime; //format: yyyymmddhhmm
	int duration;
	int rank;
	boolean isDirect;
	String airline;
	String plane;
	
	public DirectFlight() {
		
	}
	
	public DirectFlight(String startAirport,
						String endAirport,
						double price,
						String startTime,
						String endTime,
						int duration,
						boolean isDirect,
						String airline,
						String plane
						) {
		
		this.startAirport = startAirport;
		this.endAirport = endAirport;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.isDirect = isDirect;
		this.airline = airline;
		this.plane = plane;
	}

	/**
	 * Check if two flight are valid together.
	 * If they have overlap time then not valid
	 * @param flight flight that compares to
	 * @return true if they do not overlap, false otherwise
	 */
	public boolean checkValid(IFlight flight) {
		return true;
	}
	/**
	 * Get the rank of the ticket
	 * @param priceWeight how much price contribute to rank
	 * @return
	 */
	@Override
    public int getFlightRank(double priceWeight) {
        this.rank = (int) (100 * (this.getPrice()*priceWeight +
                this.getDuration()*50*(1-priceWeight)));
        return this.rank;
    }
	/**
	 * Check if this is a direct flight with no stops
	 * @return true if direct, false if not
	 */
	public boolean isDirect() {
		return true;
	}


	@Override
	public boolean equals(Object o) {
		if(o instanceof DirectFlight) {
			DirectFlight a = (DirectFlight) o;
			return this.startAirport.equals(a.startAirport)
					&& this.endAirport.equals(a.endAirport)
					&& this.startTime.equals(a.startTime)
					&& this.endTime.equals(a.endTime)
					&& this.price == a.price
					&& this.airline.equals(a.airline)
					&& this.plane.equals(a.plane)
					&& this.duration == a.duration;
		}
		else {
			NonDirectFlight a = (NonDirectFlight) o;
			return this.startAirport.equals(a.startAirport)
					&& this.endAirport.equals(a.endAirport)
					&& this.startTime.equals(a.startTime)
					&& this.endTime.equals(a.endTime)
					&& this.price == a.price
					&& this.airline.equals(a.airline);
		}
	}


	/**
	 * get start airport
	 * @return start airport
	 */
	public String getStartAirport() {
		return startAirport;
	}

	/**
	 * set start airport to some value
	 * @param startAirport
	 */
	public void setStartAirport(String startAirport) {
		this.startAirport = startAirport;
	}

	/**
	 * get end airport
	 * @return end airport
	 */
	public String getEndAirport() {
		return endAirport;
	}

	/**
	 * set end airport
	 * @param endAirport
	 */
	public void setEndAirport(String endAirport) {
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
	 * get departure time
	 * @return departure time
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * set departure time to something
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
	 * get the rank of this ticket, use to choose best offer
	 * @return rank
	 */
	public int getRank() {
		return rank;
	}

	public void setDirect(boolean isDirect) {
		this.isDirect = isDirect;
	}
	/**
	 * set rank to something
	 * @param rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
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
	 * @return plane type
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

	@Override
	public String toString() {
		return "DirectFlight{" +
				"startAirport='" + startAirport + '\'' +
				", endAirport='" + endAirport + '\'' +
				", price=" + price +
				", duration=" + duration +
				", isDirect=" + isDirect +
				", airline='" + airline + '\'' +
				", plane='" + plane + '\'' +
				'}' + "\n";
	}
}
