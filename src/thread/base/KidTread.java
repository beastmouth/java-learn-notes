package thread.base;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/08 16:43
 **/

public class KidTread extends Thread {
    @Override
    public void run() {
        System.out.println("I am kid thread " + getName());
    }
}
