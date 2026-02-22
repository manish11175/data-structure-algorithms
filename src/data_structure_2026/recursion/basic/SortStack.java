package data_structure_2026.recursion.basic;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(2);
        stack.add(4);
        stack.add(54);
        stack.add(32);
        stack.add(4);
        System.out.println(stack);
        sort(stack);
        System.out.println(stack);
    }
    private static void sort(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        int val= stack.pop();
        sort(stack);

        if(stack.isEmpty()){
            stack.add(val);
        }
        else{
            Stack<Integer> helper=  new Stack<>();
            while(!stack.isEmpty()){
                 helper.add(stack.pop());
            }
            boolean isAdded = false;
            while (!helper.isEmpty()){
                Integer top= helper.pop();
                if(val<top && !isAdded){
                    stack.add(val);
                    isAdded=true;
                }
                stack.add(top);
            }
            if(!isAdded){
                stack.add(val);
            }
        }
    }
}
