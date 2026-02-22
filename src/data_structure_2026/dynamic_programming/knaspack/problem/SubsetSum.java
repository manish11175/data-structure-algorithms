package data_structure_2026.dynamic_programming.knaspack.problem;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int[]arr= new int[]{2,3,7,8,10};
        int k=25;
        int n=arr.length;
        System.out.println(subsetSum(arr,k,n,new boolean[n+1][k+1]));
        System.out.println(subset(arr,k,n));
    }
    private static boolean subsetSum(int[]arr,int k, int n){
       boolean[][]DP= new boolean[n+1][k+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < k+1; j++) {
                if(j==0){
                    DP[i][j]=true;
                }
            }
        }
        for (int i =1; i < n+1; i++) {
            for (int j = 0; j <k+1 ; j++) {
                if(arr[i-1]<=j){
                    DP[i][j]= DP[i-1][j-arr[i-1]] ||DP[i-1][j];
                }
                else{
                    DP[i][j]= DP[i-1][j];
                }
            }
        }
        return DP[n][k];
    }

    private static boolean subsetSum(int[]arr,int k,int n,boolean[][]DP){

        if(k==0){
            return true;
        }
        if(n==0) {
            return false;
        }
        if(DP[n][k]){
            return true;
        }
        if(arr[n-1]<=k){
            return DP[n][k]=subsetSum(arr,k-arr[n-1],n-1,DP)||subsetSum(arr,k,n-1,DP);
        }
        return DP[n][k]=subsetSum(arr,k,n-1,DP);
    }

    public static boolean subset(int[]arr, int k, int n){
        boolean[][] dp=new boolean[n+1][k+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < k+1; j++) {
                if(j==0){
                    dp[i][j]=true;
                }
            }
        }

        for (int i = 1; i <n+1 ; i++) {
            for (int j = 0; j < k+1; j++) {
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
}
