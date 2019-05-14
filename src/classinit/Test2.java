package classinit;

/**
 * @author huang
 * @version 1.0
 * @date 2019/02/27 14:43
 **/

class Father {
    public static int t1 = 10;

    static {
        t1 = 20;
    }
}

class Son extends Father {
    public static int t2 = t1;
}

public class Test2 {
    public static void main(String[] args) {
        System.out.println(Son.t2);
    }
}
