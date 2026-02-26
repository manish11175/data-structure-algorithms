package data_structure_2026.recursion.bt;

import java.util.ArrayList;

public class NDigitIncreasingNumber {
    public static void main(String[] args) {

        System.out.println(ndigit(3));
    }

    private static ArrayList<Integer> ndigit(int n){
        ArrayList<Integer> res = new ArrayList<>();
        if(n==1){
            for (int i = 0; i <=9; i++) {
                res.add(1);
            }
            return res;
        }
        solve(n,res,new ArrayList<Integer>());
        return res;
    }
    private static void solve(int n,ArrayList<Integer> res, ArrayList<Integer> arr){
        if(n==0){
            int num=0;
            for(int i=0;i<arr.size();i++){
                num=(num*10)+arr.get(i);
            }
            res.add(num);
            return;
        }

        for (int i = 1; i <10 ; i++) {
            if(!arr.isEmpty()){
              if(i> arr.get(arr.size() - 1)){
                  arr.add(i);
                  solve(n-1,res,arr);
                  arr.remove(arr.size()-1);
              }
            }
            else{
                arr.add(i);
                solve(n-1,res,arr);
                arr.remove(arr.size()-1);
            }
        }
    }
}
