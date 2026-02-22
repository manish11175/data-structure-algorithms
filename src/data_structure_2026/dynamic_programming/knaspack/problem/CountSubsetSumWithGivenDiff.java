package data_structure_2026.dynamic_programming.knaspack.problem;

import java.util.Arrays;

public class CountSubsetSumWithGivenDiff {
    public static void main(String[] args) {
//        int[]arr=new int[]{1,1,1,1,1};
        int[]arr=new int[]{1,0};
        int diff = 1;
        System.out.println(countSubsetSumWithDiff(arr,diff));
    }
    private static int countSubsetSumWithDiff(int[]arr, int diff){
        int sum = Arrays.stream(arr).sum();
        int s = sum-diff;
        if(s%2!=0){
            return 0;
        }
        else{
            return countSubsetSum(arr,s/2);
        }
    }

    private static int countSubsetSum(int[]arr,int k){
        int n=arr.length;
        int[][]dp = new int[n+1][k+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <n+1 ; i++) {
            for(int j=0;j<k+1;j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
}
