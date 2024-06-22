package preparations.interview_bit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question263 {
    public static ArrayList<Integer> maxSet(ArrayList<Integer>A){
        Collections.sort(A);
        int i=0;
        while(i+1<A.size()){
            swap(A,i,i+1);
            i+=2;
        }
        return A;
    }

    private static void swap(ArrayList<Integer> A,int a,int b){
        int temp=A.get(a);
        A.set(a,A.get(b));
        A.set(b,temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer>arr= new ArrayList<>();
        arr.addAll(List.of(2,1,4,3,5));
        System.out.println(maxSet(arr));
    }
}

