package cells;

import gui.Simulable;
import gui.GUISimulator;
import events.EventManager;
import events.CellsEvent;

/**
 * CellsSimulator is a class implementing the Simulable interface.
 * This class also uses an EventManager.
 * 
 * @see Simulable
 * @see EventManager
 */
public class CellsSimulator implements Simulable {
	/**
	 * Event manager of the simulator.
	 */
	private EventManager manager;
	private Cells cells;
	private GUISimulator gui;
	
	/**
	 * Constructor of CellsSimulator.
	 * Initializes the event manager.
	 * 
	 * @param cells
	 * 		Cells object.
	 * 		@see Cells
	 * @param gui
	 * 		GUISimulator object.
	 * 		@see GUISimulator
	 */
	public CellsSimulator(Cells cells, GUISimulator gui) {
		this.cells = cells;
		this.gui = gui;
		manager = new EventManager();
		manager.addEvent(new CellsEvent(0, cells, gui, manager));
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
		manager.addEvent(new CellsEvent(0, cells, gui, manager));
	}
}