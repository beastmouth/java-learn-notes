package thread.exceptcaught;

import thread.exceptcaught.ChildThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 22:39
 **/

public class TestCallableThread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Future future = executorService.submit(new ChildThread());
        try {
            future.get();
        } catch (InterruptedException e) {
            System.out.println(String.format("handle exception in child thread. %s", e));
        } catch (ExecutionException e) {
            System.out.println(String.format("handle exception in child thread. %s", e));
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
        System.out.println("ending");
    }
}
