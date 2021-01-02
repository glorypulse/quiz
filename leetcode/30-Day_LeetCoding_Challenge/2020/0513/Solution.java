class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> numStack = new Stack<>();
        for (char n: num.toCharArray() ) {
            while (k > 0 && !numStack.isEmpty() && numStack.peek() > n) {
                k --;
                numStack.pop();
            }
            numStack.push(n);
        }

        while (k > 0 && !numStack.isEmpty()) {
            k --;
            numStack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!numStack.isEmpty()) {
            sb.append(numStack.pop());
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }

}
