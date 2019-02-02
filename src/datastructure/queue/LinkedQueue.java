package datastructure.queue;

/**
 * @author huang
 * @version 1.0
 * @date 2019/02/02 11:57
 **/

public class LinkedQueue {
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    public LinkedQueue() {

    }

    public boolean enqueque(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    public Node dequeue() {
        Node result;
        if (head == tail) {
            return null;
        }
        result = head;
        head = head.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int i = 0; i < 10; i++) {
            Node node = new Node(String.valueOf(i));
            linkedQueue.enqueque(node);
        }
        Node result;
        for (int i = 0; i < 12; i++) {
            result = linkedQueue.dequeue();
            if (result == null) {
                System.out.println("队列已经空了 无法出队");
                continue;
            }
            System.out.println(result.data);
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

