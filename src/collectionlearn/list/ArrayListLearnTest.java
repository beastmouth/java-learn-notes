package collectionlearn.list;

import java.util.ArrayList;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/14 15:52
 **/

public class ArrayListLearnTest {
    public static void main(String[] args) {
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(3);
        testList.add(6);
        testList.add(7);
        testList.add(1);
        testList.add(2);
        testList.add(4);
        testList.add(8);
        testList.add(10);
        testList.add(5);
        testList.sort(Integer::compareTo);
        testList.forEach(System.out::print);
    }
}
