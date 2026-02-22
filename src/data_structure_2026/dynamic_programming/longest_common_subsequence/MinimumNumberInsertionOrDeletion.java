package data_structure_2026.dynamic_programming.longest_common_subsequence;

public class MinimumNumberInsertionOrDeletion {
    public static void main(String[] args) {
        String a= "abcebesaba";
        System.out.println(a.length()-lps(a));
    }

    private static int lps(String s){
        String rev = new StringBuilder(s).reverse().toString();
        //lcs
        int m = s.length();
        int n = rev.length();
        int[][]dp = new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
