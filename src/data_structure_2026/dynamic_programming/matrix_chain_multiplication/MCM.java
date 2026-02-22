package data_structure_2026.dynamic_programming.matrix_chain_multiplication;

public class MCM {
    public static void main(String[] args) {
        int[]arr= new int[]{4,2,3,1,3};
        System.out.println(minimize(arr,1,arr.length-1));

        int[][]cache = new int[arr.length][arr.length];
        System.out.println(minimize(arr,1,arr.length-1,cache));
    }

    private static int minimize(int[]arr, int i, int j){
        if(i>=j){
            return 0;
        }
        int result =Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = minimize(arr,i,k)+minimize(arr,k+1,j)+(arr[i-1]*arr[k]*arr[j]);
            if(temp<result){
                result = temp;
            }
        }
        return result;
    }

    private static int minimize(int[]arr, int i, int j,int[][]dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int result =Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = minimize(arr,i,k,dp)+minimize(arr,k+1,j,dp)+(arr[i-1]*arr[k]*arr[j]);
            if(temp<result){
                result = temp;
            }
        }
        return dp[i][j]=result;
    }
}
