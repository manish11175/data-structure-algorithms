package data_structure_2026.string_matching;

import java.util.Arrays;

public class LPSArray2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLps("AAABBAAAAAAAA")));
    }
    public static int[] getLps(String pat) {
        int[] lps = new int[pat.length()];

        int i = 0;
        int j = 1;

        while (j < pat.length()) {

            if (pat.charAt(i) == pat.charAt(j)) {
                i += 1;
                lps[j] = i;
                j += 1;
            } else if (pat.charAt(i) != pat.charAt(j) && i != 0) {
                i = lps[i - 1];
            } else {
                lps[j] = 0;
                j += 1;
            }
        }
        return lps;
    }
}
