class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        for (char c: s.toCharArray()) {
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9') continue;
            n --;
        }
        if (n == 0) return true;
        Stack<Character> checkStack = new Stack<>();
        int i = 0;
        for (char c: s.toCharArray()) {
            if (!(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9')) continue;
            if (c >= 'A' && c <= 'Z') {
                c = Character.toLowerCase(c);
            }
            if (i < n / 2) {
                checkStack.push(c);
            } else if (i > n / 2 || n % 2 == 0) {
                char d = checkStack.pop();
                if (c != d) return false;
            }
            i ++;
            if (i == n) break;
        }
        return true;
    }
}
