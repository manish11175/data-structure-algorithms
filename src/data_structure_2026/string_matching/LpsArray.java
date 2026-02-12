package data_structure_2026.string_matching;

import java.util.Arrays;

public class LpsArray {

    public static void main(String[] args) {
        String pattern = "abcabcababd";
        int[] lps = build(pattern);
//        System.out.println(getLpsCount(5,pattern));
        System.out.println(Arrays.toString(lps));
    }

    public static int[] build(String pattern) {
        int[] lps = new int[pattern.length()];

        int i = 1;
        int len = 0;
        while(i<pattern.length()){
            if(pattern.charAt(len)==pattern.charAt(i)){
                len+=1;
                lps[i]=len;
                i+=1;
            }
            else{
                if(len==0){
                    lps[i]=0;
                    i+=1;
                }
                else{
                    len=lps[len-1];
                }
            }
        }
        return lps;
    }

}
