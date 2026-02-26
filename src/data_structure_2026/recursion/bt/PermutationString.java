package data_structure_2026.recursion.bt;


import java.util.HashSet;
import java.util.Set;

public class PermutationString {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("1234");
        permutationWithoutDuplicate(sb,0);
    }

    public static void permutation(StringBuilder sb, int i){
        if(i==sb.length()){
            System.out.println(sb.toString());
            return;
        }

        for (int k = i; k < sb.length(); k++) {
            //To avoid duplicate
            swap(sb,i,k);
//            System.out.println("i "+i+" k "+k);
            permutation(sb,i+1);
            swap(sb,k,i);
        }
    }

    public static void permutationWithoutDuplicate(StringBuilder sb, int i){
        if(i==sb.length()){
            System.out.println(sb.toString());
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int k = i; k < sb.length(); k++) {
            //To avoid duplicate
            if(set.contains(sb.charAt(k))){
                  continue;
            }
            set.add(sb.charAt(k));
            swap(sb,i,k);
//            System.out.println("i "+i+" k "+k);
            permutationWithoutDuplicate(sb,i+1);
            swap(sb,k,i);

        }
    }

    private static void swap(StringBuilder sb,int i, int j){
         char ch = sb.charAt(i);
         sb.setCharAt(i,sb.charAt(j));
         sb.setCharAt(j,ch);
    }


    private static void permutation(String ques, String ans){
        if(ques.isEmpty()){
            System.out.println(ans);
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i <ques.length() ; i++) {
            char ch = ques.charAt(i);
            if(!set.contains(ch)){
                String remain = ques.substring(0,i)+ques.substring(i+1);
                permutation(remain,ans+ch);
                set.add(ch);
            }
        }
    }
}
