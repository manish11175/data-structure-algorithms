package data_structure_2026.revision.dp.knapsack01;

import java.util.Arrays;

public class KnapsackO1 {
    public static void main(String[] args) {
        int[]wt = new int[]{2,3,4,5};
        int[]v = new int[]{5,7,9,21};
        int k =8;
        System.out.println(knap(wt,v,k,wt.length));
        int[][]dp =  new int[wt.length+1][k+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }

        System.out.println(knapWithDp(wt,v,k,wt.length,dp));
        System.out.println(knapTopDown(wt,v,k,wt.length));
    }

    private static int knap(int[]wt, int[] v, int k, int n){
        if(n==0){
            return 0;
        }

        if(wt[n-1]<=k){
            return Math.max(v[n-1]+knap(wt,v,k-wt[n-1],n-1),knap(wt,v,k,n-1));
        }
        return knap(wt,v,k,n-1);
    }

    private static int knapWithDp(int[]wt, int[] v, int k, int n,int[][]dp){
        if(n==0){
            return 0;
        }
        if(dp[n][k]!=-1){
            return dp[n][k];
        }

        if(wt[n-1]<=k){
            return dp[n][k]= Math.max(v[n-1]+knapWithDp(wt,v,k-wt[n-1],n-1,dp),knapWithDp(wt,v,k,n-1,dp));
        }
        return dp[n][k]= knapWithDp(wt,v,k,n-1,dp);
    }

    private static int knapTopDown(int[]wt, int[] v, int k, int n){
        if(n==0){
            return 0;
        }

        int[][]dp= new int[n+1][k+1];
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <k+1 ; j++) {
                if(wt[i-1]<=j){
                    dp[i][j]= Math.max(v[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
}
