package H_BackTracking;

//solve sudoku
public class E_Sudoku {
    // print sudoku
    public static void printSudoku(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] arr, int i, int j, int k) {
        // check if it is already given number
        // check in the row
        for (int p = 0; p < arr.length; p++) {
            if (arr[i][p] == k) {
                return false;
            }
        }
        // check in column
        for (int q = 0; q < arr.length; q++) {
            if (arr[q][j] == k) {
                return false;
            }
        }
        // check in the box
        // finding the box's first coordinate
        int m = (i / 3) * 3;
        int n = (j / 3) * 3;
        for (int p = m; p < m + 3; p++) {
            for (int q = n; q < n + 3; q++) {
                if (arr[p][q] == k)
                    return false;
            }
        }
        return true;
    }

    public static boolean solveSudoku(int[][] arr, int i, int j) {
        // base condition
        // if 9x9 has complted return true;
        if (i == 9) {
            return true;
        }
        // if the current row is complted move to next one
        if (j == 9) {
            return solveSudoku(arr, i + 1, 0);
        }
        // if the value already given move to next one
        if (arr[i][j] != 0) {
            return solveSudoku(arr, i, j + 1);
        }
        // after selecting the block try values frm 1 to 9
        for (int k = 1; k <= 9; k++) {
            // check if it is safe to place k?
            if (isSafe(arr, i, j, k)) {
                arr[i][j] = k;
                // after placing it move to next place
                if (solveSudoku(arr, i, j + 1)) {
                    return true;
                }
                // if our decision was bad we come back here
                // and we change our decision
                arr[i][j] = 0;
            }
        }
        // i.e no k value can fit in this current arrangement so please try some other
        return false;
    }

    public static void main(String[] args) {
        int sudoku[][] = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };
        if (solveSudoku(sudoku, 0, 0)) {
            printSudoku(sudoku);
        } else {
            System.out.println("solution not exists");
        }
    }
}
