package data_structure_2026.binary_search.problems;

public class KthSmallestInSortedMatrix {
    public static void main(String[] args) {


        int[][]matrix = new int[][]{
                {1,5,7,9},
                {10,11,12,13},
                {11,12,13,15}
        };
        int k =8;
        System.out.println(kthSmallest(matrix,k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int start = matrix[0][0];
        int end = matrix[matrix.length-1][matrix[0].length-1];
        int result =start;
        while(start<=end){
            int mid = start + (end-start)/2;
            int count = countSmaller(matrix,mid);
            if(count>=k){
                result=mid;
                end=mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return result;
    }

    private static int countSmaller(int[][] matrix, int mid) {
        int r=0;
        int c = matrix[0].length-1;
        int count =0;
        while(r<matrix.length && c>=0){
            if(matrix[r][c]<=mid){
                r+=1;
                count+=c+1;
            }
            else {
                c-=1;
            }
        }
        return count;
    }
}
