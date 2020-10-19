package test;

import cells.Schelling;

public class TestSchelling {
    public static void main(String[] args) {
        Schelling cells = new Schelling(10, 10, 2, 2);
        System.out.println(cells.toString());
        cells.updateCells();
        System.out.println(cells.toString());
        cells.updateCells();
        System.out.println(cells.toString());
    }
}
