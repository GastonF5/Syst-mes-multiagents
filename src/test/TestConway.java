package test;

import cells.Conway;

public class TestConway {
    public static void main(String[] args) {
        Conway cells = new Conway(5, 5);

        System.out.println(cells.toString());
        cells.updateCells();
        System.out.println(cells.toString());
        cells.updateCells();
        System.out.println(cells.toString());
    }
}
