package data_structure_2026.dynamic_programming.matrix_chain_multiplication;

import java.util.Arrays;

public class MinimumPartitionPalindrome {
    public static void main(String[] args) {
        String str = "mainij";
        int[][]dp= new int[str.length()][str.length()];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        System.out.println(minimize(str,0,str.length()-1));
        System.out.println(minimize(str,0,str.length()-1,dp));
    }

    private static int minimize(String str, int i, int j){
        if(i>=j){
            return 0;
        }
        if(isPalindrome(str,i,j)){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = minimize(str,i,k)+minimize(str,k+1,j)+1;
            if(temp<min){
                min=temp;
            }
        }
        return min;
    }

    private static int minimize(String str, int i, int j,int[][]dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(isPalindrome(str,i,j)){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = minimize(str,i,k,dp)+minimize(str,k+1,j,dp)+1;
            if(temp<min){
                min=temp;
            }
        }
        return dp[i][j]=min;
    }

    public static boolean isPalindrome(String str, int i, int j) {
        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                j-=1;
                i+=1;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
