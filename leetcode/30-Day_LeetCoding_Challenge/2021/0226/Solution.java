class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) return true;
        return validateStack(pushed, popped, 0, 0, new Stack<>());
    }

    boolean validateStack(int[] pushed, int[] popped, int pushIndex, int popIndex, Stack<Integer> stack) {
        if (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
            if (popIndex == popped.length - 1) {
                return true;
            }
            int popNum = stack.pop();
            if (validateStack(pushed, popped, pushIndex, popIndex + 1, stack)) {
                return true;
            }
            stack.push(popNum);
        }
        if (pushIndex < pushed.length) {
            stack.push(pushed[pushIndex]);
            if (validateStack(pushed, popped, pushIndex + 1, popIndex, stack)) {
                return true;
            }
            stack.pop();
        }
        return false;
    }
}
