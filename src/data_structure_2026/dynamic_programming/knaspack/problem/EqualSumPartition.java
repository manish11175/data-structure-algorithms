package data_structure_2026.dynamic_programming.knaspack.problem;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[]arr=new int[]{1,5,11,5,1};
        System.out.println(equalSumPartition(arr));
    }
    public static boolean equalSumPartition(int[]arr){
        long sum = 0;
        for(int a:arr){
            sum+=a;
        }

        if(sum%2!=0){
            return false;// if sum of arr is odd we can't divide it into two equal parts
        }
        else{
//            return SubsetSum.subset(arr,(int)sum/2,arr.length);
            return subsetSum(arr,(int)sum/2,arr.length);
        }
    }

    private static boolean subsetSum(int[]arr,int k,int n){
        boolean[][]dp = new boolean[n+1][k+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<k+1;j++){
                if(j==0){
                    dp[i][j]=true;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<k+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }
}
