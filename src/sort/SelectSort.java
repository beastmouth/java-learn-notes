package sort;

public class SelectSort {
    //首先在待排序序列中找到最小元素, 放在起始处,
    // 然后找到第二小元素, 放在起始处之后, 依次类推
    public static int[] selectSort(int[] array) {
        int length = array.length;
        int minIndex;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            //每次找出最小的元素
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }
}
