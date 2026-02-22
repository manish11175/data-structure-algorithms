package java_learnings.java_8.function_interface;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = (a,b)->a*b;
        System.out.println(calculator.sum(5,6));
    }
}
