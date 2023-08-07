package newmazegenerator.usecases;

import newmazegenerator.interfaceadapters.MazePrinter;
import newmazegenerator.models.MazeData;
import newmazegenerator.models.MazeParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class MazeGeneratorTest {

    private MazeGenerator mazeGenerator;
    private MazePublishable mazePrinter;
    private MazeGeneratorStrategy mazeGeneratorStrategy;

    @BeforeEach
    void setUp() {
        // Create a mock instance of MazePublishable
        mazePrinter = mock(MazePublishable.class);

        // Create a mock instance of MazeGeneratorStrategy
        mazeGeneratorStrategy = mock(MazeGeneratorStrategy.class);

        mazeGenerator = new MazeGenerator(mazePrinter);
    }

    void setUp1() {
        // Create a mock instance of MazePublishable
        mazePrinter = new MazePrinter();

        // Create a mock instance of MazeGeneratorStrategy
        MazeParams mazeParams = new MazeParams(10, 10, 1);
        mazeGeneratorStrategy = new RecursiveBacktrackingStrategy(mazeParams);

        mazeGenerator = new MazeGenerator(mazePrinter);
    }

    @Test
    void testGenerateMaze_WithValidStrategy_ShouldNotifyMazeReady() {
        // Prepare a mock MazeData
        MazeParams mazeParams = new MazeParams(10, 10, 1);
        boolean[][][] walls = new boolean[10][10][4];
        MazeData mockMazeData = new MazeData(mazeParams, walls);

        // Set up mock MazeGeneratorStrategy to return the mock MazeData
        when(mazeGeneratorStrategy.generateMaze()).thenReturn(mockMazeData);

        // Call the method to be tested
        mazeGenerator.setMazeGeneratorStrategy(mazeGeneratorStrategy);
        mazeGenerator.generateMaze();

        // Verify that the MazeGeneratorStrategy's generateMaze() method was called
        verify(mazeGeneratorStrategy, times(1)).generateMaze();

        // Verify that the MazePublishable's publishMaze() method was called
        verify(mazePrinter, times(1)).publishMaze(mockMazeData);
    }

    @Test
    void testGenerateMaze_WithNullStrategy_ShouldNotNotifyMazeReady() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            mazeGenerator.generateMaze();});

        Assertions.assertTrue(exception.getMessage().contains("Cannot generate maze without a strategy."));


        // Verify that the MazeGeneratorStrategy's generateMaze() method was not called
        verify(mazeGeneratorStrategy, never()).generateMaze();

        // Verify that the MazePublishable's publishMaze() method was not called
        verify(mazePrinter, never()).publishMaze(any());
    }
}
