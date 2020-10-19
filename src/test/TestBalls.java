package test;

import java.awt.Point;

import balls.Balls;

public class TestBalls {
	public static void main(String[] args) {
		Point[] points = {new Point(2, 2), new Point(1, 0), new Point(3, 4), new Point(0, 2)};
		Balls balls = new Balls(points, 5);

		System.out.println(balls.toString());
		balls.translate(1, -1);
		System.out.println(balls.toString());
		balls.reInit();
		System.out.println(balls.toString());
	}
}
