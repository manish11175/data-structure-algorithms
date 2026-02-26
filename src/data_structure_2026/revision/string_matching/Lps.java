package data_structure_2026.revision.string_matching;

public class Lps {
    public static int[]lps(String pattern){
        int[]lps = new int[pattern.length()];
        int len =0;
        int i=1;
        while(i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len+=1;
                lps[i]=len;
                i+=1;
            }
            else{
                if (len==0){
                    lps[i]=0;
                    i+=1;
                }
                else{
                    //fallback to previous lps
                    len=lps[len-1];
                }
            }
        }
        return lps;
    }
}
