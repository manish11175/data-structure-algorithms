package data_structure_2026.dynamic_programming.unbound_knapsack;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[]coins = new int[]{1,2,3};
        int amount = 5;

        int[][]dp=new int[coins.length+1][amount+1];
        for (int[]a:dp){
            Arrays.fill(a,-1);
        }
        System.out.println(noWays(coins,amount,coins.length,dp));
    }

    public static int noWays(int[]coins, int amount, int n,int[][]dp){

        if(amount==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(dp[n][amount]!=-1){
            return dp[n][amount];
        }

        if(coins[n-1]<=amount){
            int include = noWays(coins,amount-coins[n-1],n,dp);
            int exclude = noWays(coins,amount,n-1,dp);
            return dp[n][amount]=include+exclude;
        }
        else{
            return dp[n][amount]=noWays(coins,amount,n-1,dp);
        }
    }
}
