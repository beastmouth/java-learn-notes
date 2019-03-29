package datastructure.sort;

import java.util.Arrays;

import static datastructure.sort.HeapSort.swap;

/**
 * 堆
 * @author huang
 * @version 1.0
 * @date 2019/03/13 16:04
 **/
public class Heap {
    /**
     * 数组，从下标 1 开始存储数据
     */
    private int[] a;
    /**
     * 堆可以存储的最大数据个数
     */
    private int n;
    /**
     * 堆中已经存储的数据个数
     */
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        // 堆满了
        if (count >= n){
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        // 自下往上堆化
        while (i/2 > 0 && a[i] > a[i/2]) {
            // swap() 函数作用：交换下标为 i 和 i/2 的两个元素
            swap(a, i, i/2);
            i = i/2;
        }
    }

    public void removeMax() {
        // 堆中没有数据
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    /**
     * 自上往下堆化
     */
    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]){
                maxPos = i*2;
            }
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]){
                maxPos = i*2+1;
            }
            if (maxPos == i){
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private static void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    /**
     * n 表示数据的个数，数组 a 中的数据从下标 1 到 n 的位置。
     */
    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 1, 2, 44, 32, 6, 12, 456, 2};
        sort(array, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
