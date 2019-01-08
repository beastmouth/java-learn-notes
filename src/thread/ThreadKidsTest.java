package thread;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/08 16:43
 **/

public class ThreadKidsTest {
    public static void main(String[] args) {
        KidTread kidTread = new KidTread();
        kidTread.start();
        KidTread kidTread1 = new KidTread();
        kidTread1.start();
        System.out.println("I am parent thread ");
    }
}
