package data_structure_2026.dynamic_programming.unbound_knapsack;

import java.util.Arrays;

public class UnboundKnapsack {
    public static void main(String[] args) {
        int[]wt=new int[]{1,2,4,5};
        int[]vt = new int[]{1,2,9,7};
        int capacity = 8;
        System.out.println(maximize(wt,vt,capacity,wt.length));
    }
    private static int maximize(int[]wt, int[]vt, int capacity, int n){
        int[][]dp = new int[n+1][capacity+1];
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j < capacity+1; j++) {
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(vt[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for(int[]a:dp){
            System.out.println(Arrays.toString(a));
        }
        return dp[n][capacity];
    }
}
