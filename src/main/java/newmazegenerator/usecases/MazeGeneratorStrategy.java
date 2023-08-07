package newmazegenerator.usecases;

import newmazegenerator.models.MazeData;

/**
 * The MazeGeneratorStrategy interface represents a strategy for generating a maze.
 * Classes implementing this interface will provide specific algorithms for maze generation.
 */
public interface MazeGeneratorStrategy {

    /**
     * Generates a maze using the specific algorithm implemented by the implementing class.
     *
     * @return The MazeData object containing the generated maze walls and maze parameters.
     */
    MazeData generateMaze();
}


