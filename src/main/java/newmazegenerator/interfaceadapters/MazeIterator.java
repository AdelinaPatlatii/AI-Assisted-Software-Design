package newmazegenerator.interfaceadapters;

/**
 * The MazeIterator class provides an iterator to traverse through the cells of the maze.
 * It allows iterating over the maze cells and provides methods to check if there is a wall
 * in a specific direction for the current cell.
 */
public class MazeIterator {
    private boolean[][][] walls;
    private int width;
    private int height;
    private int x;
    private int y;

    /**
     * Constructs a MazeIterator with the provided maze walls, width, and height.
     *
     * @param walls  The 3D array representing the walls of the maze.
     * @param width  The width of the maze (number of cells in a row).
     * @param height The height of the maze (number of cells in a column).
     */
    public MazeIterator(boolean[][][] walls, int width, int height) {
        this.walls = walls;
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
    }

    /**
     * Checks if there is another cell to iterate over.
     *
     * @return true if there is another cell to iterate, false otherwise.
     */
    public boolean hasNext() {
        return y < height;
    }

    /**
     * Moves the iterator to the next cell in the maze.
     */
    public void next() {
        x++;
        if (x >= width) {
            x = 0;
            y++;
        }
    }

    /**
     * Checks if there is a wall in a specific direction for the current cell.
     *
     * @param direction The direction to check for a wall (0 = Up, 1 = Right, 2 = Down, 3 = Left).
     * @return true if there is a wall in the given direction, false otherwise.
     */
    public boolean isWall(int direction) {
        return walls[x][y][direction];
    }

    /**
     * Gets the x-coordinate of the current cell in the maze.
     *
     * @return The x-coordinate of the current cell.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the current cell in the maze.
     *
     * @return The y-coordinate of the current cell.
     */
    public int getY() {
        return y;
    }
}
