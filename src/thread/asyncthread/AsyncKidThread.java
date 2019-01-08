package thread.asyncthread;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/08 16:58
 **/

public class AsyncKidThread extends Thread {
    @Override
    public void run() {
        System.out.println(" kids begin ");
        throw new RuntimeException("error");
    }

}
