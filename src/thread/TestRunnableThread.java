package thread;

/**
 * 实现Runnable接口实现线程
 * @author huang
 * @version 1.0
 * @date 2019/01/08 13:56
 **/

public class TestRunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("hello runnable");
    }
}
