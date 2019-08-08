package leetcode;

/**
 * 无重复字符的最长子串
 *
 * @author hbj
 * @date 2019/8/8 18:57
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String str) {
        int length = 0;
        char[] chars = str.toCharArray();
        if (chars.length == 1) {
            return 1;
        }
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            temp = i;
            for (int j = i + 1; j < chars.length; j++) {
                int k = i;
                if (chars[i] == chars[j]) {
                    length = length > j - i ? length : j - i;
                    break;
                }
                while (j > k) {
                    if (chars[k] == chars[j]) {
                        length = length > k - i ? length : k - i;
                        break;
                    }
                    k++;
                }
                if (j == (chars.length - 1)) {
                    length = length > j - i ? length : j - i;
                    break;
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String str = "au";
        int length = LengthOfLongestSubstring.lengthOfLongestSubstring(str);
        System.out.println("不含重复字符的最长子串长度为：" + length);
    }
}
