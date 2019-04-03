package datastructure.sort;

import java.util.Arrays;

/**
 * 应用场景 ： 微博热搜TOP10 之类
 * @author huang
 * @version 1.0
 * @date 2019/04/03 11:00
 **/

public class HeapSortMine {
    private static final int NUM_TWO = 2;

    /**
     * 构建大顶堆
     *
     * @param array 需要构建的数组
     * @author hbj
     * @return int[] 大顶堆数组
     * @date 2019/04/03
     */
    private static int[] buildHeap(int[] array) {
        int len = array.length;
        // 从倒数第一个非叶子节点开始调整
        for (int i = len / NUM_TWO - 1; i >= 0; i--) {
            HeapSortMine.adjustHeap(array, i, len);
        }
        return array;
    }

    private static int[] heapSort(int[] array) {
        int len = array.length;
        for (int i = len - 1; i >= 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }
        return array;
    }

    /**
     * 调整大顶堆
     *
     * @param array 需要调整的数组
     * @param i 调整的起始位置
     * @param length 数组的长度
     * @author hbj
     * @date 2019/04/03
     */
    private static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = i * NUM_TWO + 1; k < length; k = k * NUM_TWO + 1) {
            // 节点与左右孩子比较
            if (k + 1 < length && array[k] < array[k + 1]) {
                k = k + 1;
            }
            if (array[i] < array[k]) {
                array[i] = array[k];
                //
                i = k;
            } else {
                break;
            }
            array[i] = temp;
        }
    }

    private static void swap(int[] array,int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 44, 32, 6, 12, 456, 2};
        int[] buildResult = HeapSortMine.buildHeap(array);
        System.out.println(Arrays.toString(buildResult));
        int[] sortResult = HeapSortMine.heapSort(buildResult);
        System.out.println(Arrays.toString(sortResult));
    }
}
