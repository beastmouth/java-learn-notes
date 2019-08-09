package leetcode;

/**
 * 无重复字符的最长子串
 *
 * @author hbj
 * @date 2019/8/8 18:57
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int length = 0;
        int i = 0;
        while (i < chars.length) {
            int j = i + 1;
            while (j < chars.length) {
                int flag = 0;
                for (int k = i; k < j; k++) {
                    if (chars[j] == chars[k]) {
                        flag = 1;
                        length = length > j - i ? length : j - i;
                        i++;
                        break;
                    }
                }
                if (flag == 1)
                    break;
                j++;
            }
            if (j == chars.length) {
                length = length > j - i ? length : j - i;
                break;
            }
        }
        return length;
    }

    /**
     * 大佬代码
     * @param s 字符串
     * @return 最长字符串长度
     */
    public static int lengthOfLongestSubstring2(String s) {
        // 记录最长字符串长度
        int max = -1;
        int head = 0;
        int tail = 0;
        while (tail < s.length()) {
            int temp = s.indexOf(s.charAt(tail), head);
            // 发现重复
            if (temp != tail) {
                head = temp + 1;
            }
            max = max > (tail-head) ? max : (tail-head);
            tail++;
        }
        return max + 1;
    }

    public static void main(String[] args) {
        String str = "xcxv";
        int length = LengthOfLongestSubstring.lengthOfLongestSubstring2(str);
        System.out.println("不含重复字符的最长子串长度为：" + length);
    }
}
