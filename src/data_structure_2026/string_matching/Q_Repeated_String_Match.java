package data_structure_2026.string_matching;

public class Q_Repeated_String_Match {
    public static void main(String[] args) {
        String a = "baa";
        String b = "abaab";

        int[]lps=LpsArray.build(b);

        int i =0;
        int j = 0;
        int count = 0;
        int end = ((b.length() / a.length()) * 2)+2;

        while(count<end && j<b.length()){
            if(a.charAt(i)==b.charAt(j)){
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
            if(i==a.length() && j!=b.length()){
                i=0;
                count+=1;
            }
        }
        if(j==b.length()){
            System.out.println(count+1);
        }
        else{
            System.out.println(-1);
        }

    }
}
