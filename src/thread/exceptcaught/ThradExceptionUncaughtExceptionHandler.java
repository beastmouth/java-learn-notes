package thread.exceptcaught;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 22:19
 **/

public class ThradExceptionUncaughtExceptionHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread());

    }
}
