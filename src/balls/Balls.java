package balls;

import java.awt.Color;

import java.awt.Point;
import java.util.ArrayList;
import gui.GUISimulator;
import gui.Oval;


/**
 * Balls is a class manipulating an array of points representing balls.
 */
public class Balls {
	private ArrayList<Point> balls;
	private ArrayList<Point> initBalls;
	private double[][] direction;
	private int speed;
	private int circleRadius;

	/**
	 * Constructor of Balls.
	 * Creates random point coordinates for every balls.
	 * 
	 * @param nbBalls
	 * 		Number of balls.
	 * @param circleRadius
	 * 		Radius of circles representing the balls.
	 * @param width
	 * 		Width of the simulator.
	 * @param height
	 * 		Height of the simulator.
	 */
	public Balls(int nbBalls, int circleRadius, int width, int height) {
		balls = new ArrayList<Point>();
		initBalls = new ArrayList<Point>();
		for (int i = 0 ; i < nbBalls ; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			balls.add(new Point(x, y));
			initBalls.add(new Point(x, y));
		}
		speed = (int) (Math.random() * 10);
		direction = new double[this.balls.size()][2];
		initRandomDirection();
		this.circleRadius = circleRadius;
	}

	/**
	 * Constructor of Balls.
	 * Initializes an array of points from the argument "balls".
	 * 
	 * @param balls
	 * 		Array of Point containing every coordinates of the balls.
	 * @param circleRadius
	 * 		Radius of circles representing the balls.
	 */
	public Balls(Point[] balls, int circleRadius) {
		this.balls = new ArrayList<Point>();
		initBalls = new ArrayList<Point>();
		for (Point b : balls) {
			this.balls.add(new Point(b.x, b.y));
			initBalls.add(b);
		}
		speed = 5 + (int) Math.random() * 5;
		direction = new double[this.balls.size()][2];
		initRandomDirection();
		this.circleRadius = circleRadius;
	}

	/**
	 * Translates every points of the array "balls".
	 * 
	 * @param dx
	 * 		Translation value on x vector.
	 * @param dy
	 * 		Translation value on y vector.
	 */
	public void translate(int dx, int dy) {
		for (Point b : balls) {
			b.translate(dx, dy);
		}
	}

	/**
	 * Reinitializes the "balls" array from the "initBalls" array.
	 */
	public void reInit() {
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).setLocation(initBalls.get(i));
		}
		this.initRandomDirection();
	}

	/**
	 * Getter of "balls".
	 * 
	 * @return The array of balls.
	 */
	public ArrayList<Point> getBalls() {
		return balls;
	}

	/**
	 * Getter of "circleRadius".
	 * 
	 * @return The circle radius of balls.
	 */
	public int getcircleRadius() {
		return circleRadius;
	}

	/**
	 * Initializes random directions for the balls.
	 */
	public void initRandomDirection() {
		for (int i = 0 ; i < balls.size() ; i++) {
			direction[i][0] = -1 + Math.random() * 2;
			direction[i][1] = -1 + Math.random() * 2;
		}
	}

	/**
	 * Change the direction of balls if they reach the edges of the simulator.
	 * Manager of balls collisions.
	 * 
	 * @param width
	 * 		Width of the simulator.
	 * @param height
	 * 		Height of the simulator.
	 */
	public void changeDirection(int width, int height) {
		for (int i = 0 ; i < balls.size() ; i++) {
			int x = balls.get(i).x;
			int y = balls.get(i).y;
			if (x < circleRadius) { direction[i][0] *= -1; }
			if (x > width - circleRadius) { direction[i][0] *= -1; }
			if (y < circleRadius) { direction[i][1] *= -1; }
			if (y > height - circleRadius) { direction[i][1] *= -1; }
		}
	}

	/**
	 * Moves every balls using its speed.
	 */
	public void move() {
		for (int i = 0 ; i < balls.size(); i++) {
			double vx = direction[i][0] * speed;
			double vy = direction[i][1] * speed;
			balls.get(i).translate((int) vx, (int) vy);
		}
	}

	/**
	 * Prints the balls as circles using circleRadius on the simulator.
	 * 
	 * @param gui
	 * 		Simulator on which the balls are printed.
	 * 		@see GUISimulator
	 */
	public void printBalls(GUISimulator gui) {
		for (int i = 0 ; i < balls.size() ; i++) {
			Point p = balls.get(i);
			gui.addGraphicalElement(new Oval(p.x, p.y, Color.WHITE, Color.WHITE, circleRadius));
		}
	}

	@Override
	public String toString() {
		String ret = new String();
		for (Point b : balls) {
			ret += "(" + b.x + " , " + b.y + ");";
		}
		return ret;
	}
}
