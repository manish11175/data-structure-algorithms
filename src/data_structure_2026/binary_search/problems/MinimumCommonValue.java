package data_structure_2026.binary_search.problems;

import data_structure_2026.binary_search.BinarySearch;

public class MinimumCommonValue {
    public static void main(String[] args) {
        int[]arr = new int[]{1,2,3,6};
        int[]arr3= new int[]{2,3,4,5};
        System.out.println(search(arr3,2));
        System.out.println(BinarySearch.searchIndex(arr3,2));
//        System.out.println(getCommon(arr,arr3));
    }
    public static int getCommon(int[] nums1, int[] nums2) {
        for(int i=0;i<nums1.length;i++){
            int index = search(nums2,nums1[i]);
            System.out.println(index);
            if(index!=-1){
                return nums1[i];
            }
        }
        return -1;
    }

    private static int search(int[]arr,int ele){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(ele==arr[mid]){
                return mid;
            }
            else if(ele>arr[mid]){
                start = mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}
