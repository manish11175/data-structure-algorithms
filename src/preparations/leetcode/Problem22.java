package preparations.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem22 {
    public static void main(String[] args) {
        int n = 3;
        List<String> parenthesis = generateParenthesis(n);
        System.out.println(parenthesis);
    }

    private static List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        generateParenthesis(0,0,parenthesis,str,n);
        return parenthesis;
    }

    private static void generateParenthesis(int left, int right, List<String> parenthesis, StringBuilder str, int n) {
        if(str.length()==n*2){
            parenthesis.add(str.toString());
            return;
        }

        if(left<n){
            str.append("(");
            generateParenthesis(left+1,right,parenthesis,str,n);
            str.deleteCharAt(str.length()-1);
        }

        if(right<left){
            str.append(")");
            generateParenthesis(left,right+1,parenthesis,str,n);
            str.deleteCharAt(str.length()-1);
        }
    }
}
