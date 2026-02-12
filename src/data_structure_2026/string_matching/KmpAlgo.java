package data_structure_2026.string_matching;

public class KmpAlgo {

    public static boolean isContains(String string, String pattern){
        int i =0;
        int j = 0;
        int[] lps = LpsArray.build(pattern);
        while(i<string.length() && j<pattern.length()){
            if(string.charAt(i)==pattern.charAt(j)){
                j+=1;
                i+=1;
            }
            else{
                if(j>0){
                    j = lps[j-1];
                }
                else {
                    i+=1;
                }
            }
        }
        return j == pattern.length();
    }
}
