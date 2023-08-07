package newmazegenerator.usecases;

import newmazegenerator.models.MazeData;
import newmazegenerator.models.MazeParams;

/**
 * The RecursiveBacktrackingStrategy class implements the MazeGeneratorStrategy interface
 * and represents a strategy for generating a maze using the Recursive Backtracking algorithm.
 * This strategy generates a maze by recursively exploring cells and removing walls to create passages.
 */
public class RecursiveBacktrackingStrategy extends BaseMazeGenerationStrategy {

    /**
     * Constructs a RecursiveBacktrackingStrategy instance with the given maze parameters.
     *
     * @param mazeParams The MazeParams object containing the width, height, and cell size of the maze.
     */
    public RecursiveBacktrackingStrategy(MazeParams mazeParams) {
        super(mazeParams);
    }

    /**
     * Generates the maze using the Recursive Backtracking algorithm.
     *
     * @return The MazeData object containing the maze parameters and the generated maze walls.
     */
    @Override
    public MazeData generateMaze() {
        generateMaze(0, 0);
        return new MazeData(mazeParams, walls);
    }

    /**
     * Recursive Backtracking algorithm to generate the maze.
     *
     * @param x The current x-coordinate of the cell being visited.
     * @param y The current y-coordinate of the cell being visited.
     */
    private void generateMaze(int x, int y) {
        visited[x][y] = true;
        int[] directions = {0, 1, 2, 3};
        shuffleArray(directions);

        for (int direction : directions) {
            int nextX = x + dx(direction);
            int nextY = y + dy(direction);

            if (nextX >= 0 && nextY >= 0 && nextX < mazeWidth && nextY < mazeHeight && !visited[nextX][nextY]) {
                removeWall(x, y, direction);
                generateMaze(nextX, nextY);
            }
        }
    }
}
