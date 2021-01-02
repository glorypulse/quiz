// 頻度が少ない数からk個削除している(問題読み間違い)
class Solution {
    public String removeKdigits(String num, int k) {
        int[] countArray = new int[10];
        char[] numArray = num.toCharArray();
        for (char n: numArray) {
            countArray[n - '0'] ++;
        }

        int[][] sortedNum = new int[9][2];
        for (int i = 1; i < 10; i ++) {
            sortedNum[i - 1][0] = i;
            sortedNum[i - 1][1] = countArray[i];
        }

        Arrays.sort(sortedNum,
                    (a, b) -> a[1] - b[1]);

        for (int[] s: sortedNum) {
            countArray[s[0]] = Math.min(k, s[1]);
            k = Math.max(0, k - s[1]);
        }

        boolean firstNum = false;
        StringBuilder sb = new StringBuilder();
        for (char n: numArray) {
            if (n == '0' && !firstNum) continue;
            if (n != '0' && countArray[n - '0'] > 0) {
                countArray[n - '0'] --;
                continue;
            }
            sb.append(n);
            firstNum = true;
        }

        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
