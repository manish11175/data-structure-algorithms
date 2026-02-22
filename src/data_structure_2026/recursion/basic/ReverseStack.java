package data_structure_2026.recursion.basic;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(2);
        stack.add(4);
        stack.add(54);
        stack.add(32);
        stack.add(5);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    public static void reverse(Stack<Integer> stack) {
         if(stack.isEmpty()){
             return;
         }

          int last  = stack.pop();
          reverse(stack);
          addToLast(stack,last);
    }

    private static void addToLast(Stack<Integer> stack, int val) {
        if(stack.isEmpty()){
            stack.add(val);
            return;
        }

        int pop = stack.pop();
        addToLast(stack,val);
        stack.add(pop);
    }
}
