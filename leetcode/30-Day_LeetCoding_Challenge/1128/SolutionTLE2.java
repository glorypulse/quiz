class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length; // 1 <= k <= length
        int[] ans = new int[length - k + 1];

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i ++) {
            pQueue.offer(nums[i]);
        }
        ans[0] = pQueue.peek();
        for (int i = k; i < length; i ++) {
            pQueue.remove(nums[i - k]);
            pQueue.offer(nums[i]);
            ans[i - k + 1] = pQueue.peek();
        }
        return ans;
    }
}
