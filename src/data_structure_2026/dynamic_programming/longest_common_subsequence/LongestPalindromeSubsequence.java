package data_structure_2026.dynamic_programming.longest_common_subsequence;

public class LongestPalindromeSubsequence {
    public static void main(String[] args) {
        String a = "abecbga";
        System.out.println(longestPalindromeSubsequence(a));
    }

    private static int longestPalindromeSubsequence(String a){

        String reverse = new StringBuilder(a).reverse().toString();
        int m =a.length();
        int n = reverse.length();

        //LCS
        int[][]dp = new int[m+1][n+1];
        for (int i = 1; i <m+1 ; i++) {
            for (int j = 1; j <n+1 ; j++) {
                if(a.charAt(i-1)==reverse.charAt(j-1)){
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
