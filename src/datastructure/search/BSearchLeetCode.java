package datastructure.search;

/**
 * problem description
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 *
 * @author huang
 * @version 1.0
 * @date 2019/02/14 17:01
 **/

public class BSearchLeetCode {
    public static void main(String[] args) {
        int[] numbers = new int[]{4,5,6,7,0,1,2};
    }


    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = low + ((high - low) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else if (low < high) {
            //有序的情况
            return searchOrderly(nums, low, high, target);
        } else {
            //无序的情况
            return -1;
        }
    }

    private int searchOrderly(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return searchOrderly(nums, low, mid - 1, target);
        } else {
            return searchOrderly(nums, mid + 1, high, target);
        }
    }

    private int searchUnOrderly(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else {
            if (nums[mid] > nums[low] && nums[low] < target) {
                searchOrderly(nums, low, mid - 1, target);
            } else if (nums[mid] < nums[high] && nums[high] > target) {
                searchOrderly(nums, mid + 1, high, target);
            }
        }
    }

}
