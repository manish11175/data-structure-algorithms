package data_structure_2026.dynamic_programming.unbound_knapsack;

public class RodCutting  {
    public static void main(String[] args) {
        int[]rods = new int[]{1,2,3,4,5,6,7,8};
        int[]price = new int[]{1,5,8,9,10,17,17,28};
        int capacity= 8;
        System.out.println(maximumPrice(rods,price,capacity,rods.length));
    }
    private static int maximumPrice(int[]rod,int[]price,int capacity, int n){
        int[][]dp = new int[n+1][capacity+1];
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 0; j < capacity+1; j++) {
                if (rod[i-1]<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-rod[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][capacity];
    }
}
