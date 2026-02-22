package data_structure_2026.dynamic_programming.longest_common_subsequence;

public class RepeatingSubsequence {
    public static void main(String[] args) {
        String a ="aabbhcchdd";
        System.out.println(countRepeatingSubsequence(a));
    }

    private static int countRepeatingSubsequence(String a){
        String b = a;
        int m= a.length();
        int n= b.length();
        int[][]dp =new int[m+1][n+1];
        //Using lcs a[i]==b[j] && i!=j

        for (int i = 1; i <m+1 ; i++) {
            for(int j=1;j<n+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1) && i!=j){
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
