package H_BackTracking;

//place one queen in each row of the board such that no two queens can hit another
//start with main

public class C_NQueens {
    // check north, northeast, northwest for any current attacks
    // no need to check below as filling is from the top and current queen is the
    // last at this moment
    static Boolean isSafe(Character board[][], Integer row, Integer col) {
        // checking top
        for (Integer i = 0; i < row; i++) {
            if (board[i][col].equals('Q')) {
                return false;
            }
        }
        // left upper diagonal
        for (Integer i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals('Q'))
                return false;
        }
        // right upper diagonal
        for (Integer i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j].equals('Q')){
                return false;
            }
	}
            return true;
    }


    // function to find and a good position in a particular row to queen
    static Integer placeInRow(Character charboard[][], Integer row, Integer possibilities) {
        // if the rows are filled up print the board, increment the no of possibilties and return;
        if (row.equals(charboard.length)) {
            printBoard(charboard);
            possibilities++;
            return possibilities;
        }
        Integer n = charboard[0].length;
        // iterate over every block on the row
        for (Integer i = 0; i < n; i++) {
            if (isSafe(charboard, row, i)) {
                charboard[row][i] = 'Q';
                // after placing the queen in a safe place
                // check the possiblities in the remaining rows
                // if there is a possibility then it increments possibilities
                // else it returns the same
                possibilities = placeInRow(charboard, row + 1, possibilities);
                // after the check is over remove the queen from there and get ready for placing
                // the queen in next box
                charboard[row][i] = 'X';
            }
        }
        // after completion of checking every possibility return nof possibilities
        return possibilities;
    }

    // no of possibilites can also be counted by declaring a static variable in the
    // class
    // static Integer possibilities = 0;
    static void placeQueens(Character board[][]) {
        // start with first row
        System.out.println("----Possibilities----\n" + placeInRow(board, 0, 0));
    }

    // function to print board
    public static void printBoard(Character board[][]) {
        Integer n = board.length;
        System.out.println("-----Chess Board-----");
        for (Integer i = 0; i < n; i++) {
            for (Integer j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer n = 4;
        Character board[][] = new Character[n][n];
        // initializing the board
        for (Integer i = 0; i < n; i++) {
            for (Integer j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        // give the board to the function
        placeQueens(board);
    }
}


// Output : 
/*

-----Chess Board-----
X Q X X 
X X X Q 
Q X X X 
X X Q X 
-----Chess Board-----
X X Q X 
Q X X X 
X X X Q 
X Q X X 
----Possibilities----
2




*/
