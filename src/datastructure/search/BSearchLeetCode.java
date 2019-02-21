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
//        int[] numbers = new int[]{4,5,6,7,0,1,2};
//        int[] numbers = new int[]{7,0,1,2,4,5,6};
//        int[] numbers = new int[]{6, 7, 0, 1, 2, 4, 5, 6};
//        int[] numbers = new int[]{3, 1};
//        System.out.println(search(numbers, 1));
    }

//    private static int search(int[] nums, int target) {
//        int low = 0;
//        int high = nums.length - 1;
//        int divideIndex = searchDivideIndex(nums, low, high);
//        if (divideIndex < 0) {
//            return -1;
//        }
//        if (target > nums[low]) {
//            if (divideIndex > 0) {
//                return searchNumIndex(nums, low, (divideIndex - 1), target);
//            } else {
//                return searchNumIndex(nums, divideIndex, high, target);
//            }
//        } else {
//            return searchNumIndex(nums, divideIndex, high, target);
//        }
//    }
//
//    private static int searchDivideIndex(int[] nums, int low, int high) {
//        if (low > high) {
//            return -1;
//        }
//        if (nums[low] < nums[high]) {
//            return 0;
//        }
//        int mid = low + ((high - low) >> 1);
//        if (nums[mid] < nums[low]) {
//            if (mid == low) {
//                return mid;
//            } else {
//                if (nums[mid] > nums[mid - 1]) {
//                    return searchDivideIndex(nums, low, mid - 1);
//                } else {
//                    return mid;
//                }
//            }
//        } else {
//            if (mid == high) {
//                return mid;
//            } else {
//                if (nums[mid] < nums[mid + 1]) {
//                    return searchDivideIndex(nums, mid + 1, high);
//                } else {
//                    return mid;
//                }
//            }
//        }
//    }
//
//    private static int searchNumIndex(int[] nums, int low, int high, int target) {
//        if (low > high) {
//            return -1;
//        }
//        int mid = low + ((high - low) >> 1);
//        if (nums[mid] == target) {
//            return mid;
//        } else if (nums[mid] > target) {
//            return searchNumIndex(nums, low, mid - 1, target);
//        } else {
//            return searchNumIndex(nums, mid + 1, high, target);
//        }
//    }

//    public int search(int[] nums, int target) {
//        int low = 0;
//        int high = nums.length - 1;
//        int mid = low + ((high - low) >> 1);
//        if (nums[mid] == target) {
//            return mid;
//        } else {
//            return searchTarget(nums, low, high, target);
//        }
//        else if (low < high) {
//            //有序的情况
//            return searchOrderly(nums, low, high, target);
//        } else {
//            //无序的情况
//            return searchUnOrderly(nums, low, high, target);
//        }
//    }

//    private int searchTarget(int[] nums, int low, int high, int target) {
//        if (low > high) {
//            return -1;
//        }
//        int mid = low + ((high - low) >> 1);
//        if (nums[mid] == target) {
//            return mid;
//        } else {
//            if (nums[mid] > nums[low]) {
//                if (nums[mid] > target) {
//                    return searchTarget(nums, low, mid - 1, target);
//                } else {
//                    return searchTarget(nums, mid + 1, high, target);
//                }
//            } else {
//                if (nums[mid] < nums[high]) {
//
//                } else {
//
//                }
//            }
//        }
//    }

//    private int searchOrderly(int[] nums, int low, int high, int target) {
//        if (low > high) {
//            return -1;
//        }
//        int mid = low + ((high - low) >> 1);
//        if (nums[mid] == target) {
//            return mid;
//        } else if (nums[mid] > target) {
//            return searchOrderly(nums, low, mid - 1, target);
//        } else {
//            return searchOrderly(nums, mid + 1, high, target);
//        }
//    }
//
//    private int searchUnOrderly(int[] nums, int low, int high, int target) {
//        if (low > high) {
//            return -1;
//        }
//        int mid = low + ((high - low) >> 1);
//        if (nums[mid] == target) {
//            return mid;
//        } else {
////            if (nums[mid] > nums[low] && nums[low] < target) {
////                searchOrderly(nums, low, mid - 1, target);
////            } else if (nums[mid] < nums[high] && nums[high] > target) {
////                searchOrderly(nums, mid + 1, high, target);
////            }
//            if (nums[mid] > nums[low]) {
//
//            } else {
//
//            }
//            if (nums[mid] < nums[high]) {
//
//            } else {
//
//            }
//
//        }
//    }

}
