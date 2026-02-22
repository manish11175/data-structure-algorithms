package data_structure_2026.dynamic_programming.longest_common_subsequence;

import java.util.Arrays;

public class PrintLcs {
    public static void main(String[] args) {
        String x = "abcab";
        String y = "cbab";
        System.out.println(printLcs(x,y));
    }

    private static String printLcs(String x, String y){
        int m = x.length();
        int n = y.length();
        int[][]dp =  new int[m+1][n+1];
        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        for(int[]a:dp){
            System.out.println(Arrays.toString(a));
        }

        int i=m;
        int j=n;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(x.charAt(i-1)==y.charAt(j-1)){
                sb.append(x.charAt(i-1));
                i-=1;
                j-=1;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i-=1;
                }
                else{
                    j-=1;
                }
            }
        }
        return sb.reverse().toString();
    }
}
