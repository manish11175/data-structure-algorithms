package sliding_window;

public class MaximumSumSubArrayOfSizeK {
    private static int maximumSum(int[]arr,int k){
        int maxSum = 0;
        int i=0;
        int j=0;
        while(i<k){
            maxSum+=arr[i];
            i++;
        }
        int currentSum = maxSum;
        while(i<arr.length){
            currentSum+=(arr[i]-arr[j]);
            maxSum=Math.max(maxSum,currentSum);
            i+=1;
            j+=1;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[]arr={2,3,4,5,5,6,7,6,2};
        int k = 3;
        System.out.println(maximumSum(arr,k));
    }
}
