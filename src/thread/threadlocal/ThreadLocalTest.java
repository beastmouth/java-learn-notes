package thread.threadlocal;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/29 11:45
 **/

public class ThreadLocalTest {
    /**
     * 用ThreadLocal作为容器，当每个线程访问这个 userId 变量时，ThreadLocal会为每个线程提供一份变量，各个线程互不影响。
     */
    private static ThreadLocal<String> userId = ThreadLocal.withInitial(() -> "init_id");

    public static void main(String[] args) {
//        threadLocalAlone();
//        threadMemoryProblem();
        testThreadLocal();
    }

    private static void testThreadLocal() {
        ThreadLocal<String> name1 = ThreadLocal.withInitial(() -> "gl");
        name1.set("gl");
        ThreadLocal<String> name2 = ThreadLocal.withInitial(() -> "gl");
        name2.set("hbj");
        System.out.println("now thread is " + Thread.currentThread() + " " + name1.get());
        System.out.println("now thread is " + Thread.currentThread() + " " + name2.get());
    }

    private static void threadLocalAlone() {
        Thread thread1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1 userId is " + userId.get());
            userId.set("gl");
            System.out.println("Thread1 set userId " + userId.get());
        });

        Thread thread2 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2 userId is " + userId.get());
            userId.set("hbj");
            System.out.println("Thread2 set userId " + userId.get());
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void threadMemoryProblem() {
        Object[] entrys = new Object[0];
        try {
            entrys = getEntrys();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(entrys));

        System.out.println("初始化threadLocalMap的entrys数量为：" + getSize(entrys));

        ThreadLocal<String> userId = ThreadLocal.withInitial(() -> "init id");
        userId.set("id in main thread");

        System.out.println("设置userId后threadLocalMap的entrys数量为：" + getSize(entrys));

        System.out.println(Arrays.toString(entrys));
        // 失去Threadlocal对象的强引用，并且尝试调用gc回收
//        userId = null;
//        System.gc();
//        System.out.println("userId置null后threadLocalMap的entrys数量为：" + getSize(entrys));
//        System.out.println(Arrays.toString(entrys));

        userId.remove();
        System.out.println("userId置remove后threadLocalMap的entrys数量为：" + getSize(entrys));
        System.out.println(Arrays.toString(entrys));
    }

    // 获得数组中非null元素个数
    private static int getSize(Object[] objects) {
        int count = 0;
        for (Object object : objects) {
            if (object != null) {
                count++;
            }
        }
        return count;
    }

    // 通过反射获得ThreadLocalMap中的底层数组
    private static Object[] getEntrys() throws NoSuchFieldException, IllegalAccessException {
        Thread mainThread = Thread.currentThread();
        Field threadLocals = Thread.class.getDeclaredField("threadLocals");
        threadLocals.setAccessible(true);
        Object threadLocalMap = threadLocals.get(mainThread);
        Class threadLocalMapClass = null;
        try {
            threadLocalMapClass = Class.forName("java.lang.ThreadLocal$ThreadLocalMap");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field tableField = threadLocalMapClass.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(threadLocalMap);
        return table;
//        Class<?>[] declaredClasses = ThreadLocal.class.getDeclaredClasses();
//        Field table = declaredClasses[0].getDeclaredField("table");
//        table.setAccessible(true);
//        return (Object[]) table.get(threadLocalMap);
    }
}
