package datastructure.sort;

public class QuickSort {
    //不稳定的排序算法 基数和开始的地方要相反
    public static int[] quickSort(int[] array, int l, int r) {
        if (l < r) {
            int i, j, x;
            i = l;
            j = r;
            x = array[i];
            while (i < j) {
                // 从右向左找第一个小于x的数
                while (i < j && array[j] > x) {
                    j--;
                    System.out.println("j = " + j);
                }
                // 减少同一位置赋值
                if (i < j) {
                    array[i++] = array[j];
                    System.out.println("i = " + i + " array[i++] = " + array[i] + " j = " + j + " array[j] = " + array[j]);
                }
                // 从左向右找第一个大于x的数
                while (i < j && array[i] < x) {
                    i++;
                    System.out.println("i = " + i);
                }
                if (i < j) {
                    array[j--] = array[i];
                    System.out.println("j = " + j + " array[j--] = " + array[j] + " i = " + i + " array[i] = " + array[i]);
                }
            }
            array[i] = x;
            System.out.println("array[i] = " + array[i]);
            System.out.println("此时 i = " + i + " j = " + j);
            quickSort(array, l, i - 1);
            quickSort(array, i + 1, r);
        }
        return array;
    }
}
