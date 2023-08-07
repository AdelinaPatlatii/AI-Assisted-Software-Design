package newmazegenerator.usecases;

import newmazegenerator.models.MazeData;
import newmazegenerator.models.MazeParams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The PrimAlgorithmStrategy class implements the MazeGeneratorStrategy interface
 * and represents a strategy for generating a maze using Prim's Algorithm.
 * This strategy generates a maze by starting with a random cell and growing the maze from there
 * by repeatedly adding walls and passages.
 */
public class PrimAlgorithmStrategy extends BaseMazeGenerationStrategy implements MazeGeneratorStrategy {

    /**
     * Constructs a PrimAlgorithmStrategy instance with the given maze parameters.
     *
     * @param mazeParams The MazeParams object containing the width, height, and cell size of the maze.
     */
    public PrimAlgorithmStrategy(MazeParams mazeParams) {
        super(mazeParams);
    }

    /**
     * Generates the maze using Prim's Algorithm.
     *
     * @return The MazeData object containing the maze parameters and the generated maze walls.
     */
    @Override
    public MazeData generateMaze() {
        // Start with a random cell and mark it as visited
        Random random = new Random();
        int startX = random.nextInt(mazeWidth);
        int startY = random.nextInt(mazeHeight);
        visited[startX][startY] = true;

        // Initialize the list of walls to consider
        List<Wall> wallList = new ArrayList<>();
        addWallsToList(startX, startY, wallList);

        while (!wallList.isEmpty()) {
            // Randomly choose a wall from the list
            int randomIndex = random.nextInt(wallList.size());
            Wall randomWall = wallList.get(randomIndex);
            wallList.remove(randomIndex);

            int x = randomWall.x;
            int y = randomWall.y;

            // Check if the adjacent cell is unvisited
            int nextX = x + dx(randomWall.direction);
            int nextY = y + dy(randomWall.direction);

            if (!visited[nextX][nextY]) {
                // Carve a passage through the wall
                removeWall(x, y, randomWall.direction);
                visited[nextX][nextY] = true;

                // Add new walls to the list from the newly visited cell
                addWallsToList(nextX, nextY, wallList);
            }
        }

        return new MazeData(mazeParams, walls);
    }

    /**
     * Helper method to add walls from a given cell to the wall list.
     *
     * @param x       The x-coordinate of the cell.
     * @param y       The y-coordinate of the cell.
     * @param wallList The list of walls to consider.
     */
    private void addWallsToList(int x, int y, List<Wall> wallList) {
        for (int direction = 0; direction < 4; direction++) {
            int nextX = x + dx(direction);
            int nextY = y + dy(direction);

            if (nextX >= 0 && nextY >= 0 && nextX < mazeWidth && nextY < mazeHeight && !visited[nextX][nextY]) {
                wallList.add(new Wall(x, y, direction));
            }
        }
    }

    private static class Wall {
        int x;
        int y;
        int direction;

        Wall(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
}

