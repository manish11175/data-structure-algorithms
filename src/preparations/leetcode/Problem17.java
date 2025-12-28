package preparations.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem17 {
    private static final HashMap<Character,String> keyboard = new HashMap<>();

    static {
        keyboard.put('2',"abc");
        keyboard.put('3',"def");
        keyboard.put('4',"ghi");
        keyboard.put('5',"jkl");
        keyboard.put('6',"mno");
        keyboard.put('7',"pqrs");
        keyboard.put('8',"tuv");
        keyboard.put('9',"wxyz");
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("45999"));
    }

//    public static List<String> addCombinations(int index,List<String> arr,StringBuilder cw,String digit){
//    }


    public static List<String>  letterCombinations(String digits) {
          List<String> ans = new ArrayList<>();
          for(int i=0;i<digits.length();i++){
              char ch = digits.charAt(i);
              String str = keyboard.get(ch);
              char[]chars = str.toCharArray();
              if(ans.isEmpty()){
                  for(int k = 0;k<chars.length;k++){
                      ans.add(String.valueOf(chars[k]));
                  }
              }
              else {
                  ArrayList<String> temp = new ArrayList<>();
                  for (int j = 0; j<ans.size();j++){
                      for(int k = 0;k<chars.length;k++){
                          temp.add(ans.get(j)+chars[k]);
                      }
                  }
                  ans = temp;
              }
          }
          return ans;
    }
}
