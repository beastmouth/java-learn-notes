package collectionlearn.map;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/11 15:31
 **/

public class HashMapLearnTest {
    public static void main(String[] args) {
        float number = 98.343f;
        System.out.println(number != number);

        String aaa = "bbb";

        int i = (16 - 1) & aaa.hashCode();
        System.out.println("桶 为 ：" + i);
    }
}
