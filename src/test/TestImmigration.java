package test;

import cells.Immigration;

public class TestImmigration {
    public static void main(String[] args) {
        int[][] states = new int[5][5];
        states[0][0] = 3;
        states[0][2] = 1;
        states[0][3] = 1;

        states[1][0] = 3;
        states[1][1] = 1;
        states[1][2] = 1;
        states[1][3] = 1;
        states[1][4] = 2;

        states[2][0] = 1;
        states[2][1] = 1;
        states[2][2] = 3;
        states[2][3] = 2;
        states[2][4] = 2;

        states[3][1] = 1;
        states[3][2] = 2;
        states[3][3] = 2;
        states[3][4] = 2;

        states[4][1] = 3;
        states[4][2] = 2;
        states[4][3] = 2;
        states[4][4] = 1;

        Immigration cells = new Immigration(states, 5, 5);

        System.out.println(cells.toString());
        cells.updateCells();
        System.out.println(cells.toString());
        cells.updateCells();
        System.out.println(cells.toString());
    }
}
