package sliding_window.variable_sized_sliding_windoe;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
          String s = "bba";
          String t = "ab";
          System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        int i=0;
        int j=0;
        int count = map.size();
        int minsize= Integer.MAX_VALUE;
        int l=0;
        int r=0;

        while(j<s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    count-=1;
                }


                if(count==0){
                    int currentMinSize=(j-i)+1;

                    while(count==0){
                        char ch2 = s.charAt(i);
                        if(map.containsKey(ch2)){
                            map.put(ch2,map.get(ch2)+1);
                            if(map.get(ch2)>0){
                                count+=1;
                            }
                            else{
                                currentMinSize-=1;
                            }
                        }
                        else{
                            currentMinSize-=1;
                        }
                        i+=1;
                    }
                    if(minsize>currentMinSize){
                        l=i-1;
                        r=j+1;
                        minsize=currentMinSize;
                    }

                }
            }



            j+=1;

        }
        return s.substring(l,r);
    }
//    public static int minWindow(String s, String t) {
//        Map<Character,Integer> map = new HashMap<>();
//        for(int i=0;i<t.length();i++){
//            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
//        }
//
//        int i=0;
//        int j=0;
//        int count = map.size();
//        int minsize= Integer.MAX_VALUE;
//        while(j<s.length()){
//             char ch = s.charAt(j);
//             if(map.containsKey(ch)){
//                 map.put(ch,map.get(ch)-1);
//                 if(map.get(ch)==0){
//                     count-=1;
//                 }
//             }
//             if(count==0){
//                 System.out.println(map);
//                 System.out.println("A: "+s.substring(i,j+1));
//                 minsize = Math.min(minsize,j-i);
//                 while(count==0){
//                     char ch2 = s.charAt(i);
//                     if(map.containsKey(ch2)){
//                         map.put(ch2,map.get(ch2)+1);
//                         if(map.get(ch2)>0){
//                             count+=1;
//                         }
//                         else{
//                             System.out.println("B: "+s.substring(i,j+1));
//                             minsize = Math.min(minsize,j-i);
//                         }
//                     }
//                     else{
//                         System.out.println("C: "+s.substring(i,j+1));
//                         minsize = Math.min(minsize,j-i);
//                     }
//                     i+=1;
//                 }
//                 System.out.println(map);
//             }
//
//             j+=1;
//
//        }
//        return minsize;
//    }
}
