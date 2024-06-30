package data_structure.linked_list_questions;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappyNumber(2));
    }

    private static boolean isHappyNumber(int n) {
        int slow = n;
        int fast = n;
        do{
            slow=sumOfSquareOfDigit(slow);
            fast=sumOfSquareOfDigit(sumOfSquareOfDigit(fast));
            if(slow==1 || fast==1){
                return true;
            }
        }
        while(slow!=fast);
        System.out.println("Fast "+fast+" Slow "+slow);
        return false;
    }


    private static int sumOfSquareOfDigit(int n){
        int sum =0;
        while(n!=0){
            int rem = n % 10;
            sum+=(rem*rem);
            n/=10;
        }
        return sum;
    }
}
