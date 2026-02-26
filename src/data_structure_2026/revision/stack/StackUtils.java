package data_structure_2026.revision.stack;

import java.util.Stack;

class Pair{
    int key;
    int value;
    Pair(int key,int value){
        this.key=key;
        this.value=value;
    }
}

public class StackUtils {
    public static int[] nearestGreaterToLeft(int[]arr){
        int n = arr.length;
        int [] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        int i =0;
        while(i<n){
            if(stack.isEmpty()){
                stack.add(arr[i]);
                ans[i]=-1;
            }
            else{
                while(!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=stack.peek();
                }
                stack.add(arr[i]);
            }

            i+=1;
        }
        return ans;
    }
    public static int[] nearestGreaterToRight(int[]arr){
        int n = arr.length;
        int [] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        int i =n-1;
        while(i>=0){
            if(stack.isEmpty()){
                stack.add(arr[i]);
                ans[i]=-1;
            }
            else{
                while(!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=stack.peek();
                }
                stack.add(arr[i]);
            }

            i-=1;
        }
        return ans;
    }
    public static int[] nearestSmallerToLeft(int[]arr){
        int n = arr.length;
        int [] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        int i =0;
        while(i<n){
            if(stack.isEmpty()){
                stack.add(arr[i]);
                ans[i]=-1;
            }
            else{
                while(!stack.isEmpty() && stack.peek()>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=stack.peek();
                }
                stack.add(arr[i]);
            }

            i+=1;
        }
        return ans;
    }
    public static int[] nearestSmallestToRight(int[]arr){
        int n = arr.length;
        int [] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        int i =n-1;
        while(i>=0){
            if(stack.isEmpty()){
                stack.add(arr[i]);
                ans[i]=-1;
            }
            else{
                while(!stack.isEmpty() && stack.peek()>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=stack.peek();
                }
                stack.add(arr[i]);
            }

            i-=1;
        }
        return ans;
    }

    public static int[] nearestGreaterIndexToLeft(int[]arr){
        int n = arr.length;
        int [] ans = new int[n];

        Stack<Pair> stack = new Stack<>();

        int i =0;
        while(i<n){
            if(stack.isEmpty()){
                stack.add(new Pair(arr[i],i));
                ans[i]=-1;
            }
            else{
                while(!stack.isEmpty() && stack.peek().key<=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=stack.peek().value;
                }
                stack.add(new Pair(arr[i],i));
            }

            i+=1;
        }
        return ans;
    }
    public static int[] nearestGreaterIndexToRight(int[]arr){
        int n = arr.length;
        int [] ans = new int[n];

        Stack<Pair> stack = new Stack<>();

        int i =n-1;
        while(i>=0){
            if(stack.isEmpty()){
                stack.add(new Pair(arr[i],i));
                ans[i]=-1;
            }
            else{
                while(!stack.isEmpty() && stack.peek().key<=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=stack.peek().value;
                }
                stack.add(new Pair(arr[i],i));
            }

            i-=1;
        }
        return ans;
    }
    public static int[] nearestSmallerIndexToLeft(int[]arr){
        int n = arr.length;
        int [] ans = new int[n];

        Stack<Pair> stack = new Stack<>();

        int i =0;
        while(i<n){
            if(stack.isEmpty()){
                stack.add(new Pair(arr[i],i));
                ans[i]=-1;
            }
            else{
                while(!stack.isEmpty() && stack.peek().key>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=stack.peek().value;
                }
                stack.add(new Pair(arr[i],i));
            }

            i+=1;
        }
        return ans;
    }
    public static int[] nearestSmallestIndexToRight(int[]arr){
        int n = arr.length;
        int [] ans = new int[n];

        Stack<Pair> stack = new Stack<>();

        int i =n-1;
        while(i>=0){
            if(stack.isEmpty()){

                stack.add(new Pair(arr[i],i));
                ans[i]=-1;
            }
            else{
                while(!stack.isEmpty() && stack.peek().key>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=stack.peek().value;
                }
                stack.add(new Pair(arr[i],i));
            }

            i-=1;
        }
        return ans;
    }
}
