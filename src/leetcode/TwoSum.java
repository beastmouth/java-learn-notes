package leetcode;

/**
 * @author hbj
 * @date 2019/8/8 14:33
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[4];
        nums[0] = 2;
        nums[1] = 7;
        nums[2] = 11;
        nums[3] = 15;
        int target = 9;
        int[] twoSum = TwoSum.twoSum(nums, target);
        if (twoSum != null) {
            System.out.println("[" + twoSum[0] + "," + twoSum[1] + "]");
        }
    }
}
