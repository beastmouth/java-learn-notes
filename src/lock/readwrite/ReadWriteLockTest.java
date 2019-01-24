package lock.readwrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/24 16:51
 **/

public class ReadWriteLockTest {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        for (int i = 0; i < 3; i++) {
            ReadThread readThread = new ReadThread(readWriteLock);
            readThread.start();
            System.out.println("当前执行的读线程为：" + readThread.getName());
        }
        for (int i = 0; i < 2; i++) {
            WriteThread writeThread = new WriteThread(readWriteLock);
            writeThread.start();
            System.out.println("当前执行的写线程为：" + writeThread.getName());
        }
        for (int i = 0; i < 3; i++) {
            ReadThread readThread = new ReadThread(readWriteLock);
            readThread.start();
            System.out.println("当前第二次执行的读线程为：" + readThread.getName());
        }
    }
}

class ReadThread extends Thread {

    private final ReadWriteLock readWriteLock;

    public ReadThread(ReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void run() {
        readWriteLock.readLock().lock();
        try {
            Thread.sleep(2000);
            System.out.println("this is read lock " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
            System.out.println("this is read lock unlocked " + Thread.currentThread().getName());
        }
    }
}

class WriteThread extends Thread {

    private final ReadWriteLock readWriteLock;

    public WriteThread(ReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void run() {
        readWriteLock.writeLock().lock();
        try {
            Thread.sleep(3000);
            System.out.println("this is write lock" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
            System.out.println("this is write lock unlocked" + Thread.currentThread().getName());
        }
    }
}