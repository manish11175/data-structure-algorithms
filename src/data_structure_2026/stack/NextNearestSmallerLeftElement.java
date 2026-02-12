package data_structure_2026.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextNearestSmallerLeftElement {
    public static void main(String[] args) {
//        int[]arr = new int[]{1,3,2,4};
        int[]arr = new int[]{1,3,0,0,1,2,4};
        System.out.println(Arrays.toString(build(arr)));
    }

    public static int[] build(int[]arr){
        Stack<Integer> stack = new Stack<>();
        int[]ans = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && stack.peek()>=arr[i]){
                stack.pop();
            }
            ans[i]=stack.isEmpty()?-1:stack.peek();
            stack.add(arr[i]);
        }
        return ans;
    }
}
