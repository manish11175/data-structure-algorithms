package data_structure_2026.dynamic_programming.knaspack.problem;

import java.util.Arrays;

public class MinimumSubsetSumDifference {


    //Note this code will work only for positive integers
    public static void main(String[] args) {
        int[]arr=new int[]{1,6,11,5,3};
        System.out.println(minimum(arr));
    }
    private static int minimum(int[]arr){
        int range= Arrays.stream(arr).sum();
        int end = range/2;
        int n=arr.length;
        boolean[][]dp = new boolean[n+1][end+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][0]=true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<end+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i=0;i<end+1;i++){
            if(dp[n][i]){//Give the s1 - subset 1
                result=Math.min(result,range-(2*i));
            }
        }
        return result;
    }
}
