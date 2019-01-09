package lambdatest;

import java.util.*;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/09 18:58
 **/

public class LambdaLearnTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        new Thread(() -> System.out.println("In Java8, Lambda expression rocks !!")).start();


        List<String> nameList = Arrays.asList("z", "a", "b", "c", "e", "j", "f");
        nameList.forEach(System.out::print);
        System.out.println();
        Collections.sort(nameList, (a, b) -> a.compareTo(b));
        nameList.forEach(System.out::print);
    }
}
