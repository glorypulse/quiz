class MyStack {
    public enum StackNumber {
        Stack1,
        Stack2,
        Stack3
    };

    final static int ARRAY_LENGTH = 10;
    private static String[] array;
    private StackNumber stackNumber;
    private int index = 0;
    private int initIndex;
    private int maxIndex;

    public MyStack(StackNumber stackNumber) {
        this.stackNumber = stackNumber;
        setIndexes();
        this.index = initIndex;
        if (array == null) {
            array = new String[ARRAY_LENGTH];
        }
        else {
            // 別インスタンスで同じStackを扱っている場合
            while(!isFull() && array[index] != null) {
                index ++;
            }
        }
    }

    public void push(String value) {
        if (isFull()) {
            throw new RuntimeException(stackNumber.toString() + "is full.");
        }

        array[index] = value;
        index ++;
        return;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException(stackNumber.toString() + "is empty.");
        }

        index --;
        String value = array[index];
        array[index] = null;
        return value;
    }

    public String peak() {
        if (isEmpty()) {
            throw new RuntimeException(stackNumber.toString() + "is empty.");
        }

        return array[index];
    }

    public boolean isFull() {
        return index > maxIndex;
    }

    public boolean isEmpty() {
        return index == initIndex;
    }


    private void setIndexes() {
        if (ARRAY_LENGTH < StackNumber.values().length) throw new RuntimeException("too short array length");

        switch(stackNumber) {
        case Stack1:
            initIndex = 0;
            maxIndex = ARRAY_LENGTH / 3 - 1;
            break;
        case Stack2:
            initIndex = ARRAY_LENGTH / 3;
            maxIndex = ARRAY_LENGTH * 2 / 3 - 1;
            break;
        case Stack3:
            initIndex = ARRAY_LENGTH * 2 / 3;
            maxIndex = ARRAY_LENGTH - 1;
            break;
        }
    }
}
