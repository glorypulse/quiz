import java.util.ArrayDeque;

class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for (char c: s.toCharArray()) {
            switch(c) {
            case '(':
                stack.push(')');
                break;
            case '{':
                stack.push('}');
                break;
            case '[':
                stack.push(']');
                break;
            case ')':
            case '}':
            case ']':
                if (stack.isEmpty()) return false;
                if (stack.pop() != c) return false;
                break;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
