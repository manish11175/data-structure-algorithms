package data_structure_2026.binary_search;

import data_structure_2026.stack.Pair;

public class BinarySearch {
    public static int searchIndex(int[]arr, int ele){
        int low = 0;
        int end = arr.length-1;
        while(low<=end){
            int mid = low + (end-low)/2;
            if(arr[mid]==ele){
                return mid;
            }
            if(ele > arr[mid]){
                low = mid +1;
            }
            else {
                end= mid -1;
            }
        }
        return -1;
    }


    public static int searchInReverse(int[]arr, int ele){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;

            if(ele==arr[mid]){
                return mid;
            }

            if(ele<arr[mid]){
                start = mid+1;
            }
            else{
                end = mid -1;
            }
        }
        return -1;
    }


    public static int searchInUnknownOrder(int[]arr,int ele){

        boolean isAscending = true;
        if(arr.length>1){
            if(arr[0]>arr[1]){
                isAscending=false;
            }
        }
        else{
            if(arr.length==0)
                return -1;
            if(arr[0]==ele){
                return 0;
            }
            else{
                return -1;
            }
        }
        if(isAscending){
            return searchIndex(arr,ele);
        }
        else return searchInReverse(arr,ele);
    }


    public static int findFirstIndex(int[]arr,int ele){
        int start =0;
        int end = arr.length-1;
        int firstIndex = -1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(ele==arr[mid]){
                firstIndex=mid;
                end=mid-1;
            } else if (ele>arr[mid]) {
                start=mid+1;
            }
            else{
                end=mid-1;
            }

        }
        return firstIndex;
    }

    public static int findLastIndex(int[]arr, int ele){
        int start =0;
        int end = arr.length-1;
        int lastIndex = -1;

        while(start<=end){
            int mid = start +(end-start)/2;
            if(arr[mid]==ele){
                lastIndex=mid;
                start=mid+1;
            } else if (ele>arr[mid]) {
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return lastIndex;
    }

    public static int countOccurrence(int[]arr,int ele){
         int last = findLastIndex(arr,ele);
         int first = findFirstIndex(arr,ele);
         if(last==-1 || first==-1){
             return 0;
         }
         return last-first+1;
    }


    public static int minIndexInRotated(int[]arr){
        int start =0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid>0 && arr[mid]<arr[mid-1]){
                return mid;
            }
            if(mid<arr.length-1 && arr[mid]>arr[mid+1]){
                return mid+1;
            }
            if(arr[start]<=arr[mid]){
                start=mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return -1;
    }

    public  static int maxIndexInRotated(int[]arr){
        int start =0;
        int end =arr.length-1;

        while(start<=end){
            int mid = start+ (end-start)/2;
            if (arr[mid]>arr[mid+1]){
                return mid;
            }
            if(arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[start]<=arr[mid]){
                start= mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }

    public static int numberRotation(int[]arr){
        int min = minIndexInRotated(arr);
        return (arr.length-min)%arr.length;
    }

    public static int searchIndex(int[]arr,int ele, int start,int end){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==ele){
                return mid;
            } else if (ele>arr[mid]) {
                start =  mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return -1;
    }
    public static int searchInRotated(int[]arr,int ele){
        int maxIndex = maxIndexInRotated(arr);
        if(maxIndex==arr.length-1){
            return searchIndex(arr,ele);
        }
        int left = searchIndex(arr,ele, 0,maxIndex);
        if(left!=-1){
            return left;
        }
        return searchIndex(arr,ele,maxIndex+=1,arr.length-1);
    }


    public static int searchInNearly(int[]arr, int ele){
        int start =0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==ele){
                return mid;
            }
            if(mid<arr.length-1 && arr[mid+1]==ele){
                return mid+1;
            }
            if(mid>0 && arr[mid-1]==ele){
                return mid-1;
            }

            if(ele>arr[mid]){
                start = mid+2;
            }
            else{
                end = mid - 2;
            }
        }
        return -1;
    }

    public static int floor(int[]arr, int ele){
        int start = 0;
        int end = arr.length-1;
        int floor = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]<ele){
                floor = arr[mid];
                start=mid+1;
            }
            else{
                end =mid -1;
            }
        }
        return floor;
    }

    public  static int ceil(int[]arr, int ele){
        int start  = 0;
        int end = arr.length-1;
        int ceil =  -1;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(arr[mid]>ele){
                ceil = arr[mid];
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ceil;
    }

    public static char nextAlphabet(char[]arr,char ch){
        int start =0;
        int end  =arr.length-1;
        char ans = 'a';
        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]>ch){
                ans=arr[mid];
                end=mid-1;
            }
            else{
                start = mid +1;
            }
        }
        return ans;
    }

    public static int searchInfinite(int[]arr, int ele){
        int start = 0;
        int end = 1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==ele){
                return mid;
            }
            if(ele>arr[mid]){
                start = end;
                end = 2*end;
            }
            if(end>=arr.length){
                return searchIndexWithEnd(arr,ele,start,end);
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }

    public static int searchIndexWithEnd(int[]arr,int ele, int start,int end){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid>=arr.length){
                end=mid-1;
            }
            else if(arr[mid]==ele){
                return mid;
            } else if (ele>arr[mid]) {
                start =  mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return -1;
    }
// 10 20 15 2 23 90 67
    public static int peakIndex(int[]arr){
        int start = 0;
        int end = arr.length-1;

        while (start<=end){
            int mid =start+(end-start)/2;
            if(mid!=0 && mid!=arr.length-1){
                if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                    return mid;
                } else if (arr[mid-1]>arr[mid]) {
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else {
                if(mid==0){
                    if(arr[mid]>arr[mid+1]){
                        return mid;
                    }
                    else {
                        start=mid+1;
                    }
                }
                else{
                    if(arr[mid]>arr[mid-1]){
                        return mid;
                    }
                    else{
                        end = mid -1;
                    }
                }
            }
        }
        return -1;
    }

    //1,3,8,12,4,2

    public static int peakInBitonic(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        if(arr.length<2){
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid != 0 && mid != arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid] < arr[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if (mid == 0) {
                if(arr[mid] > arr[mid + 1]){
                    return mid;
                }
                else{
                    start=mid+1;
                }

            } else if (mid == arr.length - 1 ){
                if( arr[mid] > arr[mid - 1]) {
                    return mid;
                }
                else{
                    end=mid-1;
                }
            }

        }
        return -1;
    }


    public static int searchInBitonic(int[]arr, int ele){
        int peak = peakInBitonic(arr);
        int left = searchIndex(arr,ele,0,peak);
        if(left==-1){
            return searchIndex(arr,ele,peak,arr.length);
        }
        return left;
    }

    public static Pair searchInMatrix(int[][]arr,int ele){
        int i=0;
        int j=arr[0].length-1;
        while(i< arr.length && j>=0){
            if(arr[i][j]==ele){
                return new Pair(i,j);
            } else if (ele<arr[i][j]) {
                j-=1;
            }
            else{
                i+=1;
            }
        }
        return new Pair(-1,-1);
    }
}
