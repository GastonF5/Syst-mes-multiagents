package cells;

import java.awt.Point;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Schelling is a subclass of Cells.
 * It is the Schelling model.
 * 
 * @see Cells
 */
public class Schelling extends Cells {
    private ArrayList<Point> vacantHabitations;
    private int K;
    private Color[] colors;

    /**
     * Constructor of Schelling.
     * Creates random states for every cells.
	 * States are integers between 0 and nbStates-1.
     * 
     * @param w
     * 		Width of the matrix.
     * @param h
     * 		Height of the matrix.
     * @param K
     * 		Schelling model threshold.
     * @param nbColors
     * 		Number of colors.
     */
    public Schelling(int w, int h, int K, int nbColors) {
        super(w, h, nbColors + 1);
        this.vacantHabitations = new ArrayList<Point>();
        this.K = K;
        this.initColors();
        for (int i = 0 ; i < w ; i++) {
            for (int j = 0 ; j < h ; j++) {
                int randint = (int) (Math.random() * (nbStates));
                cells[i][j] = randint;
                initCells[i][j] = randint;
            }
        }
        for (int i = 0 ; i < w ; i++) {
            for (int j = 0 ; j < h ; j++) {
                if (cells[i][j] == 0) {
                    vacantHabitations.add(new Point(i, j));
                }
            }
        }
    }

    /**
     * Constructor of Schelling.
     * Creates random states for every cells.
	 * States are integers between 0 and nbStates-1.
     * 
     * @param w
     * 		Width of the matrix.
     * @param h
     * 		Height of the matrix.
     * @param K
     * 		Schelling model threshold.
     * @param nbColors
     * 		Number of colors.
     * @param cells
     * 		Matrix of integers.
     */
    public Schelling(int[][] cells, int w, int h, int K, int nbColors) {
        super(cells, w, h, nbColors + 1);
        vacantHabitations = new ArrayList<Point>();
        this.K = K;
        initColors();
        for (int i = 0 ; i < w ; i++) {
            for (int j = 0 ; j < h ; j++) {
                cells[i][j] = cells[i][j];
                initCells[i][j] = cells[i][j];
            }
        }
        for (int i = 0 ; i < w ; i++) {
            for (int j = 0 ; j < h ; j++) {
                if (cells[i][j] == 0) {
                    vacantHabitations.add(new Point(i, j));
                }
            }
        }
    }

    /**
     * Updates the cells according to the Schelling model rules.
     */
    public void updateCells() {
        Point habitation = new Point();
        int[] nbPerColor = new int[nbStates];
        System.out.println();
        for (int i = 0 ; i < w ; i++) {
            for (int j = 0 ; j < h ; j++) {
                if (getCell(i, j) != 0) {
                    nbPerColor = checkAround(i, j);
                    int nbNeighbours = 0;
                    for (int n = 0 ; n < nbStates ; n++) {
                        if (n != getCell(i, j)) {
                            nbNeighbours += nbPerColor[n];
                        }
                    }
                    if (nbNeighbours >= K) {
                        // recover a random vacant habitation
                        int size = vacantHabitations.size();
                        habitation = vacantHabitations.remove((int) (Math.random() * size));
                        // add the habitation in line i and column j to vacant habitations
                        vacantHabitations.add(new Point(i, j));
                        // change the states of the old and new habitations
                        int state = getCell(i, j);
                        changeState(state, (int) habitation.getX(), (int) habitation.getY());
                        changeState(0, i, j);
                    }
                }
            }
        }
    }

    /**
     * Initializes random colors for every states of the cells.
     */
    private void initColors() {
        colors = new Color[nbStates + 1];
        colors[0] = Color.white;
        for (int i = 1 ; i <= nbStates ; i++) {
            colors[i] = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
        }
    }

    /**
     * @see Cells#getColors
     */
    @Override
    public Color[] getColors() {
        return colors;
    }

    /**
     * @see Cells#upCellState
     */
    @Override
    public int upCellState(int i, int j) {
        return 0;
    }
}
