package data_structure_2026.dynamic_programming.unbound_knapsack;

public class CoinChangeProblem {
    public static void main(String[] args) {
        int[]coins=new int[]{1,2,3};
        int k=5;
        System.out.println(maximumNoWays(coins,k));
    }

    private static int maximumNoWays(int[]arr,int k){
        int n= arr.length;
        int[][]dp=new int[n+1][k+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 0; j < k+1; j++) {
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i][j-arr[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
}
