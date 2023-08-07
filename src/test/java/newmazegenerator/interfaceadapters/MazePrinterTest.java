package newmazegenerator.interfaceadapters;

import newmazegenerator.models.MazeData;
import newmazegenerator.models.MazeParams;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MazePrinterTest {

    @Test
    void testPublishMaze_WithEmptyMaze_ShouldPrintEmptyMaze() {
        MazeData mazeData = createEmptyMazeData();

        String expectedOutput = "      \n" +
                "      \n";

        assertMazePrinting(mazeData, expectedOutput);
    }

    @Test
    void testPublishMaze_WithMazeWithWalls_ShouldPrintMazeWithWalls() {
        MazeData mazeData = createMazeDataWithWalls();

        String expectedOutput = "__    \n" +
                "     |\n" +
                "__   |\n" +
                "__|  |\n";

        assertMazePrinting(mazeData, expectedOutput);
    }


    private MazeData createEmptyMazeData() {
        boolean[][][] walls = new boolean[2][2][4];
        MazeParams mazeParams = new MazeParams(2, 2, 1);
        return new MazeData(mazeParams, walls);
    }

    private MazeData createMazeDataWithWalls() {
        boolean[][][] walls = {
                {{true, false, true, false}, {false, false, false, false}, {false, false, true, false}, {false, true, true, false}},
                {{false, false, false, true}, {false, true, false, false}, {false, true, false, false}, {false, true, false, false}}
        };
        MazeParams mazeParams = new MazeParams(2, 4, 1);
        return new MazeData(mazeParams, walls);
    }

    private void assertMazePrinting(MazeData mazeData, String expectedOutput) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        MazePrinter mazePrinter = new MazePrinter();
        mazePrinter.publishMaze(mazeData);

        String actualOutput = outputStream.toString();
        assertEquals(expectedOutput, actualOutput);

        System.setOut(System.out); // Restore the standard output stream
    }
}
