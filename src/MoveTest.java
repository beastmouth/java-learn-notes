/**
 * @author huang
 * @version 1.0
 * @date 2018/12/29 14:51
 **/

public class MoveTest {
    public static void main(String[] args) {
        int a = 10;
        int b = a + (a >> 1) + 1;
        System.out.println(b);

        int[] testA = new int[]{1, 2, 3};
        int[] testB = testA;
        if (testA == testB) {
            System.out.println("111");
        }else {
            System.out.println("222");
        }
    }
}
