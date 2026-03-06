package com.example.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            printBoard();

            System.out.println("Player " + currentPlayer + " enter row and column (0-2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;

                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (isBoardFull()) {
                    printBoard();
                    System.out.println("Game Draw!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

            } else {
                System.out.println("Cell already occupied. Try again.");
            }
        }

        sc.close();
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static boolean checkWin() {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer)
                return true;

            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer)
                return true;
        }

        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer)
            return true;

        return false;
    }

    static boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ')
                    return false;
            }
        }
        return true;
    }
}
