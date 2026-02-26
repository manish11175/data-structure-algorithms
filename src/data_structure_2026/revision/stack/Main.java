package data_structure_2026.revision.stack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[]arr = new int[]{10,9,8,11,15,3};
//        int[]ngL= StackUtils.nearestGreaterToLeft(arr);
//        System.out.println(Arrays.toString(ngL));
//        int[]ngR= StackUtils.nearestGreaterToRight(arr);
//        System.out.println(Arrays.toString(ngR));
//        int[]nsL= StackUtils.nearestSmallerToLeft(arr);
//        System.out.println(Arrays.toString(nsL));
//        int[]ncR=StackUtils.nearestSmallestToRight(arr);
//        System.out.println(Arrays.toString(ncR));

        int[]ngL= StackUtils.nearestGreaterIndexToLeft(arr);
        System.out.println(Arrays.toString(ngL));
        int[]ngR= StackUtils.nearestGreaterIndexToRight(arr);
        System.out.println(Arrays.toString(ngR));
        int[]nsL= StackUtils.nearestSmallerIndexToLeft(arr);
        System.out.println(Arrays.toString(nsL));
        int[]ncR=StackUtils.nearestSmallestIndexToRight(arr);
        System.out.println(Arrays.toString(ncR));
    }
}
