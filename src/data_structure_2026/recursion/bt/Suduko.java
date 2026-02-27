package data_structure_2026.recursion.bt;

import java.util.Arrays;

public class Suduko {
    private static boolean found = false;
    public static void main(String[] args) {
        for(char c='1';c<='9';c++){
            System.out.println(c);
        }
        int[][] result = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 1, 4, 3, 6, 5, 8, 9, 7},
                {3, 7, 8, 9, 4, 2, 6, 1, 5},
                {9, 6, 5, 8, 1, 7, 2, 3, 4},
                {8, 9, 7, 2, 3, 4, 5, 6, 1},
                {5, 4, 2, 6, 9, 1, 3, 7, 8},
                {6, 3, 1, 5, 7, 8, 9, 4, 2}};

        int[][] grid = new int[][]{
                {0, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 1, 4, 3, 6, 5, 8, 9, 7},
                {3, 7, 8, 9, 4, 2, 6, 1, 5},
                {9, 6, 5, 8, 1, 7, 2, 3, 4},
                {8, 9, 7, 2, 3, 4, 5, 0, 1},
                {5, 4, 2, 6, 9, 1, 3, 7, 8},
                {6, 3, 1, 5, 7, 8, 9, 4, 2}};
        int [][]res= new int[9][9];
//        solve(grid, 0, 0,res);
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (res[i][j]!=result[i][j]){
//                    System.out.println("false");
//                }
//            }
//        }
    }

    private static void solve(int[][] grid, int row, int col,int[][]result) {
        if (row == 9) {
            found=true;
            for (int i = 0; i < 9; i++) {
                System.arraycopy(grid[i], 0, result[i], 0, 9);
                System.out.println(Arrays.toString(grid[i]));
            }
            System.out.println("=================================");
            return;
        }
        if (grid[row][col] == 0) {
            for (int i = 1; i < 10; i++) {
                if (isValid(grid, row, col, i)) {
                    grid[row][col] = i;
                    if (col < 8) {
                        solve(grid, row, col + 1,result);
                    } else {
                        solve(grid, row + 1, 0,result);
                    }
                    grid[row][col] = 0;
                }
            }
        }
        if(!found){
            if (col < 8) {
                solve(grid, row, col + 1,result);
            } else {
                solve(grid, row + 1, 0,result);
            }
        }
    }

    private static boolean isValid(int[][] grid, int row, int col, int num) {

        //row wise up
        int i = row;

        while (i >= 0) {
            if (grid[i][col] == num) {
                return false;
            }
            i -= 1;
        }
        // row wise down
        i = row;

        while (i < grid.length) {
            if (grid[i][col] == num) {
                return false;
            }
            i += 1;
        }

        int j = col; //left
        while (j >= 0) {
            if (grid[row][j] == num) {
                return false;
            }
            j -= 1;
        }

        j = col;//right
        while (j < grid.length) {
            if (grid[row][j] == num) {
                return false;
            }
            j += 1;
        }

        // grid
        int startR = 3 * (row / 3);
        int startC = 3 * (col / 3);
        int endR = startR + 3;
        int endC = startC + 3;

        for (int k = startR; k < endR; k++) {
            for (int m = startC; m < endC; m++) {
                if (grid[k][m] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
