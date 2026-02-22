package data_structure_2026.dynamic_programming.longest_common_subsequence;

import java.util.Arrays;

public class PrintShortestCommonSuperSequence {
    public static void main(String[] args) {
        String a ="abc";
        String b = "def";
        System.out.println(printScs(a,b));
    }

    private static String printScs(String a, String b){

        int m= a.length();
        int n=b.length();
        int[][]dp= new int[m+1][n+1];

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        for(int[]ar:dp){
            System.out.println(Arrays.toString(ar));
        }
        StringBuilder sb = new StringBuilder();
        int i=m;
        int j=n;
        while (i>0 && j>0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                sb.append(a.charAt(i-1));
                i-=1;
                j-=1;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    sb.append(a.charAt(i-1));
                    i-=1;
                }
                else{
                    sb.append(b.charAt(j-1));
                    j-=1;
                }
            }
        }

        while(i>0){
            sb.append(a.charAt(i-1));
            i-=1;
        }

        while(j>0){
            sb.append(b.charAt(j-1));
            j-=1;
        }

        return sb.reverse().toString();
    }
}
