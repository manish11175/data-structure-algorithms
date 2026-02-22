package data_structure_2026.dynamic_programming.longest_common_subsequence;

import java.util.Arrays;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String x ="adadac";
        String y ="adac";
        System.out.println(lcs(x,y));
    }

    private static int lcs(String x,String y){
        int m=x.length();
        int n=y.length();
        int[][]dp = new int[m+1][n+1];
        int result = 0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    result=Math.max(dp[i][j],result);
                }
                else{

                    dp[i][j]=0;
                }
            }
        }
//        for(int[]a:dp){
//            System.out.println(Arrays.toString(a));
//        }
        return result;
    }
}
