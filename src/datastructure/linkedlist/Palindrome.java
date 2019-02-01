package datastructure.linkedlist;

/**
 * 通过 LinkedList 单链表 判断回文
 * 判断回文链表 快慢指针，反转链表  [也可以那一个数组或者栈来记录慢指针走的前半部分的数据，然后通过慢指针走完剩下的节点，并且对比]
 * @author huang
 * @version 1.0
 * @date 2019/01/31 15:48
 **/

public class Palindrome {
    public static void main(String[] args) {
        String[] strsa = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
        Node aaa = initNode(strsa);
        Node result = reversalLinkList(aaa);
        printLinkList(result);


        String[] strs = new String[]{"1", "2", "3", "4", "4", "3", "2", "1"};
        Node head = initNode(strs);
        printLinkList(head);
        Node midNode = findMidNode(head);
        checkIsPalindrome(head, midNode);

        String[] strsRing = new String[]{"1", "2", "3", "4", "4", "3", "2", "1"};
        Node headRing = initNode(strsRing);
        checkRing(headRing);
    }


    /**
     * 初始化链表
     * 该方法仅针对无环链表
     *
     * @param strs data 数组
     * @author hbj
     */
    private static Node initNode(String[] strs){
        if (strs.length <= 0) {
            return null;
        }
        //头节点
        Node nodeHead = null;
        //当前节点
        Node currNode = null;
        for (String str : strs) {
            if (nodeHead == null) {
                nodeHead = new Node(str, null);
                currNode = nodeHead;
            } else {
                currNode.next = new Node(str, null);
                currNode = currNode.next;
            }
        }
        return nodeHead;
    }

    /**
     * 寻找链表的中间节点
     * 该方法仅针对无环链表
     *
     * @param head 头节点
     * @return Node 中间节点
     * @author hbj
     */
    private static Node findMidNode(Node head) {
        if (head == null) {
            return null;
        }
        Node oneStep = head;
        Node twoStep = head;
        while (true) {
            if (twoStep.next == null) {
                //直接就是当前的oneStep
                break;
            }
            if (twoStep.next.next == null) {
                oneStep = oneStep.next;
                break;
            }
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        return oneStep;
    }

    /**
     * 反转链表
     * 该方法仅针对无环链表
     *
     * @param node 头节点
     * @return Node 反转后的头节点
     * @author hbj
     */
    private static Node reversalLinkList(Node node) {
        if (node == null) {
            return null;
        }

        if (node.next == null) {
            return node;
        }

        Node headNode = node;
        Node tempNode;
        while (node.next != null) {
            tempNode = node.next;
            node.next = node.next.next;
            tempNode.next = headNode;
            headNode = tempNode;
        }
        return headNode;
    }

    /**
     * 检验链表是否为回文链表
     * 该方法仅针对无环链表
     *
     * @param headNode 头节点
     * @param midNode 中间节点
     * @author hbj
     */
    private static void checkIsPalindrome(Node headNode, Node midNode) {
        if (headNode.next == null) {
            System.out.println("只有一个元素，不是回文链表");
            return;
        }
        Node node = reversalLinkList(midNode);
        boolean flag = true;
        while (headNode != midNode) {
            if (!node.data.equals(headNode.data)) {
                flag = false;
            }
            headNode = headNode.next;
            node = node.next;
        }
        if (flag) {
            System.out.println("是回文链表");
        } else {
            System.out.println("不是回文链表");
        }
    }

    /**
     * 打印链表
     * 该方法仅针对无环链表
     *
     * @param node 头节点
     * @author hbj
     */
    private static void printLinkList(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.data);
            sb.append(" ");
            node = node.next;
        }
        System.out.println(sb.toString());
    }

    /**
     * 检验链表是否存在环
     *
     * @param node 头节点
     * @author hbj
     * @date
     */
    private static void checkRing(Node node) {
        if (node == null || node.next == null) {
            System.out.println("链表不存在,无需校验环");
            return;
        }

        Node oneStep = node;
        Node twoStep = node;
        while (true) {
            if (twoStep.next == null) {
                //直接就是当前的oneStep
                System.out.println("链表不存在环");
                break;
            }
            if (twoStep.next.next == null) {
                System.out.println("链表不存在环");
                break;
            }
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep) {
                System.out.println("链表存在环");
                break;
            }
        }
    }
}

class Node{
    String data;
    Node next;

    public Node() {
    }

    public Node(String data) {
        this.data = data;
    }

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}
