package datastructure.linkedlist;

/**
 * 通过 LinkedList 单链表 判断回文
 * @author huang
 * @version 1.0
 * @date 2019/01/31 15:48
 **/

public class Palindrome {
    public static void main(String[] args) {
        String[] strs = new String[]{"1", "2", "3", "4", "4", "3", "2", "1"};
        Node head = initNode(strs);
        printLinkList(head);
        Node midNode = findMidNode(head);
        checkIsPalindrome(head, midNode);
    }

    private static Node initNode(String[] strs){
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

    private static Node reversalLinkList(Node node) {
        Node headNode = node;
        while (node.next != null) {
            Node tempNode = node.next;
            node.next = node.next.next;
            tempNode.next = headNode;
            headNode = tempNode;
        }
        return headNode;
    }

    private static void checkIsPalindrome(Node headNode, Node midNode) {
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

    private static void printLinkList(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.data);
            sb.append(" ");
            node = node.next;
        }
        System.out.println(sb.toString());

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
