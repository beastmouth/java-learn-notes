package classinit;

/**
 * @author huang
 * @version 1.0
 * @date 2019/02/27 14:50
 **/

class FatherClass {
    static {
        System.out.println("FatherClass init");
    }

    public static int value1 = 10;
    public static final String value2 = "hello";
}

class SonClass extends FatherClass {
    static {
        System.out.println("SonClass init");
    }
}

public class Test3 {
    public static void main(String[] args) {
//        System.out.println(SonClass.value);
//        SonClass[] sonClasses = new SonClass[10];
        System.out.println(FatherClass.value2);

    }
}
