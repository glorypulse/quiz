class FreqStack {
    class Freq {
        int num;
        int freq;
        int index;

        Freq(int num, int freq, int index) {
            this.num = num;
            this.freq = freq;
            this.index = index;
        }
    }
    Map<Integer, Stack<Freq>> numMap;
    PriorityQueue<Freq> pq;
    int curIndex;

    public FreqStack() {
        numMap = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
                if (a.freq != b.freq) {
                    return b.freq - a.freq;
                }
                return b.index - a.index;
        });
        curIndex = 0;
    }

    public void push(int x) {
        curIndex ++;
        numMap.putIfAbsent(x, new Stack<>());
        Stack<Freq> numStack = numMap.get(x);
        Freq freq = new Freq(x, numStack.size(), curIndex);
        numStack.push(freq);
        pq.offer(freq);
    }

    public int pop() {
        Freq top = pq.poll();
        numMap.get(top.num).pop();
        return top.num;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
