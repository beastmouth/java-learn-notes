package datastructure.sort;

public class ShellSort {
    public static int[] shellSort(int[] array) {
        int length = array.length;
        //分割的组数
        int groups = 2;
        int nums = length / groups;
        while (nums >= 1) {
            //循环次数和组数相同
            for (int i = 0; i < groups; i++) {
                for (int j = i + nums; j < length; j += nums) {
                    int temp = array[j];
                    int k = j - nums;
                    //直接插入排序
                    //右移数据用循环
                    while (k >= i && array[k] > temp) {
                        array[k + nums] = array[k];
                        k -= nums;
                    }
                    //插入数据
                    array[k + nums] = temp;
                }
            }
            nums = nums / 2;
        }
        return array;
    }

}
