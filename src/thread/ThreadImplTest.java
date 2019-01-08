package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/08 13:53
 **/

public class ThreadImplTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new TestRunnableThread());
        executorService.execute(new TestExtendThread());

    }
}
