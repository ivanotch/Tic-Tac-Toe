import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '_';
            }
        }

        int gameOn = 0;
        while (gameOn == 0) {
            if (!getState(board).equals("O wins")) {
                xPlayerMove(board);
                System.out.println(printedBoard(board));
            }
            if (getState(board).equals("Game not finished")) {
                oPlayerMove(board);
                System.out.println(printedBoard(board));
            } else if (getState(board).equals("Draw")) {
                System.out.println(getState(board));
                gameOn++;
            } else  if (getState(board).equals("X wins")) {
                System.out.println(getState(board));
                gameOn++;
            } else if (getState(board).equals("Impossible")) {
                System.out.println(getState(board));
                gameOn++;
            } else if (getState(board).equals("O wins")) {
                System.out.println(getState(board));
                gameOn++;
            }
        }
    }

    public static void xPlayerMove(char[][] board) {
        Scanner input = new Scanner(System.in);
        int validMove = 0;
        while (validMove == 0) {
            System.out.println("Enter the coordinates: ");
            try {
                int x = input.nextInt() - 1;
                int y = input.nextInt() - 1;
                if (x > 2 || y > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[x][y] != '_' && board[x][y] == 'X' || board[x][y] == 'O') {
                    System.out.println("This cell is occupied! please choose another one!");
                } else {
                    board[x][y] = 'X';
                    validMove += 1;
                }
            } catch (Exception NumberFormatException) {
                System.out.println("You should enter numbers!");
                input.nextLine();
            }

        }
    }

    public static void oPlayerMove(char[][] board) {
        Scanner input = new Scanner(System.in);
        int validMove = 0;
        while (validMove == 0) {
            System.out.println("Enter the coordinates: ");
            try {
                int x = input.nextInt() - 1;
                int y = input.nextInt() - 1;
                if (x > 2 || y > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[x][y] != '_' && board[x][y] == 'X' || board[x][y] == 'O') {
                    System.out.println("This cell is occupied! please choose another one!");
                } else {
                    board[x][y] = 'O';
                    validMove += 1;
                }
            } catch (Exception NumberFormatException) {
                System.out.println("You should enter numbers!");
                input.nextLine();
            }

        }
    }

    private static String printedBoard(char[][] board) {
        String printedBoard = "---------\n| " + board[0][0] + " " + board[0][1] + " " + board[0][2] +
                " |\n| " + board[1][0] + " " + board[1][1] + " " + board[1][2] +
                " |\n| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |\n" + "---------";
        return printedBoard;
    }

    public static String getState(char[][] board) {
        int totalX = 0;
        int totalO = 0;
        for (char[] symbol : board) {
            for (int j : symbol) {
                if (j == 'X') {
                    totalX++;
                } else if (j == 'O') {
                    totalO++;
                }
            }
        }
        boolean xWon = isSymbolWon(board, 'X');
        boolean oWon = isSymbolWon(board, 'O');
        if (xWon) {
            return "X wins";
        }
        if (oWon) {
            return "O wins";
        }
        if (totalO + totalX == 9) {
            return "Draw";
        }
        return "Game not finished";
    }

    private static  boolean isSymbolWon(char[][] board, char symbol) {
        return  board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol
                || board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol
                || board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol
                || board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol
                || board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol
                || board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol
                || board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol
                || board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol;
    }


}
