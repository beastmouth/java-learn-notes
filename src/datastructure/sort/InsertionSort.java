package datastructure.sort;

public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            int temp = array[i];
            int j = i - 1;
            //原先排好的部分 后边的肯定大于前面的 所以就一直后移
            while (j >= 0 && (array[j] > temp)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }

        return array;
    }
}
