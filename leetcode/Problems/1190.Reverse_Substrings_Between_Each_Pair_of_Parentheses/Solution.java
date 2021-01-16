import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();

        boolean currentReverse = false;
        StringBuilder sb = new StringBuilder();
        StringBuilder strb = new StringBuilder();
        char c;
        int pCount = 0;
        for (int i = 0; i < s.length(); i ++) {
            c = s.charAt(i);
            if (i == s.length() - 1 && c != '(' && c != ')') {
                strb.append(c);
            } else if (c == ')') {
                pCount --;
            }

            if (c == '(' || c == ')' || i == s.length() - 1) {
                if (currentReverse) {
                    stack.push(strb.toString());
                } else {
                    queue.add(strb.toString());
                }
                if (pCount == 0) {
                    sb.append(print(stack, queue));
                    if (c == '(') {
                        queue.add("");
                    }
                }

                strb = new StringBuilder();
                currentReverse = !currentReverse;
                if (c == '(') {
                    pCount ++;
                }
            } else {
                strb.append(c);
            }
        }

        sb.append(print(stack, queue));
        return sb.toString();
    }

    String print(Stack<String> stack, Queue<String> queue) {
        StringBuilder sb = new StringBuilder();
        boolean tmpReverse = false;
        while (!stack.isEmpty() || !queue.isEmpty()) {
            if (tmpReverse) {
                sb.append(new StringBuilder(stack.pop()).reverse().toString());
            } else {
                sb.append(queue.remove());
            }
            tmpReverse = !tmpReverse;
        }
        return sb.toString();
    }
}
