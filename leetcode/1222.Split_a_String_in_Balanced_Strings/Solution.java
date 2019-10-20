class Solution {
    public int balancedStringSplit(String s) {
        int amount = 0;
        int balance = 0;
        for (char c: s.toCharArray()) {
            if (c == 'R') {
                balance ++;
            } else { // 'L'
                balance --;
            }

            if (balance == 0) {
                amount ++;
            }
        }

        return amount;
    }
}
