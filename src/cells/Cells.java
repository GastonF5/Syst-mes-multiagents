package cells;

import java.awt.Color;
import gui.GUISimulator;
import gui.Rectangle;

/**
 * Cells is an superclass manipulating a matrix of integers representing cells in different states.
 */
public abstract class Cells {
    protected int[][] cells;
    protected final int[][] initCells;
    protected int nbStates;
    protected int w;
    protected int h;
    
	/**
	 * Getter of the color of the printed cell on the simulator.
	 * @return The color of the cell.
	 */
    abstract Color[] getColors();
    
    /**
     * Updates the cells states according to the subclass rules.
     */
    abstract public void updateCells();

    /**
     * Constructor of Cells.
     * Creates random states for every cells.
     * States are integers between 0 and nbStates-1.
     *
     * @param w
     * 		Width of the matrix "cells".
     * @param h
     * 		Height of the matrix "cells".
     * @param nbStates
     * 		Number of states.
     */
    public Cells(int w, int h, int nbStates) {
        int randint;
        this.cells = new int[w][h];
        this.initCells = new int[w][h];
        this.nbStates = nbStates;
        this.w = w;
        this.h = h;
        for (int i = 0 ; i < w ; i++) {
            for (int j = 0 ; j < h ; j++) {
                randint = (int) (Math.random() * nbStates);
                this.cells[i][j] = randint;
                this.initCells[i][j] = randint;
            }
        }
    }

    /**
     * Constructor of Cells.
     * Initializes a matrix of cells states from the matrix "cells".
     * States are integers between 0 and nbStates-1. 
     * 
     * @param cells
     * 		Matrix of integers. Also the states of the cells.
     * @param w
     * 		Width of the matrix "cells".
     * @param h
     * 		Height of the matrix "cells".
     * @param nbStates
     * 		Number of states.
     */
    public Cells(int[][] cells, int w, int h, int nbStates) {
        this.cells = new int[w][h];
        this.initCells = new int[w][h];
        this.nbStates = nbStates;
        this.w = w;
        this.h = h;
        for (int i = 0 ; i < w ; i++) {
            for (int j = 0 ; j < h ; j++) {
                this.cells[i][j] = cells[i][j];
                this.initCells[i][j] = cells[i][j];
            }
        }
    }

    /**
     * Reinitializes the "cells" matrix from the "initCells" matrix.
     */
    public void reInit() {
        for (int i = 0 ; i < this.w ; i++) {
            for (int j = 0 ; j < this.h ; j++) {
                this.cells[i][j] = this.initCells[i][j];
            }
        }
    }

    /**
     * Getter of the cell on line i and column j.
     * 
     * @param i
     * 		Line index of the cell.
     * @param j
     * 		Column index of the cell.
     * @return The state of the cell.
     */
    public int getCell(int i, int j) {
        i = (i % this.w + this.w) % this.w;
        j = (j % this.h + this.h) % this.h;
        return cells[i][j];
    }

    /**
     * Changes the state of the cell on line i and column j.
     * 
     * @param state
     * 		The new state of the cell.
     * @param i
     * 		Line index of the cell.
     * @param j
     * 		Column index of the cell.
     */
    public void changeState(int state, int i, int j) {
        cells[i][j] = state;
    }

    /**
     * Checks the states of the cells around the cell on line i and column j.
     * 
     * @param i
     * 		Line index of the cell.
     * @param j
     * 		Column index of the cell.
     * @return An integer array of the cells states around the cell.
     */
    public int[] checkAround(int i, int j) {
        int[] nbPerState = new int[nbStates];
        int state;
        for (int ni = 0 ; ni <= 2 ; ni++) {
            for (int nj = 0 ; nj <= 2 ; nj++) {
                if (!(ni == 1 && nj == 1)) {
                    state = getCell(i + ni - 1, j + nj - 1);
                    nbPerState[state]++;
                }
            }
        }
        return nbPerState;
    }

    /**
     * Updates the cells from the matrix "cellsToChange".
     * 
     * @param cellsToChange
     * 		Matrix of 0 and 1 for every cells.
     * 		1 if the cell has to be changed, 0 else.
     */
    public void update(int[][] cellsToChange) {
        int newState;
        for (int i = 0 ; i < w ; i++) {
            for (int j = 0 ; j < h ; j++) {
                if (cellsToChange[i][j] == 1) {
                    newState = upCellState(i, j);
                    changeState(newState, i, j);
                }
            }
        }
    }

    /**
     * Prints the cells as a grid of squares in different colors according to its cell state.
     * 
     * @param gui
     * 		Simulator on which the cells are printed.
     * 		@see GUISimulator
     */
    public void printCells(GUISimulator gui) {
        Color[] colors = new Color[nbStates];
        colors = this.getColors();
        Color rectColor;
        int width = gui.getPanelWidth();
        int height = gui.getPanelHeight();
        int rectSize = Math.min((int) (width / this.w), (int) (height / this.h));
        for (int i = 0 ; i < this.w ; i++) {
            for (int j = 0 ; j < this.h ; j++) {
                rectColor = colors[this.getCell(i, j)];
                gui.addGraphicalElement(new Rectangle(j*rectSize + (rectSize/2), i*rectSize + (rectSize/2), Color.black, rectColor, rectSize));
            }
        }
    }
    
    /**
     * Increments the cell state.
     * If the state exceeds the number of states, the new state becomes 0.
     * 
     * @param i
     * 		Line index of the cell.
     * @param j
     * 		Column index of the cell.
     * @return The new state of the cell.
     */
    public int upCellState(int i, int j) {
    	return (getCell(i, j) + 1) % nbStates;
    }
    
    @Override
    public String toString() {
        String str = "";
        for (int i = 0 ; i < this.w ; i++) {
            for (int j = 0 ; j < this.h ; j++) {
                str += (this.getCell(i, j));
            }
            str += "\n";
        }
        return str;
    }
}
