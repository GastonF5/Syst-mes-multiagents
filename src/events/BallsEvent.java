package events;

import balls.Balls;
import gui.GUISimulator;

/**
 * BallsEvent is a subclass of Event.
 * It manages the events of the balls simulator.
 * 
 * @see Event
 * @see Balls
 * @see GUISimulator
 */
public class BallsEvent extends Event {
	private EventManager manager;
	private Balls balls;
	private GUISimulator gui;

	/**
	 * Constructor of BallsEvent.
	 * Initializes the simulator and the balls.
	 * Also prints the balls on the simulator.
	 * 
	 * @param date
	 * 		Date of the event.
	 * @param balls
	 * 		Balls object.
	 * 		@see Balls
	 * @param gui
	 * 		GUISimulator object.
	 * 		@see GUISimulator
	 * @param manager
	 * 		EventManager object.
	 * 		@see EventManager
	 */
	public BallsEvent(long date, Balls balls, GUISimulator gui, EventManager manager) {
		super(date);
		this.balls = balls;
		this.gui = gui;
		if (date == 0) {
			this.gui.reset();
			this.balls.reInit();
			this.balls.printBalls(gui);
		}
		this.manager = manager;
	}

	/**
	 * Moves the balls and prints them on the simulator.
	 * Also manages the balls collisions on the edges of the simulator.
	 * Then adds a new BallsEvent at the date just after the current one to the event manager.
	 * 
	 * @see Event#execute
	 */
	@Override
	public void execute() {
		gui.reset();
		balls.move();
		balls.changeDirection(gui.getPanelWidth(), gui.getPanelHeight());
		balls.printBalls(gui);
		manager.addEvent(new BallsEvent(getDate() + 1, balls, gui, manager));
	}
}