package sliding_window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInEveryWindowOfSizeK {
    public static void main(String[] args) {
        int[]arr = {-8,2,3,-6,-10};
        System.out.println(printFirstNegativeInteger(arr,2));
    }

    static List<Integer> printFirstNegativeInteger(int arr[], int k) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<k;i++){
            if(arr[i]<0){
                queue.add(arr[i]);
            }
        }

        int i=0;
        int j=k-1;
       while (j< arr.length){
           if(queue.isEmpty()){
               ans.add(0);
           }
           else{
               int first = queue.peek();
               ans.add(first);
               if(arr[i]==first){
                   queue.poll();
               }
           }
           i+=1;
           j+=1;
           if(j<arr.length && arr[j]<0){
               queue.add(arr[j]);
           }
       }
        return ans;
    }
}
