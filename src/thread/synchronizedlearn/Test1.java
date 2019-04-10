package thread.synchronizedlearn;

/**
 * @author huang
 * @version 1.0
 * @date 2019/04/10 10:45
 **/

public class Test1 implements Runnable {
    static Test1 instanceOne = new Test1();
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        // 两个线程用到了同一个实例 那么他们会共用到了这个实例中的方法
        Thread t1 = new Thread(instanceOne);
        Thread t2 = new Thread(instanceOne);
        t1.start();
        t2.start();
        // t1 t2 执行完后主线程才执行
        t1.join();
        t2.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            // 三个动作
            // 读取 i 的值
            // i++
            // 写入内存
            i++;
        }
    }
}
