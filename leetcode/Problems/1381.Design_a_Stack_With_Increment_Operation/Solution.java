class CustomStack {
    int[] stacks;
    int count, maxSize;

    public CustomStack(int maxSize) {
        this.count = 0;
        this.maxSize = maxSize;
        this.stacks = new int[maxSize];
    }

    public void push(int x) {
        if (count < maxSize) {
            stacks[count] = x;
            count ++;
        }
    }

    public int pop() {
        if (count > 0) {
            count --;
            return stacks[count];
        }
        return -1;
    }

    public void increment(int k, int val) {
        int size = Math.min(k, count);
        for (int i = 0; i < size; i ++) {
            stacks[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
