package thread;

import java.util.concurrent.ThreadFactory;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/07 22:14
 **/

public class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " create a new Thread");
        Thread t = new Thread(r);
        System.out.println(" created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println(" eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}
