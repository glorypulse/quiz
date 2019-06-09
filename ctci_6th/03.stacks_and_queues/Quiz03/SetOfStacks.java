import java.util.ArrayList;

class SetOfStacks {
    static final int INITIALIZE_VALUE = 0;
    static final int INNER_STACK_SIZE = 3;
    private ArrayList<int[]> arrays;
    private int[] current_array;
    private int stackNumber;
    private int index;

    public SetOfStacks() {
        arrays = new ArrayList<int[]>();
        initializeInnerStack();
        stackNumber = 0;
        index = 0;
    }

    public void push(int value) {
        // いっぱいで次を確保するとき
        if (innerIsFull()) {
            initializeInnerStack();
            stackNumber++;
            index = 0;
        }
        current_array[index] = value;
        index ++;
        return;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty.");

        // 前のinner stackに戻るとき
        if (innerIsEmpty()) {
            arrays.remove(stackNumber);
            stackNumber --;
            current_array = arrays.get(stackNumber);
            index = INNER_STACK_SIZE;
        }

        index --;
        int value = current_array[index];
        current_array[index] = INITIALIZE_VALUE;
        return value;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty.");

        int[] array = current_array;
        int peek_index = index;
        if (innerIsEmpty()) {
            array = arrays.get(stackNumber - 1);
            peek_index = INNER_STACK_SIZE;
        }

        return array[peek_index - 1];
    }

    public boolean isEmpty() {
        return stackNumber == 0 && index == 0;
    }

    private void initializeInnerStack() {
        current_array = new int[INNER_STACK_SIZE];
        // Arrays.fill(current_array, INITIALIZE_VALUE);
        arrays.add(current_array);
    }

    private boolean innerIsFull() {
        return index >= INNER_STACK_SIZE;
    }

    private boolean innerIsEmpty() {
        return index == 0;
    }
}
