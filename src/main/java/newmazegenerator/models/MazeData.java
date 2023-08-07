package newmazegenerator.models;

/**
 * The MazeData class represents the data of a generated maze.
 * It holds the MazeParams and the maze walls information.
 */
public class MazeData {
    private MazeParams mazeParams;
    private boolean[][][] walls;

    /**
     * Constructor to initialize the MazeData with MazeParams and maze walls.
     *
     * @param mazeParams The MazeParams object representing the maze dimensions and cell size.
     * @param walls      The boolean array representing the walls of the maze.
     */
    public MazeData(MazeParams mazeParams, boolean[][][] walls) {
        this.mazeParams = mazeParams;
        this.walls = walls;
    }

    /**
     * Get the MazeParams of the maze.
     *
     * @return The MazeParams object containing the width, height, and cell size of the maze.
     */
    public MazeParams getMazeParams() {
        return mazeParams;
    }

    /**
     * Get the walls data of the maze.
     *
     * @return The 3D boolean array representing the walls of the maze.
     */
    public boolean[][][] getWalls() {
        return walls;
    }
}
