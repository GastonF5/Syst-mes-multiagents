package events;

/**
 * Event is a superclass of different kinds of events.
 */
abstract class Event {
	private long date;
	
	/**
	 * Constructor of Event.
	 * 
	 * @param date
	 * 		Date of the event.
	 */
	public Event(long date) {
		this.date = date;
	}
	
	/**
	 * Getter of the event date.
	 * 
	 * @return The date of the event.
	 */
	public long getDate() {
		return date;
	}

	abstract public void execute();
}