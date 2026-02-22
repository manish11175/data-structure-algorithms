package data_structure_2026.dynamic_programming.knaspack;

public class KnapsackP {
    public static void main(String[] args) {
        int[]wt = new int[]{1,1,4,5};
        int []v = new int[]{2,4,3,5};
        int k=1;
        System.out.println(knapsack(wt,v,k,wt.length));
    }

    private static int knapsack(int[] wt, int[] v, int k, int length) {
         int[][]dp=new int[length+1][k+1];

         //initialization
//        for (int i = 0; i < length; i++) {
//            dp[i][0]=true;
//        }

         for(int i=1;i<length+1;i++){
             for (int j = 1; j <k+1 ; j++) {
                 if(wt[i-1]<=j){
                     dp[i][j]=Math.max(v[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                 }
                 else{
                     dp[i][j]=dp[i-1][j];
                 }
             }
         }
         return dp[length][k];
    }
}
