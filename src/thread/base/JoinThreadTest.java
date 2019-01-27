package thread.base;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/27 16:25
 **/

public class JoinThreadTest {
    public static void main(String[] args) {
        JoinThread joinThread = new JoinThread();
        joinThread.start();
        JoinThread joinThread1 = new JoinThread();
        joinThread1.start();
        try {
            //主线程需要等待子线程执行完成后才能执行
            // 为什么要用join 可能是因为主线程需要等待子线程执行结束后的结果
            joinThread.join(10000);
            joinThread1.join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after waiting");
    }
}


class JoinThread extends Thread {
    @Override
    public void run() {
        System.out.println("hello I am join thread");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}