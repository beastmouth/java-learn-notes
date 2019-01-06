package sort;

public class BubbleSort {
    // 最佳情况: T(n) = O(n), 最差情况: T(n) = O(n2), 平均情况: T(n) = O(n2)
    public static int[] bubbleSort(int[] array) {
        int length = array.length;
        //外层循环 由元素个数决定 筛选出每次循环的最大值
        for (int i = 0; i < length; i++) {
            //内层循环 有比较次数控制  n次循环 前n个大数就被确定下来 比较次数就在递减
            for (int j = 1; j < length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

    //优化版  int[] array = new int[]{1, 2, 44, 32, 6, 12, 456, 2};
    public static int[] bubbleSortBetter1(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    isSorted = false;
                }
            }
            // 如果已经有序的话 则不比较 直接跳出循环
            if (isSorted) {
                break;
            }
        }
        return array;
    }

    //鸡尾酒排序  定点起泡排序 排序时是以双向在序列中进行排序的  [未看]
    public static int[] cocktailSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            for (int j = length - 1 - (i + 1); j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }
}
