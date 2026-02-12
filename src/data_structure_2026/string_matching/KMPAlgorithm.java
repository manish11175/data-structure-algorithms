package data_structure_2026.string_matching;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String pattern ="ABAAAAA";
        String question = "QANABBAAAAAABAAAAAAAA";

        System.out.println(isContains(question,pattern));

    }

    private static boolean isContains(String question, String pattern){
        int[]lps = LPSArray2.getLps(pattern);

        int i=0;
        int j=0;
        while(j<pattern.length() && i<question.length()){
            if(question.charAt(i)==pattern.charAt(j)){
                i+=1;
                j+=1;
            }
            else if(j!=0){
                j=lps[j-1];
            }
            else{
                i+=1;
            }
        }
        return j==pattern.length();
    }
}
