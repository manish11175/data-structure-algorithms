package data_structure_2026.dynamic_programming.matrix_chain_multiplication;

import java.util.Arrays;

public class EggDroppingProblem {
    public static void main(String[] args) {
        int eggs =3;
        int floor= 2;
        System.out.println(solve(floor,eggs));
        int[][]dp = new int[floor+1][eggs+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        System.out.println(solveWithDp(floor,eggs,dp));
    }

    private static int solve(int floor, int eggs){
        if(floor==0|| floor==1){
            return floor;
        }
        if(eggs==1){
            return floor;
        }
        int mini= Integer.MAX_VALUE;
        for(int k=1;k<floor;k++){
            int breaked = solve(k-1,eggs-1);
            int notbreaked = solve(floor-k,eggs);

            int temp = Math.max(breaked,notbreaked)+1;
            mini=Math.min(mini,temp);
        }
        return  mini;
    }

    private static int solveWithDp(int floor, int eggs,int[][]dp){
        if(floor==0|| floor==1){
            return floor;
        }
        if(eggs==1){
            return floor;
        }
        if(dp[floor][eggs]!=-1){
            return dp[floor][eggs];
        }
        int mini= Integer.MAX_VALUE;
        for(int k=1;k<floor;k++){
            int breaked = solveWithDp(k-1,eggs-1,dp);
            int notbreaked = solveWithDp(floor-k,eggs,dp);

            int temp = Math.max(breaked,notbreaked)+1;
            mini=Math.min(mini,temp);
        }
        return  dp[floor][eggs]=mini;
    }

//    Suppose we drop an egg:
//
//    Case 1 → Egg Breaks
//
//    We lose one egg and one move
//    Remaining: dp[m-1][k-1]
//
//    Case 2 → Egg Doesn’t Break
//
//    We keep egg, lose one move
//    Remaining: dp[m-1][k]
//
//    And we also tested the current floor (+1)
    public int superEggDrop(int k, int n) {

        int[][] dp = new int[n + 1][k + 1];

        int moves = 0;

        while (dp[moves][k] < n) {
            moves++;

            for (int eggs = 1; eggs <= k; eggs++) {
                dp[moves][eggs] =
                        dp[moves - 1][eggs - 1] +
                                dp[moves - 1][eggs] + 1;
            }
        }

        return moves;
    }

}
