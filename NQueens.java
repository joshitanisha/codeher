import java.util.Scanner;

public class NQueens {

    // Display the chessboard
    static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        
    }

    // Check whether placing a queen is safe
    static boolean isSafe(int[][] board, int row, int col, int n) {

        // Check same column in previous rows
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper-left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        // Check upper-right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {
            if (board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    // Solve N-Queens using backtracking
    static boolean solveNQueens(int[][] board, int row, int n) {

        // All queens are placed
        if (row == n) {
            return true;
        }

        // Try every column
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                // Place queen
                board[row][col] = 1;

                // Move to next row
                if (solveNQueens(board, row + 1, n)) {
                    return true;
                }

                // Backtrack
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input!");
            sc.close();
            return;
        }

        int[][] board = new int[n][n];

        System.out.println("Enter position of first queen:");

        System.out.print("Row (1 to N): ");
        int r = sc.nextInt() - 1;

        System.out.print("Column (1 to N): ");
        int c = sc.nextInt() - 1;

        // Validate position
        if (r < 0 || r >= n || c < 0 || c >= n) {
            System.out.println("Invalid position!");
        } else {

            // Place first queen
            board[r][c] = 1;

            // Check first queen and solve
            if (solveNQueens(board, r + 1, n)) {
                System.out.println("\nSolution:");
                printBoard(board, n);
            } else {
                System.out.println("No solution exists for this position.");
            }
        }

        sc.close();
    }
}