package thread;

/**
 * 继承Thread类实现线程
 * @author huang
 * @version 1.0
 * @date 2019/01/08 14:15
 **/

public class TestExtendThread extends Thread {
    @Override
    public void run() {
        System.out.println("hello extend thread");
    }
}
