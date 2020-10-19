package cells;

import java.awt.Color;

/**
 * Conway is a subclass of Cells.
 * It is the Conway life game.
 * 
 * @see Cells
 */
public class Conway extends Cells {
	/**
	 * Constructor of Conway.
	 * Creates random states for every cells.
	 * States are integers between 0 and nbStates-1.
	 * 
	 * @param w
	 * 		Width of the matrix "cells".
	 * @param h
	 * 		Height of the matrix "cells".
	 */
    public Conway(int w, int h) {
        super(w, h, 2);
    }

	/**
     * Constructor of Cells.
     * Initializes a matrix of cells states from the matrix "cells".
     * States are integers between 0 and nbStates-1.
	 * 
	 * @param w
	 * 		Width of the matrix "cells".
	 * @param h
	 * 		Height of the matrix "cells".
	 * @param cells
	 * 		Matrix of integers.
	 */
    public Conway(int[][] cells, int w, int h) {
        super(cells, w, h, 2);
    }

    /**
     * Updates the cells according to the Conway life game rules.
     */
    public void updateCells() {
        int[] nbPerState = new int[nbStates];
        int[][] cellsToChange = new int[w][h];
        int nbAlives;
        for (int i = 0 ; i < w ; i++) {
            for (int j = 0 ; j <  h ; j++) {
                nbPerState = checkAround(i, j);
                nbAlives = nbPerState[1];
                // if alive and 2 or 3 alives around becomes dead
                if (getCell(i, j) == 1) {
                    if (!(nbAlives == 2 || nbAlives == 3)) {
                        cellsToChange[i][j]++; }
                }
                // if dead and exactly 3 alive around becomes alive
                else {
                    if (nbAlives == 3) {
                        cellsToChange[i][j]++; }
                }
            }
        }
        update(cellsToChange);
    }

    /**
     * @see Cells#getColors
     */
    @Override
    public Color[] getColors() {
        Color[] colors = new Color[nbStates];
        colors[0] = Color.white;
        colors[1] = Color.blue;
        return colors;
    }
}
