package sliding_window.variable_sized_sliding_windoe;

public class LongestSubArrayOfSumK {
    public static void main(String[] args) {
       int[]arr ={767,137, 968, 645, 662, 889, 234, 0, 882, 547, 171, 767, 137, 968, 645, 662, 889, 234, 0, 882, 547, 171};
       int k =234;
        System.out.println(longestSubArrayOfSumK(arr,k));
    }

    private static int longestSubArrayOfSumK(int[]arr,int k){
        int maxSize =0;

        int i =0;
        int r = 0;
        int sum = 0;

        while(r<arr.length){
            if(sum<=k){
                sum+=arr[r];
                r+=1;
            }
            else{
                sum-=arr[i];
                i+=1;
            }
            System.out.println(i+" "+r+" "+sum);
            if(sum==k){
                maxSize=Math.max(maxSize,(r-i));
            }
        }
        return maxSize;
    }
}
