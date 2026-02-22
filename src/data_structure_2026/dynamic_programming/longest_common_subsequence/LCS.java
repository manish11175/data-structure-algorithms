package data_structure_2026.dynamic_programming.longest_common_subsequence;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String x= "abcderfs";
        String y="abeksdrf";
//        System.out.println(lcs(x,y,x.length(),y.length()));
        System.out.println(lcsDp(x,y));
        System.out.println(lcsTopDown(x,y));
    }
    private static int lcs(String x, String y, int n,int m){
        if (n==0||m==0){
            return 0;
        }

        if(x.charAt(n-1)==y.charAt(m-1)){
            return 1+lcs(x,y,n-1,m-1);
        }
        else {
            return Math.max(lcs(x,y,n-1,m),lcs(x,y,n,m-1));
        }
    }

    private static int lcsDp(String x, String y){
        int n= x.length();
        int m=y.length();
        int[][]dp = new int[n+1][m+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return lcsDp(x,y,n,m,dp);
    }

    private static int lcsDp(String x, String y, int n, int m,int[][]dp){
        if(n==0 ||m==0){
            return 0;
        }

        if(dp[n-1][m-1]!=-1){
            return dp[n-1][m-1];
        }

        if(x.charAt(n-1)==y.charAt(m-1)){
            return dp[n][m]=1+lcs(x,y,n-1,m-1);
        }
        else {
            return dp[n][m]= Math.max(lcs(x,y,n,m-1),lcs(x,y,n-1,m));
        }
    }

    public static int lcsTopDown(String x, String y){
        int n=x.length();
        int m=y.length();
        int[][]dp = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            for(int j=1;j<m+1;j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
