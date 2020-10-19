package test;

import java.awt.Color;

import balls.Balls;
import balls.BallsSimulator;
import gui.GUISimulator;

public class TestBallsSimulator {
	public static void main(String[] args) {
		Balls balls = new Balls(5, 5, 500, 500);

		GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);
		gui.setSimulable(new BallsSimulator(balls, gui));

		balls.printBalls(gui);
	}
}
