package data_structure_2026.recursion.basic;

import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        int[]arr = new int[]{2,3,1,4,5,26,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[]arr){
        helper(arr,arr.length-1);
    }

    private static void helper(int[]arr, int n){
         if(n==0){
             return;
         }
         helper(arr,n-1);
         putItsCorrect(arr,n);
//        for (int i = 0; i < n; i++) {
//
    //        if(arr[n]<arr[i]){
    //             int temp = arr[i];
    //             arr[i]=arr[n];
    //             arr[n]=temp;
    //        }
//        }

    }

    private static void putItsCorrect(int[]arr, int n){
        if(n==0){
            return;
        }
        putItsCorrect(arr,n-1);

        if(arr[n]<arr[n-1]){
            int temp = arr[n-1];
            arr[n-1]=arr[n];
            arr[n]=temp;
        }
    }
}
