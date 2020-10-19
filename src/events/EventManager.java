package events;

import java.util.ArrayList;

public class EventManager {
	private long currentDate;
	private ArrayList<Event> events;
	
	public EventManager() {
		currentDate = 0;
		events = new ArrayList<Event>();
	}
	
	public void addEvent(Event event) {
		events.add(event);
	}
	
	public void next() {
		Event event;
		for (int i = 0 ; i < events.size() ; i++) {
			event = events.get(i);
			if (event.getDate() == currentDate) {
				events.remove(i);
				event.execute();
			}
		}
		currentDate++;
	}
	
	public boolean isFinished() {
		return (events.size() == 0);
	}
	
	public void restart() {
		currentDate = 0;
		while (!isFinished()) {
			events.remove(0);
		}
	}
}