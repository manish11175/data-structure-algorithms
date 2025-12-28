package sliding_window;

import java.util.ArrayList;
import java.util.List;

//use can Dequeue also to optimize the remove ops
public class MaximumOfAllSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {83, 13, 23, 82, 20, 4, 83, 96, 88, 50, 93, 35, 5, 33, 25, 2, 93, 96, 32, 68, 17, 99, 60, 33, 14, 43 ,84, 56, 38, 46, 67, 69 ,47, 6, 32 ,31, 71, 38 ,89 ,63 ,31, 25, 72 ,10};
        System.out.println(getMaximumOfAllSubArray(arr, 9));
    }

    private static List<Integer> getMaximumOfAllSubArray(int[] arr, int k) {
            List<Integer> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            int i = 0;
            int j = 0;
            while (j < k) {
                if (!list.isEmpty()) {
                    while (!list.isEmpty() && j < arr.length && list.get(list.size()-1) < arr[j]) {
                        list.remove(list.size()-1);
                    }
                    if (j < arr.length) {
                        list.add(arr[j]);
                    }
                } else {
                    list.add(arr[j]);
                }
                j += 1;
            }

            j-=1;

            while (j < arr.length) {
                if (list.get(0) == arr[i]) {
                    ans.add(list.get(0));
                    list.remove(0);
                } else {
                    ans.add(list.get(0));
                }
                j += 1;
                i += 1;

                while (!list.isEmpty() && j < arr.length && list.get(list.size()-1) < arr[j]) {
                    list.remove(list.size()-1);
                }
                if (j < arr.length) {
                    list.add(arr[j]);
                }
            }
            return ans;
    }
}
