package data_structure_2026.dynamic_programming.unbound_knapsack;

import java.util.Arrays;

public class CoinChangeMinimumCoinsToSum {
    public static void main(String[] args) {
        int[]arr=new int[]{1,2,3};
        int k=5;
        System.out.println(minimumCoins(arr,k));
    }
    private static int minimumCoins(int[]arr,int k){
        int n=arr.length;
        int[][]dp = new int[n+1][k+1];
        //Initialization
        for (int i = 0; i < n+1; i++) {
            dp[i][0]=0;
        }
        for (int j = 0; j < k+1; j++) {
            dp[0][j]=Integer.MAX_VALUE-1;
            if(j%arr[0]==0){
                dp[1][j]=j/arr[0];
            }
            else{
                dp[1][j]=Integer.MAX_VALUE-1;
            }
        }
        // Logic
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <k+1 ; j++) {
                if(arr[i-1]<=j){
                    dp[i][j]=Math.min(dp[i][j-arr[i-1]]+1,dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for(int[]a:dp){
            System.out.println(Arrays.toString(a));
        }

        return dp[n][k]%(Integer.MAX_VALUE-1);
    }
}
