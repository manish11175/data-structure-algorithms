package data_structure_2026.dynamic_programming.longest_common_subsequence;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String x = "abc";
        String y = "def";
        int m =x.length();
        int n = y.length();
        int lcs = lcs(x,y);
        System.out.println(lcs);
        int shortestCommonSuperSequence = (m+n)-lcs;
        System.out.println(shortestCommonSuperSequence);
    }

    private static int lcs(String x,String y){
        int m = x.length();
        int n = y.length();
        int[][]dp = new int[m+1][n+1];

        for (int i = 1; i <m+1; i++) {
            for (int j = 1; j < n+1 ; j++) {
                if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
