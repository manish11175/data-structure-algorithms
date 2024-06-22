package preparations.interview_bit;

import java.util.ArrayList;
import java.util.List;

public class Question262 {
    public static ArrayList<Integer> maxSet(ArrayList<Integer>A){
        long max=Long.MIN_VALUE;
        int start=0;
        int end=0;
        long currentSum=0;

        int i=-1;
        int j=0;
        while(j<A.size()){
            if(A.get(j)<0){
                if(max<currentSum){
                    max=currentSum;
                    start=i+1;
                    end=j;
                }
                currentSum=0;
                i=j;
                j+=1;
            }
            else{
                currentSum+=A.get(j);
                j+=1;
            }
        }
        if(max<currentSum){
            max=currentSum;
            start=i+1;
            end=j;
        }
        System.out.println(start+" "+end+" "+i+" "+j);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int k=start;k<end;k++){
            ans.add(A.get(k));
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer>arr= new ArrayList<>();
        arr.addAll(List.of(0,0,-1,0));
        System.out.println(maxSet(arr));
    }
}
