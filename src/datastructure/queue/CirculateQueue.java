package datastructure.queue;

/**
 * 循环队列
 * 浪费一个存储空间来实现
 * @author huang
 * @version 1.0
 * @date 2019/02/02 11:42
 **/

public class CirculateQueue {
    private String[] items;
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public CirculateQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) {
            //队列已经满了
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
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
}
