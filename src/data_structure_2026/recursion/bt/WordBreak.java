package data_structure_2026.recursion.bt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class WordBreak {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("sand");
        dict.add("and");
        dict.add("dog");
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String>temp = new ArrayList<>();
        solve("catsanddog",0,dict,res,temp);
        System.out.println(res);
    }

    private static void solve(String str, int start, Set<String> dict, ArrayList<String> res, ArrayList<String> temp) {
        if(str.length()==start){
            String s = String.join(" ", temp);
            res.add(s);
            return;
        }
        String s = "";
        for(int i=start;i<str.length();i++){
            s+=str.charAt(i);
            if(dict.contains(s)){
                temp.add(s);
                solve(str,i+1,dict,res,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
