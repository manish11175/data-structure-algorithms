package data_structure_2026.dynamic_programming.matrix_chain_multiplication;

import java.util.Arrays;

public class Parenthesization {
    public static void main(String[] args) {
        int[]arr=new int[]{4,2,3,1,2};
        int[][]km = new int[arr.length][arr.length];
        int mini = minimize(arr,1,arr.length-1,km);
        System.out.println(mini);
        for(int[]a:km){
            System.out.println(Arrays.toString(a));
        }
    }

    private static int minimize(int[]arr,int i,int j,int[][]km){
        if(i>=j){
            return 0;
        }

        int res=  Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = minimize(arr,i,k,km)+minimize(arr,k+1,j,km)+(arr[i-1]*arr[k]*arr[j]);
            if(temp<res){
                res=temp;
                km[i][j]=k;
            }
        }
        return res;
    }
}
