package newmazegenerator.usecases;

/**
 * The MazeGeneratable interface represents the ability to generate mazes.
 * Classes implementing this interface will define how mazes are generated.
 */
public interface MazeGeneratable {
    /**
     * Generate the maze.
     */
    void generateMaze();

    /**
     * Set the maze generation strategy to be used.
     *
     * @param mazeGeneratorStrategy The strategy to generate the maze.
     */
    void setMazeGeneratorStrategy(MazeGeneratorStrategy mazeGeneratorStrategy);
}

