package events;

import cells.Cells;
import gui.GUISimulator;

/**
 * CellsEvent is a subclass of Event.
 * It manages the events of the cells simulator.
 * 
 * @see Event
 * @see Cells
 * @see GUISimulator
 */
public class CellsEvent extends Event {
	private Cells cells;
	private GUISimulator gui;
	private EventManager manager;
	
	/**
	 * Constructor of CellsEvent.
	 * Initializes the simulator and the cells.
	 * Also prints the cells on the simulator.
	 * 
	 * @param date
	 * 		Date of the event.
	 * @param cells
	 * 		Cells object.
	 * 		@see Cells
	 * @param gui
	 * 		GUISimulator object.
	 * 		@see GUISimulator
	 * @param manager
	 * 		EventManager object.
	 * 		@see EventManager
	 */
	public CellsEvent(long date, Cells cells, GUISimulator gui, EventManager manager) {
		super(date);
		this.cells = cells;
		this.gui = gui;
		if (date == 0) {
			this.gui.reset();
			this.cells.reInit();
			this.cells.printCells(gui);
		}
		this.manager = manager;
	}

	/**
	 * Updates the cells and prints them on the simulator.
	 * Then adds a CellsEvent at the date just after the current one to the event manager.
	 * 
	 * @see Event#execute
	 */
	@Override
	public void execute() {
		gui.reset();
		cells.updateCells();
		cells.printCells(gui);
		manager.addEvent(new CellsEvent(getDate() + 1, cells, gui, manager));
	}
}