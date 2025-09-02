package H_BackTracking;

//place one queen in each row of the board such that no two queens can hit another
//start with main
public class C_NQueens {
    // check north, northeast, northwest for any current attacks
    // no need to check below as filling is from the top and current queen is the
    // last at this moment
    static boolean isSafe(char board[][], int row, int col) {
        // checking top
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // left upper diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        // right upper diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    // function to find and a good position in a particular row to queen
    static int placeInRow(char charboard[][], int row, int ntimes) {
        // if the rows are filled up print the board, increment the no of possibilties
        // and return;
        if (row == charboard.length) {
            printBoard(charboard);
            ntimes++;
            return ntimes;
        }
        int n = charboard[0].length;
        // iterate over every block on the row
        for (int i = 0; i < n; i++) {
            if (isSafe(charboard, row, i)) {
                charboard[row][i] = 'Q';
                // after placing the queen in a safe place
                // check the possiblities in the remaining rows
                // if there is a possibility then it increments ntimes
                // else it returns the same
                ntimes = placeInRow(charboard, row + 1, ntimes);
                // after the check is over remove the queen from there and get ready for placing
                // the queen in next box
                charboard[row][i] = 'X';
            }
        }
        // after completion of checking every possibility return nof possibilities
        return ntimes;
    }

    // no of possibilites can also be counted by declaring a static variable in the
    // class
    // static int ntimes = 0;
    static void placeQueens(char board[][]) {
        // start with first row
        System.out.println("----Possibilities----\n" + placeInRow(board, 0, 0));
    }

    // function to print board
    public static void printBoard(char board[][]) {
        int n = board.length;
        System.out.println("-----Chess Board-----");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        char board[][] = new char[n][n];
        // initializing the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        // give the board to the function
        placeQueens(board);
    }
}