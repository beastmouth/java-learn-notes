package datastructure.sort;

/**
 * 堆排序
 *
 * @author huang
 * @version 1.0
 * @date 2019/01/09 21:03
 **/

public class HeapSort {
    public static int[] heapSort(int[] array) {
        //构建大顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(array, i, array.length);
        }
        //调整堆结构 交换堆顶元素与末尾元素
        for (int j = array.length - 1; j > 0; j--) {
            swap(array, 0, j);
            adjustHeap(array, 0, j);
        }
        return array;
    }

    public static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            if (array[k] > temp) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
            array[i] = temp;
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
