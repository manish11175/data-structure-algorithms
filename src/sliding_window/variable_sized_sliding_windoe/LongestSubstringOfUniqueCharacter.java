package sliding_window.variable_sized_sliding_windoe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringOfUniqueCharacter {
    public static void main(String[] args) {
         String s ="bba";
        System.out.println(longestSubStringOfUniqueCharacter3(s));
    }

    private static int longestSubStringOfUniqueCharacter(String s){

        Set<Character> set = new HashSet<>();
        int maxSize =0;
        int l =0;
        int r =0;

        while(r<s.length()){
            char ch = s.charAt(r);
            if(set.contains(ch)){
                maxSize=Math.max(maxSize,(r-l));
                while(s.charAt(l)!=ch){
                    set.remove(s.charAt(l));
                    l+=1;
                }
                set.remove(s.charAt(l));
                l+=1;
            }

            set.add(ch);
            r+=1;
        }
        maxSize=Math.max(maxSize,(r-l));
        return maxSize;
    }

    private static int longestSubStringOfUniqueCharacter2(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        int maxSize =0;
        int l =0;
        int r =0;

        while(r<s.length()){
            char ch = s.charAt(r);
            if(map.containsKey(ch) && map.get(ch)==1){
                maxSize=Math.max(maxSize,(r-l));
                while(s.charAt(l)!=ch){
                    map.put(s.charAt(l),0);
                    l+=1;
                }
                map.put(s.charAt(l),0);
                l+=1;
            }

            map.put(ch,1);
            r+=1;
        }
        maxSize=Math.max(maxSize,(r-l));
        return maxSize;
    }

    private static int longestSubStringOfUniqueCharacter3(String s){
        char[]map=new char[26];
        int maxSize =0;
        int l =0;
        int r =0;

        while(r<s.length()){
            char ch = s.charAt(r);
            if(map[ch-'a']==1){
                maxSize=Math.max(maxSize,(r-l));
                while(s.charAt(l)!=ch){
                    map[s.charAt(l)-'a']=0;
                    l+=1;
                }
                map[s.charAt(l)-'a']=0;
                l+=1;
            }

            map[ch-'a']=1;
            r+=1;
        }
        maxSize=Math.max(maxSize,(r-l));
        return maxSize;
    }
}
