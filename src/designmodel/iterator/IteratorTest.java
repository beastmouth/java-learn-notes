package designmodel.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author huang
 * @version 1.0
 * @date 2018/12/26 17:48
 **/

public class IteratorTest {
    public static void main(String[] args) {
        WalkToHeart walkToHeart = new WalkToHeart();
        for (int i = 0; i < 12; i++) {
            walkToHeart.append("== " + i + " step to heart==");
        }

        List<String> heart = new ArrayList<>();
        Iterator<String> it = walkToHeart.iterator();
        while (it.hasNext()) {
            String heartStr = it.next();
            System.out.println(heartStr);
            if (heartStr.contains("10") || heartStr.contains("8")) {
                heart.add(heartStr);
            }
        }
        System.out.println("See heart :" + heart);
    }
}
