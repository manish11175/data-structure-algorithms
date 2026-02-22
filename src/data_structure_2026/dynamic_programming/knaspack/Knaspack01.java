package data_structure_2026.dynamic_programming.knaspack;

import java.util.Arrays;

public class Knaspack01 {
    private static int[][]dp= new int[5][8];
    public static void main(String[] args) {
        int[]wt=new int[]{1,3,4,5};
        int[]values=new int[]{1,4,5,7};
        int capacity =4;
        int n=4;
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        System.out.println(maxProfit(wt,values,capacity,n));
        System.out.println(knaspack(wt,values,capacity,4));
    }
    private static int maxProfit(int[] wt, int[] values, int capacity, int n) {
        if (n == 0 || capacity == 0) { // change this to initialization i=0 to n+1, j=0 to capacity+1 fill 0 to i==0 ||j==0
            return 0;
        }
        if(dp[n][capacity]!=-1){
            return dp[n][capacity];
        }

        if (wt[n - 1] <= capacity) {
            return dp[n][capacity] = Math.max(values[n - 1] + maxProfit(wt, values, capacity - wt[n - 1], n - 1),
                    maxProfit(wt, values, capacity, n - 1));
            // DP[n][W]=max(values[n-1]+DP[n-1][W-wt[n-1]],DP[n-1][W])
        }
        return  dp[n][capacity] = maxProfit(wt, values, capacity, n - 1); //--> change this to DP[n][W]=DP[n-1][W];
        // i=1 to n-1 and j=1 to capacity+1 and change n to and W to j;
    }


    private static int knaspack(int[]wt,int[]values,int capacity, int n){
        int[][]DP = new int[n+1][capacity+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < capacity+1; j++) {
                if(i==0 ||j==0){
                    DP[i][j]=0;
                }
            }
        }

        for (int i=1;i<n+1;i++){
            for (int j = 1; j < capacity+1; j++) {
                if(wt[i-1]<=j){
                    DP[i][j]=Math.max(values[i-1]+DP[i-1][j-wt[i-1]],DP[i-1][j]);
                }
                else{
                    DP[i][j]=DP[i-1][j];
                }
            }
        }
        return DP[n][capacity];
    }
}
