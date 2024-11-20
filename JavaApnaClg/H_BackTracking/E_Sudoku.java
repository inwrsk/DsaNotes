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

    public static int solveSudoku(int[][] arr, int i, int j) {
        // base condition
        if (i == 8 && j == 9) {
            return 1;
        }
        if (j == 9) {
            return solveSudoku(arr, i + 1, 0);
        }
        if (arr[i][j] != 0)
            return solveSudoku(arr, i, j + 1);
        for (int k = 1; k <= 9; k++) {
            if (isSafe(arr, i, j, k)) {
                arr[i][j] = k;
                if (solveSudoku(arr, i, j + 1) == 1) {
                    return 1;
                }
                arr[i][j] = 0;
            }
        }
        return 0;
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
        if (solveSudoku(sudoku, 0, 0) == 0) {
            System.out.println("solution not exists");
        } else {
            printSudoku(sudoku);
        }
    }
}
