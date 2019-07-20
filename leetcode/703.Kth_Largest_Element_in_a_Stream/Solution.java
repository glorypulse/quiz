import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> smallQueue;
    PriorityQueue<Integer> largeQueue;


    public KthLargest(int k, int[] nums) {
        smallQueue = new PriorityQueue<>(Collections.reverseOrder());
        largeQueue = new PriorityQueue<>();
        for (int num: nums) {
            smallQueue.add(num);
        }
        for (int i = 0; i < k - 1; i ++) {
            largeQueue.add(smallQueue.poll());
        }
    }

    public int add(int val) {
        if (smallQueue.isEmpty() || val > smallQueue.peek()) {
            largeQueue.add(val);
            smallQueue.add(largeQueue.poll());
        } else {
            smallQueue.add(val);
        }
        return smallQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
