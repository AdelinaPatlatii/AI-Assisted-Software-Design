README: Maze Generator Application

**Summary:**
The Maze Generator Application is a Java program that allows users to generate mazes of various sizes using different maze generation algorithms. The application provides a command-line interface for users to input the width and height of the maze they want to generate. It then uses two different maze generation strategies, Recursive Backtracking and Prim's Algorithm, to generate the maze. The generated maze is printed to the console for the user to view.

The program was built using SDK version 11.0.1. The frameworks used for testing the program: junit 4.13.2, jupiter 5.10.0, and mockito 2.22.0.

**Use Cases:**
1. **Generate Maze:** The user can generate a maze, based on the provided height and width, using either Recursive Backtracking or Prim's Algorithm.
2. **Print Maze:** The generated maze is printed to the console so the user can visualize it.

**User Stories:**
1. As a user, I want to generate a maze of a specific width and height using either Recursive Backtracking or Prim's Algorithm. 
2. As a user, I want to see the generated maze printed to the console for visualization.

**Design Patterns:**
1. **Iterator Pattern:** The `MazeIterator` class is implemented using the Iterator pattern. It allows for iterating over the cells of the maze to print them in a user-friendly format.

2. **Observer Pattern:** The `MazeGenerator` class implements the Observer pattern. It observes the maze generation process and notifies the `MazePrinter` once the maze is ready to be published.

3. **Strategy Pattern:** The `MazeGeneratorStrategy` interface and its implementations (`RecursiveBacktrackingStrategy` and `PrimAlgorithmStrategy`) follow the Strategy pattern. They allow the application to use different maze generation algorithms interchangeably.

**SOLID/Clean Architecture Violations:**
The code follows the SOLID and Clean Architecture principles. The responsibilities are well-separated, and the application uses dependency injection to decouple components. 

A further improvement could be extracting the reading of user inputs from the console into a separate class, to better conform to the Single Responsibility Principle.

**Remaining Code Smells:**
Most of the code smells are eliminated. The code could potentially benefit from the following improvement:

**Exception Handling:** The exception handling in `ConsoleApp` should be improved to provide more informative error messages to the user in case of invalid input.
