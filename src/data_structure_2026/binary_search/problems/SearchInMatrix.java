package data_structure_2026.binary_search.problems;

public class SearchInMatrix {
    public static void main(String[] args) {
        int[][]arr = new int[][]{
                {1,3,5,7}
        };
        System.out.println(searchMatrix(arr,3));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int r=0;
        int c=matrix[0].length-1;
        while(r<matrix.length && c>=0){
            if(matrix[r][c]==target){
                return true;
            }
            else if(matrix[r][c]<target){
                r+=1;
            }
            else{
                c-=1;
            }
        }
        return false;
    }
}
