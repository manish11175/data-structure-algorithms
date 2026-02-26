package data_structure_2026.revision.string_matching;

public class KmP {
    public static void main(String[] args) {
        String s= "aaaaaaaaaaaaab";
        String pat="aaaaba";
        System.out.println(isContains(s,pat));
    }

    public static boolean isContains(String ques, String pattern) {
        int[] lps = Lps.lps(pattern);

        int j = 0;
        int i = 0;
        while (i < ques.length() && j < pattern.length()) {
            if (ques.charAt(i) == pattern.charAt(j)) {
                i += 1;
                j += 1;
            } else if (ques.charAt(i) != pattern.charAt(j) && j != 0) {
                j = lps[j - 1];
            } else {
                i += 1;
            }
        }
        return j == pattern.length();
    }
}
