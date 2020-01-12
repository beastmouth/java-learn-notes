package leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 1
 * 12
 * 123
 * 1234
 *
 * @author hbj
 * @date 2020/1/12 13:33
 */
public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        for (; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                break;
            }
        }
        return i == j || i == j + 1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}
