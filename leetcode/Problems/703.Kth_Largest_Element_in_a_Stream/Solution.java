import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> largeQueue;
    int k;


    public KthLargest(int k, int[] nums) {
        largeQueue = new PriorityQueue<>();
        this.k = k;
        for (int num: nums) {
            largeQueue.add(num);
        }
        while (largeQueue.size() > k) {
            largeQueue.poll();
        }
    }

    public int add(int val) {
        if (largeQueue.size() < k || val >= largeQueue.peek()) {
            largeQueue.add(val);
            if (largeQueue.size() > k) largeQueue.poll();
        }
        return largeQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
