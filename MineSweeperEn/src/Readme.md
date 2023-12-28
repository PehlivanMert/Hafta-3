# MineSweeper Game

This project involves the implementation of the classic MineSweeper game. The game prompts the user to input the dimensions of the game board, randomly places mines, and then accepts player moves. As the game progresses, the player opens cells, and at the end of the game, it checks whether the player has won or lost. 🎮

## Class: MineSweeper

### Fields
- `mines`: Matrix to hold mines.
- `displayedMap`: Matrix for the map displayed to the player.
- `totalMines`: Total number of mines.

### Constructor
- `public MineSweeper()`: Constructor method that initializes instances of the class and assigns initial values.

### Methods
- `public void run()`: Method to start the game. It takes input for the game board dimensions, creates and places mines, and initializes the game board. It accepts player moves and checks the game's status. When the game ends, it asks the user if they want to play again.

- `private void createMines(int numRows, int numCols)`: Method to create the matrix to hold mines. It initializes the matrix with "0" values.

- `private void createDisplayedMap(int numRows, int numCols)`: Method to create the map displayed to the player. It initializes the matrix with "-" values.

- `private void playGame(int numRows, int numCols)`: Method to play the game. It accepts player moves, opens cells, and checks the game's status.

- `private void showDisplayedMap()`: Method to show the displayed map to the player.

- `private boolean isValidMove(int row, int col, int numRows, int numCols)`: Method to check if the move is valid.

- `private void placeMines(int numMines)`: Method to randomly place the mines.

- `private void endGameStatus()`: Method to show the end status of the game. It updates the map at the end of the game, revealing all mines.

