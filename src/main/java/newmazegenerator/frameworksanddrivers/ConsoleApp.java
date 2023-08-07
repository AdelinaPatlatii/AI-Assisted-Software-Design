package newmazegenerator.frameworksanddrivers;

import newmazegenerator.interfaceadapters.MazeControllable;
import newmazegenerator.interfaceadapters.MazeController;
import newmazegenerator.interfaceadapters.MazePrinter;
import newmazegenerator.models.MazeParams;
import newmazegenerator.usecases.MazePublishable;
import newmazegenerator.usecases.PrimAlgorithmStrategy;
import newmazegenerator.usecases.RecursiveBacktrackingStrategy;

import java.util.Scanner;

/**
 * The ConsoleApp class represents the main entry point of the Maze Generator application.
 * It reads input from the user for maze width, height, and cell size, and then generates and prints the maze.
 */
public class ConsoleApp {
    public static final int CELL_SIZE = 1;

    /**
    * The main method to run the Maze Generator application.
    */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int width = readPositiveInt(input, "Enter the maze width: ");
        int height = readPositiveInt(input, "Enter the maze height: ");

        MazeParams mazeParams = new MazeParams(width, height, CELL_SIZE);
        MazePublishable mazePrinter = new MazePrinter();
        MazeControllable mazeController = new MazeController(mazePrinter);

        System.out.println("Maze generated using the Recursive Backtracking algorithm:");
        mazeController.startMazeGeneration(new RecursiveBacktrackingStrategy(mazeParams));

        System.out.println("\nMaze generated using the Prim algorithm:");
        mazeController.startMazeGeneration(new PrimAlgorithmStrategy(mazeParams));
    }

    /**
     * Captures and validates user input.
     */
    private static int readPositiveInt(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                int number = Integer.parseInt(scanner.nextLine());
                if (number <= 0) {
                    System.out.println("Please enter a positive integer.");
                } else return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
