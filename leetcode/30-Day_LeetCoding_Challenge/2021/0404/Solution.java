class MyCircularQueue {
    int[] queue;
    int front;
    int rear;
    int size;
    boolean empty;

    public MyCircularQueue(int k) {
        front = 0;
        rear = 0;
        queue = new int[k];
        size = k;
        empty = true;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        queue[rear] = value;
        rear = (rear + 1) % size;
        empty = false;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % size;
        if (front == rear) {
            empty = true;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return queue[(rear + size - 1) % size];
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isFull() {
        return !empty && front == rear;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
