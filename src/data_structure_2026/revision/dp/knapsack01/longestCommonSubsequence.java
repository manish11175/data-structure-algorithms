package data_structure_2026.revision.dp.knapsack01;

import java.util.Arrays;

public class longestCommonSubsequence {
    public static void main(String[] args) {
        String a="abbaa";
        String b="hhdsabbabjkanfka";
        System.out.println(lcs(a,b, a.length(), b.length()));
        int[][]dp =  new int[a.length()+1][b.length()+1];
        for(int[]l:dp){
            Arrays.fill(l,-1);
        }
        System.out.println(lcs(a,b,a.length(),b.length(),dp));
        System.out.println(lcsTopDown(a,b,a.length(),b.length()));
        System.out.println(lcSubStringTopDown(a,b,a.length(),b.length()));

    }
    private static int lcs(String a,String b, int m ,int n){
        if(m==0 || n==0){
            return 0;
        }
        if(a.charAt(m-1) == b.charAt(n-1)){
            return 1+lcs(a,b,m-1,n-1);
        }
        return Math.max(lcs(a,b,m-1,n),lcs(a,b,m,n-1));
    }

    private static int lcs(String a,String b, int m ,int n,int[][]dp){
        if(m==0 || n==0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(a.charAt(m-1) == b.charAt(n-1)){
            return dp[m][n]= 1+lcs(a,b,m-1,n-1,dp);
        }
        return dp[m][n]= Math.max(lcs(a,b,m-1,n,dp),lcs(a,b,m,n-1,dp));
    }
    private static int lcsTopDown(String a,String b, int m ,int n){
        if(m==0 || n==0){
            return 0;
        }
        int[][]dp= new int[m+1][n+1];
        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }

    private static int lcSubStringTopDown(String a,String b, int m ,int n){
        if(m==0 || n==0){
            return 0;
        }
        int[][]dp= new int[m+1][n+1];
        int res= Integer.MIN_VALUE;
        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    res = Math.max(dp[i][j],res);
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        return res;
    }

}
