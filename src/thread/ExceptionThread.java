package thread;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 22:18
 **/

public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(" run() by " + thread);
        System.out.println(" eh = " + thread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
