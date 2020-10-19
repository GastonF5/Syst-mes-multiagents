package test;

import java.awt.Color;

import cells.Conway;
import cells.CellsSimulator;
import gui.GUISimulator;

public class TestConwaySimulator {
	public static void main(String[] args) {
        int[][] states = new int[5][5];
        states[1][1] = 1;
        states[2][1] = 1;
        states[1][2] = 1;
        states[2][3] = 1;
        states[4][4] = 1;
        Conway cells = new Conway(states, 5, 5);

		GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
		gui.setSimulable(new CellsSimulator(cells, gui));

		cells.printCells(gui);
	}
}
