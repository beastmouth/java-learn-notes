package classinit;

/**
 * @author huang
 * @version 1.0
 * @date 2019/02/27 14:33
 **/

public class Test1 {
    static {
        t = 10;
//        System.out.println(t);
    }

    static int t = 0;

    static {
        t = 10;
        System.out.println(t);
    }
}
