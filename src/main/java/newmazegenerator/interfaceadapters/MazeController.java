package newmazegenerator.interfaceadapters;

import newmazegenerator.usecases.MazeGeneratable;
import newmazegenerator.usecases.MazeGenerator;
import newmazegenerator.usecases.MazePublishable;
import newmazegenerator.usecases.MazeGeneratorStrategy;

/**
 * The MazeController class is responsible for controlling the maze generation process.
 * It implements the MazeControllable interface, providing a method to start the maze generation
 * using the specified MazeGeneratorStrategy and MazePublishable.
 */
public class MazeController implements MazeControllable {
    private final MazePublishable mazePublisher;

    /**
     * Constructs a MazeController instance with the provided MazePublishable implementation.
     *
     * @param mazePublisher The MazePublishable object responsible for publishing the generated maze.
     */
    public MazeController(MazePublishable mazePublisher) {
        this.mazePublisher = mazePublisher;
    }

    /**
     * Starts the maze generation process using the given MazeGeneratorStrategy.
     *
     * @param mazeGeneratorStrategy The MazeGeneratorStrategy implementation that defines the maze generation algorithm.
     */
    @Override
    public void startMazeGeneration(MazeGeneratorStrategy mazeGeneratorStrategy) {
        MazeGeneratable mazeGenerator = new MazeGenerator(mazePublisher);
        mazeGenerator.setMazeGeneratorStrategy(mazeGeneratorStrategy);
        mazeGenerator.generateMaze();
    }
}

