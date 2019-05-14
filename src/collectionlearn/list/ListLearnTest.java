package collectionlearn.list;

import java.util.LinkedList;

/**
 * @author huang
 * @version 1.0
 * @date 2019/01/08 22:26
 **/

public class ListLearnTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("3");
        linkedList.add(0, "2");
        System.out.println(linkedList.size());
        linkedList.remove("3");
        System.out.println(linkedList.size());
    }
}
