package cells;

import java.awt.Color;

/**
 * Immigration is a subclass of Cells.
 * It is the immigration game.
 * 
 * @see Cells
 */
public class Immigration extends Cells {
	/**
	 * Constructor of Immigration.
	 * Creates random states for every cells.
	 * States are integers between 0 and nbStates-1.
	 * 
	 * @param w
	 * 		Width of the matrix.
	 * @param h
	 * 		Height of the matrix.
	 */
    public Immigration(int w, int h) {
        super(w, h, 4);
    }

	/**
	 * Constructor of Immigration.
	 * Initializes a matrix of cells states from the matrix "cells".
	 * States are integers between 0 and nbStates-1.
	 * 
	 * @param w
	 * 		Width of the matrix.
	 * @param h
	 * 		Height of the matrix.
	 * @param cells
	 * 		Matrix of integers.
	 */
    public Immigration(int[][] cells, int w, int h) {
        super(cells, w, h, 4);
    }

    /**
     * Updates the cells according to the Immigration game rules.
     */
    public void updateCells() {
        int[] nbPerState = new int[nbStates];
        int[][] cellsToChange = new int[w][h];
        for (int i = 0 ; i < w ; i++) {
            for (int j = 0 ; j < h ; j++) {
                nbPerState = checkAround(i, j);
                int k = getCell(i, j); // integer used for the state of a cell
                if (nbPerState[(k + 1) % nbStates] >= 3) {
                	cellsToChange[i][j]++;
                }
            }
        }
        this.update(cellsToChange);
    }

    /**
     * @see Cells#getColors
     */
    @Override
    public Color[] getColors() {
        Color[] colors = new Color[nbStates];
        colors[0] = Color.white;
        colors[1] = Color.lightGray;
        colors[2] = Color.darkGray;
        colors[3] = Color.black;
        return colors;
    }
}
