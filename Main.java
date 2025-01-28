//human to human interaction tic tac toe game build

package com.dsa.problemsolving;

import java.util.Scanner;

class TicTacToe {
    static char[][] board;
    public TicTacToe() {
        board = new char[3][3];
        initializeBoard(board);
    }
    void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void displayBoard() {
        System.out.println ("-------------");
        for (int i = 0; i < board.length; i++){
            System.out.print ("| ");
            for (int j = 0; j < board.length; j++) {
                System.out.print (board[i][j] + " | ");
            }
            System.out.println ();
            System.out.println ("-------------");
        }
    }

    static void placeMark(int row, int col, char mark) {
            if(row >= 0 && row <= 2 && col >= 0 && col <= 2){
                board[row][col] = mark;
            }
            else
                System.out.println ("Invalid position");
    }

    static boolean rowWiseWin() {
        for (int i = 0; i <= 2; i++) {
            if(board[i][0] != ' ' && board[i][0]==board[i][1] && board[i][1] == board[i][2])
                return true;
        }
        return false;
    }
    static boolean colWiseWin() {
        for (int i = 0; i <= 2; i++) {
            if(board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return true;
        }
        return false;
    }
    static boolean digWiseWin() {
        if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2] != ' ' &&
                board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;
        else
            return false;
    }
}

class HumanPlayer {
    String name;
    char mark;

    public HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makeMove() {
        Scanner sc = new Scanner (System.in);
        int row, col;

        do {
            System.out.println ("Enter row and col : ");
            row = sc.nextInt ();
            col = sc.nextInt ();
        } while(!isValidMove (row,col));

        TicTacToe.placeMark (row,col,mark);

    }
    boolean isValidMove(int row, int col) {
        if(row >= 0 && row <= 2 && col >= 0 && col <= 2){
            if(TicTacToe.board[row][col] == ' ')
                return true;
        }
        return false;
    }
}


public class Main {
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe ();

        HumanPlayer h1 =  new HumanPlayer ("Vignesh",'x');
        HumanPlayer h2 =  new HumanPlayer ("Suresh",'o');

        HumanPlayer cp = h1;

        while(true) {
            System.out.println (cp.name + " your turn : ");
            cp.makeMove ();
            TicTacToe.displayBoard();

            if (TicTacToe.rowWiseWin () || TicTacToe.colWiseWin () || TicTacToe.digWiseWin ()) {
                System.out.println (cp.name + " has won");
                break;
            } else {
                if (cp == h1)
                    cp = h2;
                else
                    cp = h1;
            }
        }
    }
}
