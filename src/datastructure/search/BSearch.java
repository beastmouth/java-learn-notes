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
                return mid;
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

    public static int bSearchInternally(int[] array, int low, int high, int value) {
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
}
