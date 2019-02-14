package datastructure.search;

/**
 * @author huang
 * @version 1.0
 * @date 2019/02/14 15:07
 **/

public class BSearch {
    public static int bSearch(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == value) {
                //原来的代码
                //return mid;

                //找重复数字的最后一个(不是最后一个就往后移动)
                if ((mid == n - 1) || (array[mid + 1] != value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }

            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int bSearch2(int[] array, int n, int value) {
        return bSearchInternally(array, 0, array.length - 1, value);
    }

    private static int bSearchInternally(int[] array, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] > value) {
            return bSearchInternally(array, low, mid - 1, value);
        } else {
            return bSearchInternally(array, mid + 1, high, value);
        }
    }

    /**
     * 二分查找变形问题
     * */
    public static int bSearch3(int[] array, int n, int value) {
        //寻找第一个大于给定元素的数
        return bSearchInternally2(array, 0, n - 1, value);
    }

    /**
     * 二分查找变形问题
     * */
    private static int bSearchInternally2(int[] array, int low, int high, int value) {
        //寻找第一个大于给定元素的数
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        //原先自己写的
//        if (array[mid] > value) {
//            if (array[mid - 1] >= value) {
//                return bSearchInternally2(array, low, mid - 1, value);
//            } else {
//                return mid;
//            }
//        } else {
//            return bSearchInternally2(array, mid + 1, high, value);
//        }
        if (array[mid] >= value) {
            //之前少了个判断条件 当他为第一个元素的时候 mid-1 等于 -1 超出数组的表示范围了
            if (mid == 0 || array[mid - 1] < value) {
                return mid;
            } else {
                return bSearchInternally2(array, low, mid - 1, value);
            }
        } else {
            return bSearchInternally2(array, mid + 1, high, value);
        }
    }

    /**
     * 二分查找变形问题
     * */
    public static int bSearch4(int[] array, int n, int value) {
        //寻找最后一个小于等于给定元素的数
        return bSearchInternally3(array, 0, n - 1, value);
    }

    /**
     * 二分查找变形问题
     * */
    private static int bSearchInternally3(int[] array, int low, int high, int value) {
        //寻找最后一个小于等于给定元素的数
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
//        原来写的
//        if (array[mid] >= value) {
//            return bSearchInternally3(array, low, mid - 1, value);
//        } else {
//            if (array[mid + 1] <= value) {
//                return bSearchInternally3(array, mid + 1, high, value);
//            } else {
//                return mid;
//            }
//        }
        if (array[mid] <= value) {
            if (mid == array.length - 1 || array[mid + 1] > value) {
                return mid;
            } else {
                return bSearchInternally3(array, mid + 1, high, value);
            }
        } else {
            return bSearchInternally3(array, mid + 1, high, value);
        }
    }
}
