package data_structure_2026.recursion.bt;

import java.util.ArrayList;

public class AllPartitionPalindrome {
    public static void main(String[] args) {
        String str = "aaba";
        ArrayList<String> res= new ArrayList<>();
        printAll(str,0,res);
    }
    private static void printAll(String str, int start, ArrayList<String>ans){
        if(start==str.length()){
            System.out.println(ans);
             return;
        }
        String sb = "";
        for (int i = start; i < str.length(); i++) {
              sb+=str.charAt(i);
              if(isPalindrome(sb)) {
                  ans.add(sb);
                  printAll(str, i + 1, ans);
                  ans.remove(ans.size() - 1);
              }
        }
    }

    private static boolean isPalindrome(String sb){
        int i=0;
        int j=sb.length()-1;
        while(i<j){
            if(sb.charAt(i)!=sb.charAt(j)){
                return false;
            }
            i+=1;
            j-=1;
        }
        return true;
    }
}
