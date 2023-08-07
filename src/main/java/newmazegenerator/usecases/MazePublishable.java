package newmazegenerator.usecases;

import newmazegenerator.models.MazeData;

/**
 * The MazePublishable interface represents the ability to publish the maze.
 * Classes implementing this interface will define how the maze is published (e.g., printing to the console).
 */
public interface MazePublishable {
    /**
     * Publishes the maze based on the provided MazeData.
     *
     * @param mazeData The MazeData object containing the maze parameters and walls.
     */
    void publishMaze(MazeData mazeData);
}

