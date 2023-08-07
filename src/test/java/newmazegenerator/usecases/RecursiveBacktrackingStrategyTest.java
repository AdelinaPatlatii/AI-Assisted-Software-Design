package newmazegenerator.usecases;

import newmazegenerator.models.MazeData;
import newmazegenerator.models.MazeParams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveBacktrackingStrategyTest {

    private RecursiveBacktrackingStrategy recursiveBacktrackingStrategy;
    private MazeParams mazeParams;

    @BeforeEach
    void setUp() {
        // Set up maze parameters with width 10, height 10, and cell size 1
        mazeParams = new MazeParams(10, 10, 1);
        recursiveBacktrackingStrategy = new RecursiveBacktrackingStrategy(mazeParams);
    }

    @Test
    void testGenerateMaze() {
        MazeData mazeData = recursiveBacktrackingStrategy.generateMaze();

        // Check that the maze data is not null
        assertNotNull(mazeData);

        // Check that the maze data contains the correct maze parameters
        assertEquals(mazeParams, mazeData.getMazeParams());

        // Check that the maze data contains walls with the correct dimensions
        boolean[][][] walls = mazeData.getWalls();
        assertEquals(10, walls.length);
        assertEquals(10, walls[0].length);

        // Check that the maze data contains valid starting and ending cells
        assertFalse(walls[0][0][0]);
        assertFalse(walls[9][9][1]);
        assertFalse(walls[9][9][2]);

    }
}
