class MinStack {
    private int[] array;
    private int index;

    public MinStack(int stackSize) {
        array = new int[stackSize];
    }

    public void push(int value) {
        if (isFull()) throw new RuntimeException("Stack is full.");

        array[index] = value;
        index ++;
        return;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty.");

        index --;
        int value = array[index];
        array[index] = 0;

        return value;
    }

    public int peek() {
        if (isEmpty()) return Integer.MAX_VALUE;

        return array[index - 1];
    }

    public boolean isFull() {
        return index >= array.length;
    }

    public boolean isEmpty() {
        return index <= 0;
    }
}
