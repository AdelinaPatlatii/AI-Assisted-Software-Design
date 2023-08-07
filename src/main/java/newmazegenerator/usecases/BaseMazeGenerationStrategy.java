package newmazegenerator.usecases;

import newmazegenerator.models.MazeData;
import newmazegenerator.models.MazeParams;

import java.util.Random;

/**
 * The BaseMazeGenerationStrategy class is the common base class for maze generation strategies
 * and provides shared functionality for maze generation algorithms.
 */
public abstract class BaseMazeGenerationStrategy implements MazeGeneratorStrategy {

    protected int mazeWidth;
    protected int mazeHeight;
    protected boolean[][] visited;
    protected boolean[][][] walls;
    protected MazeParams mazeParams;

    /**
     * Constructs a BaseMazeGenerationStrategy instance with the given maze parameters.
     *
     * @param mazeParams The MazeParams object containing the width, height, and cell size of the maze.
     */
    public BaseMazeGenerationStrategy(MazeParams mazeParams) {
        this.mazeParams = mazeParams;
        this.mazeWidth = mazeParams.getWidth() / mazeParams.getCellSize();
        this.mazeHeight = mazeParams.getHeight() / mazeParams.getCellSize();

        visited = new boolean[mazeWidth][mazeHeight];
        walls = new boolean[mazeWidth][mazeHeight][4];
    }

    /**
     * Generates the maze using the specific maze generation algorithm.
     *
     * @return The MazeData object containing the maze parameters and the generated maze walls.
     */
    @Override
    public abstract MazeData generateMaze();

    /**
     * Shuffle an array randomly.
     *
     * @param arr The array to be shuffled.
     */
    protected void shuffleArray(int[] arr) {
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    /**
     * Remove walls between cells to create a passage.
     *
     * @param x The current x-coordinate of the cell.
     * @param y The current y-coordinate of the cell.
     * @param direction The direction of the wall to remove.
     */
    protected void removeWall(int x, int y, int direction) {
        walls[x][y][direction] = true;
        int oppositeDirection = (direction + 2) % 4;
        walls[x + dx(direction)][y + dy(direction)][oppositeDirection] = true;
    }

    /**
     * Get the change in x-coordinate based on the given direction.
     *
     * @param direction The direction (0 = Up, 1 = Right, 2 = Down, 3 = Left).
     * @return The change in x-coordinate corresponding to the direction.
     */
    protected int dx(int direction) {
        return direction == 1 ? 1 : (direction == 3 ? -1 : 0);
    }

    /**
     * Get the change in y-coordinate based on the given direction.
     *
     * @param direction The direction (0 = Up, 1 = Right, 2 = Down, 3 = Left).
     * @return The change in y-coordinate corresponding to the direction.
     */
    protected int dy(int direction) {
        return direction == 0 ? -1 : (direction == 2 ? 1 : 0);
    }
}

