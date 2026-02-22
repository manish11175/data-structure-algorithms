package java_learnings.concurrency_practice;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread is running..............");
    }
//    ✅ Advantages
//
//✔ Simple and easy to understand
//✔ Good for beginners
//✔ Direct access to Thread methods
//
//❌ Disadvantages
//
//❌ Java does not support multiple inheritance → You cannot extend another class
//❌ Tightly coupled task and thread
//❌ Not suitable for large applications
}
