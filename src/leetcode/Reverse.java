package leetcode;

/**
 * 整数反转
 * 题目描述：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 *
 * @author hbj
 * @date 2019/8/12 10:52
 */
public class Reverse {
    public static int reverse(int x) {
        if (x > ((1 << 31) - 1) || x < (1 << 31)) {
            return 0;
        }
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }
        long resultNum = 0;
        while (x >= 1) {
            int number = x - x / 10 * 10;
            x = x / 10;
            if (resultNum * 10 > ((1 << 31) - 1)) {
                return 0;
            }
            resultNum = resultNum * 10 + number;
        }
        return isNegative ? (int) -resultNum : (int) resultNum;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
