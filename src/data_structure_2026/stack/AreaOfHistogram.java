package data_structure_2026.stack;


import java.util.Arrays;
import java.util.Stack;

public class AreaOfHistogram {

    public static void main(String[] args) {
        int[]arr = new int[]{6,2,1,4,3,5,4,2};
        System.out.println(areaOfHistogram(arr));
    }

    public static int areaOfHistogram(int[] arr) {
        int ans = 0;
        int[] nSRI = nearestSmallestRightIndex(arr);
        int[] nSLI = nearestSmallestLeftIndex(arr);
        System.out.println(Arrays.toString(nSLI));
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nSRI));

        for (int i = 0; i < arr.length; i++) {
            int area = ((nSRI[i] - nSLI[i]) - 1) * arr[i];
//            System.out.println(i+"  Area "+ area);
            if (area > ans) {
                ans = area;
            }
        }
        return ans;
    }

    public static int[] nearestSmallestRightIndex(int[] arr) {
        Stack<Pair> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().getKey() >= arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek().getValue();
            stack.add(new Pair(arr[i], i));
        }
        return ans;
    }

    public static int[] nearestSmallestLeftIndex(int[] arr) {
        Stack<Pair> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek().getKey() >= arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek().getValue();
            stack.add(new Pair(arr[i], i));
        }
        return ans;
    }
}

