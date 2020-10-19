package events;

import boids.Boids;
import gui.GUISimulator;

/**
 * BoidsEvent is a subclass of Event.
 * It manages the events of the boids simulator.
 * 
 * @see Event
 * @see Boids
 * @see GUISimulator
 */
public class BoidsEvent extends Event {
	private Boids boids;
	private GUISimulator gui;
	private EventManager manager;
	
	/**
	 * Constructor of BoidsEvent.
	 * Initializes the simulator and the boids.
	 * Also prints the boids on the simulator.
	 * 
	 * @param date
	 * 		Date of the event.
	 * @param boids
	 * 		Boids object.
	 * 		@see Boids
	 * @param gui
	 * 		GUISimulator object.
	 * 		@see GUISimulator
	 * @param manager
	 * 		EventManager object.
	 * 		@see EventManager
	 */
	public BoidsEvent(long date, Boids boids, GUISimulator gui, EventManager manager) {
		super(date);
		this.boids = boids;
		this.gui = gui;
		if (date == 0) {
			this.gui.reset();
			this.boids.reInit();
			this.boids.printBoids(gui);
		}
		this.manager = manager;
	}

	/**
	 * Updates the boids and prints them on the simulator.
	 * Then adds a BoidsEvent at the date just after the current one to the event manager.
	 * 
	 * @see Event#execute
	 */
	@Override
	public void execute() {
		gui.reset();
        boids.updateAllBoids();
        boids.printBoids(gui);
        manager.addEvent(new BoidsEvent(getDate() + 1, boids, gui, manager));
	}
}