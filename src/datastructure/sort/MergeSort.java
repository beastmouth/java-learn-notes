package datastructure.sort;

/**
 * Happy Valentine's Day
 * @author huang
 * @version 1.0
 * @date 2019/02/14 10:47
 **/

public class MergeSort {
    public static int[] mergeSort(int[] array) {
        if (array.length <= 0) {
            throw new RuntimeException("数组不符合要求，无法排序");
        }
        int length = array.length;
        return mergeSortC(array, 0, length - 1);
    }

    private static int[] mergeSortC(int[] array, int p, int r) {
        if (p >= r) {
            return null;
        }
        int q = (p + r) / 2;
        mergeSortC(array, p, q);
        mergeSortC(array, q + 1, r);
        return merge(array, p, q, r);
    }

    private static int[] merge(int[] array, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] temp = new int[r - p + 1];
//        while (i <= q || j <= r) {
//            if (array[i] <= array[j] && i <= q) {
//                    temp[k] = array[i];
//                    i++;
//            } else {
//                temp[k] = array[j];
//                j++;
//            }
//            k++;
//        }
        while (i <= q && j <= r) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            temp[k++] = array[start++];
        }
        for (int t = 0; t < r - p + 1; t++) {
            array[p + t] = temp[t];
        }
        return array;
    }
}
