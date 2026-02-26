package data_structure_2026.recursion.basic;

public class Substring {
    public static void main(String[] args) {
        String ques ="abc";
        String ans="";
        printSubset(ques,ans);
    }

    private static void printSubset(String ques, String ans) {
        if(ques.isEmpty()){
            if(!ans.isEmpty()){
                System.out.println(ans);
            }
            return;
        }

        char ch = ques.charAt(0);
        printSubset(ques.substring(1),ans+ch);
        printSubset(ques.substring(1),ans);
    }
}
