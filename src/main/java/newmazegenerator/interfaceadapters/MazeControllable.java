package newmazegenerator.interfaceadapters;

import newmazegenerator.usecases.MazeGeneratorStrategy;

/**
 * The MazeControllable interface defines the contract for classes that control the maze generation process.
 * Classes implementing this interface will provide a method to start the maze generation using a specific strategy.
 */
public interface MazeControllable {
    /**
     * Starts the maze generation process using the specified MazeGeneratorStrategy.
     *
     * @param mazeGeneratorStrategy The MazeGeneratorStrategy implementation that defines the maze generation algorithm.
     */
    void startMazeGeneration(MazeGeneratorStrategy mazeGeneratorStrategy);
}

