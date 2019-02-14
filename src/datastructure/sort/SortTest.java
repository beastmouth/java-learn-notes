package datastructure.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 44, 32, 6, 12, 456, 2};
        int[] result = MergeSort.mergeSort(array);
        System.out.println(Arrays.toString(result));
    }
}
