package java_learnings.concurrency_practice.synchronization;

/**🔎 How synchronized Works Internally

Every object in Java has a monitor lock.

When a thread enters a synchronized method:

It acquires the object’s lock

Other threads must wait

Lock released after method finishes

🧱 Types of Synchronization
1️⃣ Method Level Synchronization
public synchronized void increment() {
    count++;
}


Lock is on the current object (this).

        2️⃣ Block Level Synchronization
public void increment() {
    synchronized(this) {
        count++;
    }
}


More flexible — you can synchronize only critical code.

        3️⃣ Static Synchronization
public static synchronized void display() {
    // synchronized on Class object
}


Lock is on Class object, not instance.

        🧠 Real-World Example (Bank Account)
class BankAccount {
    private int balance = 1000;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " withdrawing...");
            balance -= amount;
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable task = () -> account.withdraw(700);

        Thread t1 = new Thread(task, "User1");
        Thread t2 = new Thread(task, "User2");

        t1.start();
        t2.start();
    }
}


Without synchronization → both may withdraw
With synchronization → safe transaction ✅

        ⚠️ Disadvantages of Synchronization

❌ Slows performance (only one thread at a time)
❌ Can cause Deadlock
❌ Can reduce scalability
❌ Harder debugging

🚀 Modern Alternatives (Better in Production)

Instead of only synchronized, Java provides:

ReentrantLock

        AtomicInteger

ConcurrentHashMap

Executor framework

For example:

        import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }
}


Here no explicit synchronization needed.**/
class Counter2 {
    int count =0;
    //Now only one thread at a time can execute increment().
    public synchronized void increment() {
        count++;
    }

}

class Counter3{
    int count=0;
    public void increment(){
        synchronized(this){
            count+=1;
        }
    }
}

//Race Condition
public class WithSynchronization {
    public static void main(String[] args)  throws Exception {
        Counter2 counter2 = new Counter2();
        Counter3 counter3 = new Counter3();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                counter2.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter2.increment();
                counter3.increment();
            }
        });


        Thread t3 = new Thread(()->{
            for (int i = 0; i < 200 ; i++) {
                counter3.increment();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("Counter3 "+counter3.count);
        System.out.println("Final Count: " + counter2.count);

    }
}
