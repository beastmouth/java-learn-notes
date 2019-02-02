package datastructure.queue;

/**
 * @author huang
 * @version 1.0
 * @date 2019/02/02 11:01
 **/

public class ArrayQueue {
    private String[] items;
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if (tail == n) {
//            return false;
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        for (int i = 0; i < 9; i++) {
            arrayQueue.enqueue(String.valueOf(i));
        }
        for (int i = 0; i < 9; i++) {
            System.out.println(arrayQueue.dequeue());
        }
    }
}
