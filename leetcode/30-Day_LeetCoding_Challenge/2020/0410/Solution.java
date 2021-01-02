class MinStack {
    int[] stackArray;
    int index;
    PriorityQueue<Integer> pq;

    /** initialize your data structure here. */
    public MinStack() {
        stackArray = new int[10];
        index = 0;
        pq = new PriorityQueue<Integer>();
    }

    public void push(int x) {
        if (index == stackArray.length) {
            int[] tmp = new int[stackArray.length * 2];
            for (int i = 0; i < stackArray.length; i ++) {
                tmp[i] = stackArray[i];
            }
            stackArray = tmp;
        }
        pq.add(x);
        stackArray[index] = x;
        index ++;
    }

    public void pop() {
        if (index == 0) return;
        index --;
        pq.remove(stackArray[index]);
        if (index == stackArray.length / 4) {
            int[] tmp = new int[stackArray.length / 2];
            for (int i = 0; i < index; i ++) {
                tmp[i] = stackArray[i];
            }
            stackArray = tmp;
        }
    }

    public int top() {
        return stackArray[index - 1];
    }

    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
