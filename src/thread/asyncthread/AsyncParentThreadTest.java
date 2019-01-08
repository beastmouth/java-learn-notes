package thread.asyncthread;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/08 17:01
 **/

public class AsyncParentThreadTest {
    public static void main(String[] args) {
        System.out.println("parent thread begin");
        AsyncKidThread kidThread = new AsyncKidThread();
        kidThread.start();
        System.out.println("parent thread end");
    }
}
