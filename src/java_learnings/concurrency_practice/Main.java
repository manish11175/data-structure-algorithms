package java_learnings.concurrency_practice;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        System.out.println(thread.getState());
//        thread.start();
//        System.out.println(thread.getId()+" "+thread.getName());
//
        Switchable switch1 = new Switchable();
//        switch1.run();

        Thread thread2 =  new Thread(()->{
            System.out.println("Thread 2 is executing....................");
        });


        Callable callableThread =new CallableThread();
        ExecutorService service =  Executors.newSingleThreadExecutor();
        Future<Object> value = service.submit(callableThread);
        try {
            System.out.println("Callable"+value.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        Runnable a = ()->{
            thread.start();
            System.out.println(thread.getState());
            switch1.run();
            System.out.println(thread.getState());
            thread2.start();
        };

        a.run();

    }
}
