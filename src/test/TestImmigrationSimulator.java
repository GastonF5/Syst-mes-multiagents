package test;

import java.awt.Color;

import cells.Immigration;
import cells.CellsSimulator;
import gui.GUISimulator;

public class TestImmigrationSimulator {
	public static void main(String[] args) {
        Immigration cells = new Immigration(50, 50);

		GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
		gui.setSimulable(new CellsSimulator(cells, gui));

		cells.printCells(gui);
	}
}
