package data_structure_2026.recursion.basic;

public class PringN{
    public static void main(String[] args) {
        print(1);
        System.out.println(factorial(4));
    }
    private static void print(int n){
        //base condition
        if(n==0){
            return;
        }
        print(n-1);
        System.out.println(n);
    }

    private static int factorial(int n){
        if(n==0||n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}