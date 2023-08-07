package newmazegenerator.interfaceadapters;

import newmazegenerator.models.MazeData;
import newmazegenerator.usecases.MazePublishable;

/**
 * The MazePrinter class implements the MazePublishable interface and is responsible for printing the maze.
 * It receives a MazeData object containing maze parameters and walls and prints the maze to the console.
 */
public class MazePrinter implements MazePublishable {
    /**
     * Publishes the maze by printing it to the console.
     *
     * @param mazeData The MazeData object containing the maze parameters and walls.
     */
    @Override
    public void publishMaze(MazeData mazeData) {
        int mazeWidth = mazeData.getMazeParams().getWidth();
        int mazeHeight = mazeData.getMazeParams().getHeight();
        boolean[][][] walls = mazeData.getWalls();

        MazeIterator mazeIterator = new MazeIterator(walls, mazeWidth, mazeHeight);
        while (mazeIterator.hasNext()) {
            boolean isBottomWall = mazeIterator.isWall(2);
            boolean isRightWall = mazeIterator.isWall(1);

            if (isBottomWall) System.out.print("__");
            else System.out.print("  ");

            if (isRightWall) System.out.print("|");
            else System.out.print(" ");

            mazeIterator.next();

            if (mazeIterator.getX() == 0) System.out.println();
        }
    }
}
