package data_structure_2026.recursion.basic;

public class KthSymbolGrammar {
    public static void main(String[] args) {
       int ans = generateKthGrammar(3,4);
        System.out.println(ans);
    }

    private static int generateKthGrammar(int n, int k) {
        System.out.println(n+" "+k);
        if(n==1 && k==1){
            return 0;
        }
        int total = (int)Math.pow(2,n-1);

        int mid = total/2;
        if(k>total){
            return -1;
        }
        if(k<=mid){
           return generateKthGrammar(n-1,k);
        }
        else{
           return (generateKthGrammar (n-1,k-mid)) == 0 ? 1: 0;
        }
    }


}
