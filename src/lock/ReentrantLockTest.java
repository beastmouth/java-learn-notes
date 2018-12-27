package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huang
 * @version 1.0
 * @date 2018/12/27 15:18
 **/

public class ReentrantLockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        lock.lock();
        lock.unlock();
    }
}
