class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int length = asteroids.length;
        if (length == 0) return new int[]{ };
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i ++) {
            int asteroid = asteroids[i];
            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
                continue;
            }

            int prev = stack.peek();
            while (!stack.isEmpty()) {
                if (prev < 0) {
                    stack.push(asteroid);
                    break;
                }

                int asteroidAbs = -asteroid; // abs
                if (prev > asteroidAbs) break;

                stack.pop();
                if (prev == asteroidAbs) break;
                if (stack.isEmpty()) {
                    stack.push(asteroid);
                    break;
                }
                prev = stack.peek();
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i --) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
