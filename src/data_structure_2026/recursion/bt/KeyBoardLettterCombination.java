package data_structure_2026.recursion.bt;

import java.util.ArrayList;

public class KeyBoardLettterCombination {
    public static void main(String[] args) {
        String digit ="234";
        ArrayList<String> res = new ArrayList<>();
        solve(digit,0,res,new StringBuilder());
        System.out.println(res);
    }
    private static void solve(String digit, int start, ArrayList<String> res, StringBuilder sb){
          if(start==digit.length()){
              res.add(sb.toString());
              return;
          }
          String keyword = getKeyWord(digit.charAt(start));
          for (int i = 0; i < keyword.length() ; i++) {
              sb.append(keyword.charAt(i));
              solve(digit,start+1,res,sb);
              sb.deleteCharAt(sb.length()-1);//remove last char
          }
    }


    private static String getKeyWord(char ch){
       return switch (ch){
            case  '2'->"abc";
            case '3'->"def";
            case '4'->"ghi";
            case '5'->"ijk";
            case '6'-> "lmn";
            case '7'-> "pqsr";
            case '8'-> "tuv";
            case '9'->"wxyz";
            default -> "unknown";
        };
    }
}
