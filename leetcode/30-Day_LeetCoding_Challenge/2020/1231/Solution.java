class Solution {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < length; i ++) {
            int val = heights[i];
            while (!stack.isEmpty() && val < heights[stack.peek()]) {
                int topIndex = stack.pop();
                int prevIndex = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, heights[topIndex] * (i - prevIndex - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int topIndex = stack.pop();
            int prevIndex = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, heights[topIndex] * (length - prevIndex - 1));
        }

        return max;
    }
}
