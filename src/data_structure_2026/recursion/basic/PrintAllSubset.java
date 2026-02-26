package data_structure_2026.recursion.basic;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class PrintAllSubset {
    public static void main(String[] args) {
//        print("abc","");
//        Set<String> set=  new HashSet<>();
//        printUniqueSubset("aabc","",set);
//        System.out.println(set);
//        permutationWithSpace("ABC","");
//          permutationWithCase("ab","");

//        letterCasePermutation("a1b1c","");
//          generateAllBalancedParenthesis(3);
//        nBitPrefix1(3);
        josephProblem(40,7);
    }

    private static void print(String que,String ans){
        if(que.isEmpty()){
            System.out.println(ans);
            return;
        }

        char ch = que.charAt(0);
        String remain = que.substring(1);
        print(remain,ans+ch);
        print(remain,ans);
    }

    private static void printUniqueSubset(String que, String ans, Set<String> result){
        if(que.isEmpty()){
            result.add(ans);
            return;
        }
        char ch = que.charAt(0);
        String remain = que.substring(1);
        printUniqueSubset(remain,ans+ch,result);
        printUniqueSubset(remain,ans,result);
    }

    private static void permutationWithSpace(String ques,String ans){
        if(ques.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String remain = ques.substring(1);
        if(ans.isEmpty()){
            permutationWithSpace(remain,ans+ch); // This can be pass from request with single char to avoid extra check
        }
        else{
            permutationWithSpace(remain,ans+ch);
            permutationWithSpace(remain,ans+"_"+ch);
        }
    }

    private static void permutationWithCase(String que,String ans){
        if(que.isEmpty()){
            System.out.println(ans);
            return;
        }

        char ch = que.charAt(0);
        String remain = que.substring(1);
        permutationWithCase(remain,ans+toLowerCase(ch));
        permutationWithCase(remain,ans+toUpperCase(ch));
    }

    public static char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + ('a' - 'A'));
        }
        return ch; // return as it is if not uppercase
    }

    public static char toUpperCase(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char) (ch - ('a' - 'A'));
        }
        return ch; // return as it is if not lowercase
    }

    private static void letterCasePermutation(String que,String ans){
        if(que.isEmpty()){
            System.out.println(ans);
            return;
        }

        char ch =que.charAt(0);
        String remain = que.substring(1);
        if(ch>='0' && ch<='9'){
            letterCasePermutation(remain,ans+ch);
        }
        else{
            letterCasePermutation(remain,ans+toLowerCase(ch));
            letterCasePermutation(remain,ans+toUpperCase(ch));
        }
    }

    private static void generateAllBalancedParenthesis(int n){
        balancedParenthesisHelper(n,n,"");
    }

    private static void balancedParenthesisHelper(int open, int close, String ans) {
        if(open==0 && close==0){
            System.out.println(ans);
            return;
        }

        if(open!=0){
            balancedParenthesisHelper(open-1,close,ans+"(");
        }
        if(close>open){
            balancedParenthesisHelper(open,close-1,ans+")");
        }
    }
    private static void nBitPrefix1(int n){
        nbitHelper(n-1,1,0, "1");
    }

    private static void nbitHelper(int n,int ones, int zeros, String number) {
        if(n==0){
            System.out.println(number);
            return;
        }
        nbitHelper(n-1,ones+1,zeros,number+"1");
        if(ones>zeros){
            nbitHelper(n-1,ones,zeros+1,number+"0");
        }
    }

    private static void josephProblem(int n, int k){
        int[]arr= new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=i+1;
        }
        josephSolve(n,k,arr,0);
    }

    private static void josephSolve(int n, int k, int[] arr,int index) {
        if(n==1){
            System.out.println(arr[0]);
            return;
        }

         index = (index+(k-1))%arr.length;
         int[]temp = remove(arr,index);
         josephSolve(n-1,k,temp,index);
    }

    private static int[] remove(int[] arr, int index) {
        int[]temp= new int[arr.length-1];
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            if(index!=i){
                temp[j]=arr[i];
                j+=1;
            }
        }
        return temp;
    }
}
