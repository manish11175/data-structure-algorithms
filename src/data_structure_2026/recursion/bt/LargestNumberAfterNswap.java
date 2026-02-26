package data_structure_2026.recursion.bt;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestNumberAfterNswap {
    public static void main(String[] args) {
       StringBuilder sb = new StringBuilder("5489");
       StringBuilder  res = new StringBuilder();
       solve(sb,2,0,res);
        System.out.println(res);
    }

    private static void solve(StringBuilder sb,int k, int start,StringBuilder res){
        if(k==0 ||start==sb.length()-1){
//            System.out.println("sb "+sb+" res "+res);
            return;
        }

        for (int i = start+1; i <sb.length(); i++) {
            char max = maxChar(sb.substring(i));
            if(sb.charAt(start)<sb.charAt(i) && max==sb.charAt(i)){
                swap(sb,start,i);
                if (sb.compareTo(res)>0){
                     res.setLength(0);
                     res.append(sb);
                }
                solve(sb,k-1,start+1,res);
                swap(sb,i,start);
            }
        }
        solve(sb,k,start+1,res);
    }

    private static char maxChar(String substring) {
        char ch = substring.charAt(0);

        for (int i = 1; i <substring.length() ; i++) {
            if(substring.charAt(i)>ch){
                ch=substring.charAt(i);
            }
        }

        return ch;
    }

    private static void swap(StringBuilder sb,int i, int j){
        char ch = sb.charAt(i);
        sb.setCharAt(i,sb.charAt(j));
        sb.setCharAt(j,ch);
    }
}
