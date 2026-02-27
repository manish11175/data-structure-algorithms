package data_structure_2026.recursion.bt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class NQueens {
    public static void main(String[] args) {
         int n=3;
         int[][]board= new int[n][n];
         List<Integer> res = new ArrayList<>();
         List<List<Integer>> res2= new ArrayList<>();
         solve(n,res,0,board,res2);
         System.out.println(res2);
    }

    private static void solve(int n, List<Integer> res, int col,int[][]board,List<List<Integer>> res2){
        if(col==n || res.size()==n){
            res2.add(new ArrayList<>(res));
            return;
        }
        for(int  row=0;row<n;row++){
            if(isSafe(board,row,col)){
                res.add(row+1);
                board[row][col]=1;
                solve(n,res,col+1,board,res2);
                board[row][col]=0;
                res.remove(res.size()-1);
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int j = col;
        //left
        while(j>=0){
            if(board[row][j]==1){
                return false;
            }
            j-=1;
        }

        //left corner
        int i = row-1;
        j=col-1;
        while(i>=0 && j>=0){
            if(board[i][j]==1){
                return false;
            }
            i-=1;
            j-=1;
        }

        i=row+1;
        j=col-1;
        //left bottom
        while(i<board.length && j>=0){
            if(board[i][j]==1){
                return false;
            }
            i+=1;
            j-=1;
        }

        return true;
    }
}
