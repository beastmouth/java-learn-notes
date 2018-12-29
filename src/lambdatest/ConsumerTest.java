package lambdatest;

import java.util.function.Consumer;

/**
 * @author huang
 * @version 1.0
 * @date 2018/12/29 10:23
 **/

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<Integer> consumer = x ->{
            int a = x + 2;
            System.out.println(a);
        };
        consumer.accept(10);
    }
}
