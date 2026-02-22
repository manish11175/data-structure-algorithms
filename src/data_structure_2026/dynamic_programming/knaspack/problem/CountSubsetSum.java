package data_structure_2026.dynamic_programming.knaspack.problem;

public class CountSubsetSum {
    public static void main(String[] args) {
//        int[]arr=new int[]{2,3,5,6,8,10};
        int[]arr=new int[]{1,1,1};
        int k=2;

        System.out.println(countSubsetSum(arr,k,arr.length));
    }

    private static int countSubsetSum(int[]arr,int k, int n){
        int[][]dp = new int[n+1][k+1];
        for (int i = 0; i <n+1 ; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 0; j <k+1 ; j++) {
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
    private static boolean subsetSum(int[]arr, int k){
        int n=arr.length;
        boolean[][]dp = new boolean[n+1][k+1];
        for (int i = 0; i < n+1 ; i++) {
            dp[i][0]=true;
        }

        for (int i = 1; i <n+1 ; i++) {
            for (int j = 0; j <k+1 ; j++) {
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }

}
