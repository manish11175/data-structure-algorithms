package data_structure_2026.revision.dp.knapsack01;

import static data_structure_2026.dynamic_programming.matrix_chain_multiplication.MinimumPartitionPalindrome.isPalindrome;

public class Mcm {

    public static void main(String[] args) {
        String a ="nitil";
        System.out.println(minimumPartition(a,0,a.length()-1));
    }

    public static int minimumPartition(String a, int i,int j){
        if(i>=j){
            return 0;
        }

        if(isPalindrome(a,i,j)){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = 1+ minimumPartition(a,i,k)+minimumPartition(a,k+1,j);
            if(temp<res){
                res=temp;
            }
        }
        return res;
    }

    public static int minimumPartition(String a, int i,int j, int[][]dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(isPalindrome(a,i,j)){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = 1+ minimumPartition(a,i,k)+minimumPartition(a,k+1,j);
            if(temp<res){
                res=temp;
            }
        }
        return dp[i][j] =res;
    }
}
