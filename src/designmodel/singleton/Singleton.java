package designmodel.singleton;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/08 14:10
 **/

public class Singleton {
    private volatile static Singleton singleton;

    public Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                //防止jvm重排序  其他线程新建了singleton 给它分配了内存空间 但是没有赋值
                //此时如果该线程获取singleton的时候 则会得到一个null报错 所以需要在判断一次
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
