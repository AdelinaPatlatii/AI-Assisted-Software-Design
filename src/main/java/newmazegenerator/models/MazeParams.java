package newmazegenerator.models;

/**
 * The MazeParams class represents the parameters of a maze, such as width, height, and cell size.
 */
public class MazeParams {
    private int width;
    private int height;
    private int cellSize;

    /**
     * Constructor to initialize the MazeParams with width, height, and cell size.
     *
     * @param width    The width of the maze.
     * @param height   The height of the maze.
     * @param cellSize The cell size of the maze.
     */
    public MazeParams(int width, int height, int cellSize) {
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
    }

    /**
     * Get the width of the maze.
     *
     * @return The width of the maze.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the height of the maze.
     *
     * @return The height of the maze.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get the cell size of the maze.
     *
     * @return The cell size of the maze.
     */
    public int getCellSize() {
        return cellSize;
    }
}
