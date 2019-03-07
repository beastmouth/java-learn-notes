package util;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huang
 * @version 1.0
 * @date 2019/02/28 10:38
 **/

public class RandomArray {
    public static Set<Integer> createNonRepeatArray(int min, int max, int setSize) {
        Set<Integer> numSet = new HashSet<>();
        while (numSet.size() < setSize) {
            numSet.add(min + (int) (Math.random() * (max - min + 1)));
        }
        return numSet;
    }

    public static void main(String[] args) {
        Set<Integer> numSet = RandomArray.createNonRepeatArray(0, 100, 10);
        System.out.println(numSet);
    }
}
