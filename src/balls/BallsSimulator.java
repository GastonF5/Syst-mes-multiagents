package balls;

import gui.Simulable;
import gui.GUISimulator;
import events.EventManager;
import events.BallsEvent;

/**
 * BallsSimulator is a class implementing the Simulable interface.
 * This class also uses an EventManager.
 * 
 * @see Simulable
 * @see EventManager
 */
public class BallsSimulator implements Simulable {
	/**
	 * Event manager of the simulator.
	 */
	private EventManager manager;
	private Balls balls;
	private GUISimulator gui;

	/**
	 * Constructor of BallsSimulator.
	 * Initializes the event manager.
	 * 
	 * @param balls
	 * 		Balls object.
	 * 		@see Balls
	 * @param gui
	 * 		GUISimulator object.
	 * 		@see GUISimulator
	 */
	public BallsSimulator(Balls balls, GUISimulator gui) {
		this.balls = balls;
		this.gui = gui;
		manager = new EventManager();
		manager.addEvent(new BallsEvent(0, balls, gui, manager));
	}

	/**
	 * @see EventManager#next
	 */
	public void next() {
		manager.next();
	}

	/**
	 * Restarts the simulator.
	 * Adds the first event of the simulation.
	 * 
	 * @see EventManager#restart
	 * @see EventManager#addEvent
	 */
	public void restart() {
		manager.restart();
		manager.addEvent(new BallsEvent(0, balls, gui, manager));
	}
}