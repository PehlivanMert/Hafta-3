# Java Minesweeper Game 🚩

Welcome! This is a simple Minesweeper game in Java. Determine the size of the minefield and the number of mines, then try to uncover all empty cells without detonating the mines! 💣💥

## How to Play? 🎮

1. **Run the Program:** Compile and run the `MineSweeper.java` file using a terminal or an IDE.

2. **Start the Game:** Specify the number of rows and columns to set the dimensions of the game board.

3. **Find the Mines:** Navigate through randomly placed mines, trying to uncover all empty cells.

4. **Be Careful:** If a cell contains a mine, you lose! However, you can't win the game without uncovering all empty cells. 😱

5. **Play Again:** Whether you win or lose, there's always an option to play the game again! 🔄

## Controls 🎯

- Use your keyboard to enter the number of rows and columns.
- Each cell in the minefield may contain a mine or be empty.
- Try to win the game by uncovering empty cells carefully.

## How to Run? 🚀

1. Install the Java SDK and a compiler.
2. Save the `MineSweeper.java` file as a Java file.
3. Compile the file using a terminal or an IDE: `javac MineSweeper.java`
4. After compilation, start the program: `MineSweeper.run()`

## Example Game 🌈

Below is a simple example demonstrating how the game is played:

```plaintext
Enter the number of rows in the minefield: 5
Enter the number of columns in the minefield: 5

---------------
- - - - - 
- - - - - 
- - - - - 
- - - - - 
- - - - - 
----------------

Enter the row: 0
Enter the column: 2

---------------
- - 1 - - 
- - 💥 - - 
- - - - - 
- - - - - 
- - - - - 
----------------

Enter the row: 2
Enter the column: 2

---------------
- - 1 - - 
- - 💥 - - 
- - 💥 - - 
- - 💥 - - 
- - - - - 
----------------
===================

You lost the game! All mines exploded! 💣💥

Have Fun! 🌟
