package Tic_Tac;

import java.util.Scanner;

public class tic_tac_toe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        char currentPlayer = 'x';
        Scanner sc = new Scanner(System.in);

        while (true) {
            PrintBoard(board);
            System.out.println("Enter move for player '" + currentPlayer + "' (row and column): ");

            int row, col;

            // Input validation loop
            while (true) {
                row = sc.nextInt();
                col = sc.nextInt();

                if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                    System.out.println("Invalid position! Try again:");
                } else if (board[row][col] != ' ') {
                    System.out.println("Cell already filled! Try again:");
                } else {
                    break;
                }
            }

            board[row][col] = currentPlayer;

            if (isWin(board, currentPlayer)) {
                PrintBoard(board);
                System.out.println("Player '" + currentPlayer + "' has won!");
                break;
            }

            if (isDraw(board)) {
                PrintBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            // Switch players
            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }
    }

    private static void PrintBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < board[i].length - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < board.length - 1) System.out.println("--+---+--");
        }
    }

    private static boolean isWin(char[][] board, char player) {
        // Rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Diagonals
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean isDraw(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }
}
