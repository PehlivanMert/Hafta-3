import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    private String[][] mines; // Matrix to hold mines
    private String[][] displayedMap; // Matrix for the map displayed to the player
    private int totalMines; // Total number of mines

    // Constructor method
    public MineSweeper() {
        this.mines = null;
        this.displayedMap = null;
        this.totalMines = 0;
    }

    // Method to start the game
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the number of rows in the minefield: ");
            int numRows = scanner.nextInt();

            System.out.print("Enter the number of columns in the minefield: ");
            int numCols = scanner.nextInt();

            if (numRows < 2 || numCols < 2) {
                System.out.println("Invalid input! The number of rows and columns must be at least 2.");
                continue;
            }

            createMines(numRows, numCols);

            placeMines((numRows * numCols) / 4);

            createDisplayedMap(numRows, numCols);
            System.out.println("Welcome to the Minesweeper Game!");

            playGame(numRows, numCols);

            showDisplayedMap();

            System.out.print("Do you want to play again? (Enter 'y' or 'Y' for Yes, any other key for No): ");
            char response = scanner.next().charAt(0);

            if (response != 'y' && response != 'Y') {
                break;
            }
        }

        System.out.println("You have closed the game. Have a nice day!");
    }

    // Method to create the matrix to hold mines
    private void createMines(int numRows, int numCols) {
        mines = new String[numRows][numCols];
        totalMines = 0;

        // Initialize the matrix with "0" values
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                mines[i][j] = "0";
            }
        }
    }

    // Method to create the map displayed to the player
    private void createDisplayedMap(int numRows, int numCols) {
        displayedMap = new String[numRows][numCols];

        // Initialize the matrix with "-" values
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                displayedMap[i][j] = "-";
            }
        }
    }

    // Method to play the game
    private void playGame(int numRows, int numCols) {
        Scanner input = new Scanner(System.in);
        boolean gameInProgress = true;

        while (gameInProgress) {
            showDisplayedMap();

            System.out.print("Enter the row: ");
            int row = input.nextInt();

            System.out.print("Enter the column: ");
            int col = input.nextInt();

            if (!isValidMove(row, col, numRows, numCols)) {
                System.out.println("Invalid coordinates! Please enter coordinates within the boundaries.");
                continue;
            }

            if (mines[row][col].equals("*")) {
                System.out.println("===================");
                System.out.println("You lost the game!");
                gameInProgress = false;
            } else {
                int mineCount = 0;

                // Check surrounding cells and calculate the number of mines
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int newRow = row + i;
                        int newCol = col + j;

                        if (isValidMove(newRow, newCol, numRows, numCols)) {
                            if (mines[newRow][newCol].equals("*")) {
                                mineCount++;
                            }
                        }
                    }
                }

                // Update the relevant cell on the displayed map and increment the total mine count
                displayedMap[row][col] = String.valueOf(mineCount);
                totalMines++;

                // Check if the player has won the game
                if (totalMines == (numRows * numCols) - (numRows * numCols) / 4) {
                    System.out.println("===================");
                    System.out.println("Congratulations! You won the game!");
                    gameInProgress = false;
                }
            }
        }

        endGameStatus();
    }

    // Method to show the displayed map to the player
    private void showDisplayedMap() {
        System.out.println("===================");
        for (String[] row : displayedMap) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println("===================");
    }

    // Method to check if the move is valid
    private boolean isValidMove(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols && displayedMap[row][col].equals("-");
    }

    // Method to randomly place the mines
    private void placeMines(int numMines) {
        Random random = new Random();

        int numRows = mines.length;
        int numCols = mines[0].length;

        for (int i = 0; i < numMines; i++) {
            int row = random.nextInt(numRows);
            int col = random.nextInt(numCols);

            // If there is already a mine in the selected cell, choose a different cell
            while (mines[row][col].equals("*")) {
                row = random.nextInt(numRows);
                col = random.nextInt(numCols);
            }

            mines[row][col] = "*";
        }
    }

    // Method to show the end status of the game
    private void endGameStatus() {
        // Update the map at the end of the game, reveal all mines
        for (int i = 0; i < mines.length; i++) {
            for (int j = 0; j < mines[0].length; j++) {
                if (mines[i][j].equals("*")) {
                    displayedMap[i][j] = "*"; // Show the mine
                } else if (!displayedMap[i][j].equals("F")) { // For cells that are not flagged and not opened yet, set to "-"
                    displayedMap[i][j] = "-";
                }
            }
        }
    }
}
