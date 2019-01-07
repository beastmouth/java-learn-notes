package thread;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 22:13
 **/

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(" caught this exception : " + e);
    }
}
