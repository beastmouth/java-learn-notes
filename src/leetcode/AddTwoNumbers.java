package leetcode;

/**
 * 两数相加
 *
 * @author hbj
 * @date 2019/8/8 15:07
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(carry);
        ListNode resultListNode = result;
        while (l1 != null || l2 != null) {
            carry = 0;
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            result.val = result.val + l1val + l2val;
            if (result.val > 9) {
                result.val = result.val % 10;
                carry = 1;
            }
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            if (l1 == null && l2 == null)
                break;
            result.next = new ListNode(carry);
            result = result.next;
        }
        if (carry == 1) {
            result.next = new ListNode(carry);
        }
        return resultListNode;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int carry = 0;
        ListNode result = new ListNode(carry);
        ListNode resultListNode = result;
        while (l1 != null && l2 != null) {
            result.val = result.val + l1.val + l2.val;
            if (result.val > 9) {
                result.val = result.val % 10;
                carry = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null || l2 == null) {
                break;
            }
            result.next = new ListNode(carry);
            result = result.next;
            carry = 0;
        }
        if (l1 != null || l2 != null) {
            result.next = new ListNode(carry);
            result = result.next;
        }
        while (l1 != null) {
            carry = 0;
            result.val = result.val + l1.val;
            if (result.val > 9) {
                result.val = result.val % 10;
                carry = 1;
            }
            if (l1.next == null) {
                break;
            }
            l1 = l1.next;
            result.next = new ListNode(carry);
            result = result.next;
        }
        while (l2 != null) {
            carry = 0;
            result.val = result.val + l2.val;
            if (result.val > 9) {
                result.val = result.val % 10;
                carry = 1;
            }
            if (l2.next == null) {
                break;
            }
            l2 = l2.next;
            result.next = new ListNode(carry);
            result = result.next;
        }
        if (carry == 1) {
            result.next = new ListNode(carry);
        }
        return resultListNode;
    }

    public static ListNode initListNode(int[] nums) {
        ListNode listNode = new ListNode(nums[0]);
        ListNode resultListNode = listNode;
        for (int i = 1; i < nums.length; i++) {
            listNode.next = new ListNode(nums[i]);
            listNode = listNode.next;
        }
        return resultListNode;
    }

    public static void main(String[] args) {
//        int[] l1Nums = new int[3];
//        l1Nums[0] = 2;l1Nums[1] = 4; l1Nums[2] = 3;
//        int[] l2Nums = new int[3];
//        l2Nums[0] = 5;l2Nums[1] = 6; l2Nums[2] = 4;

        int[] l1Nums = new int[1];
        l1Nums[0] = 1;
        int[] l2Nums = new int[3];
        l2Nums[0] = 9;
        l2Nums[1] = 1;
        l2Nums[2] = 6;
        ListNode l1 = initListNode(l1Nums);
        ListNode l2 = initListNode(l2Nums);
        ListNode resultList = AddTwoNumbers.addTwoNumbers2(l1, l2);
        StringBuilder str = new StringBuilder();
        while (resultList != null) {
            if (resultList.next == null) {
                str.append(resultList.val);
            } else {
                str.append(resultList.val).append(" -> ");
            }
            resultList = resultList.next;
        }
        System.out.println("result : " + str.toString());
    }
}
