class StackWithMin {
    final static int STACK_SIZE = 10;
    private int[] array;
    private MinStack minStack;
    private int index;

    public StackWithMin() {
        array = new int[STACK_SIZE];
        minStack = new MinStack(STACK_SIZE);
        index = 0;
    }

    public void push(int value) {
        if (isFull()) throw new RuntimeException("Stack is full.");

        if (value <= minStack.peek()) {
            // 最小値と同じ場合も最小値の個数を記録するためpushしておく
            minStack.push(value);
        }

        array[index] = value;
        index ++;
        return;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty.");

        index --;
        int value = array[index];
        array[index] = 0;

        if (value == minStack.peek()) {
            minStack.pop();
        }

        return value;
    }

    public int min() {
        return minStack.peek();
    }

    public int peek() {
        return array[index - 1];
    }

    public boolean isFull() {
        return index >= STACK_SIZE;
    }

    public boolean isEmpty() {
        return index <= 0;
    }
}
