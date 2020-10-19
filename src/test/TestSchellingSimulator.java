package test;

import java.awt.Color;

import cells.Schelling;
import cells.CellsSimulator;
import gui.GUISimulator;

public class TestSchellingSimulator {
    public static void main(String[] args) {
        Schelling cells = new Schelling(30, 30, 6, 3);

        GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
        gui.setSimulable(new CellsSimulator(cells, gui));

        cells.printCells(gui);
    }
}
