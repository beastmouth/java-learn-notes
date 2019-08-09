package leetcode;

/**
 * @author hbj
 * @date 2019/8/9 15:13
 */
public class LongestPalindrome {
    /**
     * 时间消耗过大！！！
     *
     * @param s 需要鉴定的字符串
     * @return 回文字符串
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int maxLength = 1;
        String str = String.valueOf(s.charAt(0));
        int head = 0;
        while (head < s.length()) {
            int tail = head + 1;
            while (tail < s.length() && tail > head) {
                int tempHead = head;
                int tempTail = tail;
                if ((tail - head) % 2 == 1) {
                    // 双数
                    while (tempTail != tempHead + 1) {
                        if (s.charAt(tempTail) != s.charAt(tempHead)) {
                            break;
                        }
                        tempTail--;
                        tempHead++;
                    }
                    if (tempTail == tempHead + 1) {
                        if (s.charAt(tempTail) == s.charAt(tempHead)) {
                            // 是回文字符串
                            maxLength = maxLength > tail - head ? maxLength : tail - head;
                            str = maxLength > tail - head ? str : s.substring(head, tail + 1);
                        }
                    }
                } else {
                    // 单数
                    while (tempTail != tempHead) {
                        if (s.charAt(tempTail) != s.charAt(tempHead)) {
                            break;
                        }
                        tempTail--;
                        tempHead++;
                    }
                    if (tempTail == tempHead) {
                        maxLength = maxLength > tail - head ? maxLength : tail - head;
                        str = maxLength > tail - head ? str : s.substring(head, tail + 1);
                    }
                }
                tail++;
            }
            head++;
        }
        return str;
    }

    /**
     * 优化后 空间消耗减少很多，时间消耗减少不多
     *
     * @param s 需要鉴定的字符串
     * @return 回文字符串
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int length = s.length();
        while (length > 1) {
            int head = 0;
            while ((head + length - 1) <= (s.length() - 1)) {
                int tempHead = head;
                int tempTail = head + length - 1;
                while (s.charAt(tempHead) == s.charAt(tempTail)) {
                    tempHead++;
                    tempTail--;
                    String substring = s.substring(head, head + length);
                    if (tempHead > tempTail) {
                        return substring;
                    }
                    if (tempHead == tempTail) {
                        // 奇数个回文字符串
                        return substring;
                    }
                    if (tempHead == tempTail - 1) {
                        if (s.charAt(tempHead) == s.charAt(tempTail)) {
                            return substring;
                        } else {
                            break;
                        }
                    }
                }
                head++;
            }
            length--;
        }
        return String.valueOf(s.charAt(0));
    }

    public static void main(String[] args) {
        String str = "abcba";
        System.out.println(longestPalindrome2(str));
    }
}
