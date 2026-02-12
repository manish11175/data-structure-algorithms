package data_structure_2026.stack;

import java.util.Arrays;
import java.util.Stack;


public class StockSpanProblem {

    public static void main(String[] args) {
        int[] stock = new int[]{100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(stackSpan(stock)));
    }

    private static int[] stackSpan(int[] stocks) {
        Stack<Pair> stack = new Stack<>();
        int[] ans = new int[stocks.length];
        for (int i = 0; i < stocks.length; i++) {

            while (!stack.isEmpty() && stack.peek().getKey() <= stocks[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty()?i-(-1): i - stack.peek().getValue();
            stack.add(new Pair(stocks[i], i));
        }
        return ans;
    }
}
