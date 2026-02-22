package data_structure_2026.recursion.basic;

import java.util.Stack;

public class DeleteMidStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(2);
        stack.add(4);
        stack.add(54);
        stack.add(32);
        stack.add(4);
        System.out.println(stack);
        deleteMid(stack);
        System.out.println(stack);
        deleteMid(stack);
        System.out.println(stack);
        deleteMid(stack);
        System.out.println(stack);
        deleteMid(stack);
        System.out.println(stack);
        deleteMid(stack);
        System.out.println(stack);
        deleteMid(stack);
        System.out.println(stack);
    }

    private static void deleteMid(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int mid = stack.size()/2+1;
        deleteMid(stack,mid);
    }

    private static void deleteMid(Stack<Integer> stack, int n) {
        if(n==1){
            stack.pop();
            return;
        }
        int top= stack.pop();
        deleteMid(stack,n-1);
        stack.add(top);
    }
}
