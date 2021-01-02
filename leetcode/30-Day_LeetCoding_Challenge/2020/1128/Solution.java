class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length; // 1 <= k <= length
        int[] ans = new int[length - k + 1];
        LinkedList<Integer> maxWindow = new LinkedList<>();
        maxWindow.add(0);
        for (int i = 1; i < k; i ++) {
            int num = nums[i];
            while (!maxWindow.isEmpty() && num >= nums[maxWindow.getLast()]) {
                maxWindow.removeLast();
            }
            maxWindow.add(i);
        }

        ans[0] = nums[maxWindow.getFirst()];
        for (int i = k; i < length; i ++) {
            int num = nums[i];
            while (!maxWindow.isEmpty() && i - k >= maxWindow.getFirst()) {
                maxWindow.removeFirst();
            }
            while (!maxWindow.isEmpty() && num >= nums[maxWindow.getLast()]) {
                maxWindow.removeLast();
            }
            maxWindow.add(i);
            ans[i - k + 1] = nums[maxWindow.getFirst()];
        }
        return ans;
    }
}
