package data_structure_2026.revision.stack;

import java.util.Arrays;

public class StockSpan {
    public static void main(String[] args) {
        int[]arr = new int[]{100,80,60,70,60,75,85};
        int[]nGl = StackUtils.nearestGreaterIndexToLeft(arr);
//        int[]nGr = StackUtils.nearestGreaterToRight(arr);
        int[]ans = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            ans[i]=i-nGl[i];
        }
        System.out.println(Arrays.toString(ans));
    }
}
