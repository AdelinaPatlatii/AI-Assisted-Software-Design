package newmazegenerator.usecases;

import newmazegenerator.models.MazeData;

/**
 * The MazeGenerator class implements the MazeGeneratable interface and is responsible for generating mazes.
 * It uses a strategy pattern to allow different maze generation algorithms to be used.
 */
public class MazeGenerator implements MazeGeneratable {
    private final MazePublishable mazePrinter;
    private MazeGeneratorStrategy mazeGeneratorStrategy;

    /**
     * Constructor to initialize the maze generator with the given MazePublishable.
     *
     * @param mazePrinter The MazePublishable used to print or publish the generated maze.
     */
    public MazeGenerator(MazePublishable mazePrinter) {
        this.mazePrinter = mazePrinter;
    }

    /**
     * Set the maze generation strategy to be used by the generator.
     *
     * @param mazeGeneratorStrategy The strategy to generate the maze.
     */
    public void setMazeGeneratorStrategy(MazeGeneratorStrategy mazeGeneratorStrategy) {
        this.mazeGeneratorStrategy = mazeGeneratorStrategy;
    }

    /**
     * Generate the maze using the selected maze generation strategy.
     * Notifies the presenter (MazePrinter) once the maze is ready.
     */
    @Override
    public void generateMaze() {
        if (mazeGeneratorStrategy == null) {
            throw new RuntimeException("Cannot generate maze without a strategy.");
        } else {
            MazeData mazeData = mazeGeneratorStrategy.generateMaze();
            notifyMazeReady(mazeData);
        }
    }

    /**
     * Notify the presenter (MazePrinter) that the maze is ready to be published.
     *
     * @param mazeData The MazeData object containing MazeParams and the generated maze walls.
     */
    private void notifyMazeReady(MazeData mazeData) {
        if (mazePrinter != null) {
            mazePrinter.publishMaze(mazeData);
        }
    }
}
