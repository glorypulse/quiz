class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int max = 0;
        while (left < right) {
            int heightL = height[left];
            int heightR = height[right];
            max = Math.max(max, (right - left) * Math.min(heightL, heightR));

            if (heightL <= heightR) {
                while (left < right && heightL >= height[left]) {
                    left ++;
                }
            }
            if (heightR <= heightL) {
                while (left < right && heightR >= height[right]) {
                    right --;
                }
            }
        }
        return max;
    }
}
