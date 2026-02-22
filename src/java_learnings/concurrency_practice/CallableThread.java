package java_learnings.concurrency_practice;

import java.util.concurrent.Callable;

public class CallableThread implements Callable {
    @Override
    public Object call() throws Exception {
        return 1+1;
    }
}
