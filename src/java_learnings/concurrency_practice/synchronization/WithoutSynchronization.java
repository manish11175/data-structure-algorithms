package java_learnings.concurrency_practice.synchronization;

/**
    Because count++ is not atomic. Internally it does:
    Read value
    Increment
    Write back
   Two threads interfere here.
**/

class Counter{
    int count =0;
    public void increment() {
        count++;
    }

}

//Race Condition
public class WithoutSynchronization {
    public static void main(String[] args)  throws Exception {
            Counter2 counter2 = new Counter2();

            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++)
                    counter2.increment();
            });

            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++)
                    counter2.increment();
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Final Count: " + counter2.count);

    }
}
