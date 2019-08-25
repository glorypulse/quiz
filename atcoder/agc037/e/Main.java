import java.util.Scanner;
import java.io.PrintWriter;

// E - Reversing and Concatenating
class Main {
    static String reverseAndConcat(int n, int k, String s) {
        int length = s.length();

        char minChar = Character.MAX_VALUE;
        for (char c: s.toCharArray()) {
            if (minChar > c) minChar = c;
        }

        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();

        int maxCount = 0;
        int count = 0, i = 0;
        if (reverse.charAt(0) == minChar) {
            count = 2;
            maxCount = 2;
        }

        for (i = 1; i < length; i ++) {
            char c = reverse.charAt(i);
            if (c == minChar) {
                count ++;
                if (maxCount < count) maxCount = count;
            } else {
                count = 0;
            }
        }

        int threshold = 0;
        int maxLength = maxCount;
        while (maxLength < n) { // n <= 5000
            maxLength *= 2;
            threshold ++;
        }

        sb = new StringBuilder();
        if (k > threshold) {
            for (i = 0; i < n; i ++) {
                sb.append(minChar);
            }
            return sb.toString();
        }

        int kLength = maxCount;
        for (i = 1; i < k; i ++) {
            kLength *= 2;
        }

        for (i = 0; i < maxCount; i ++) {
            sb.append(minChar);
        }
        String uStr = s + reverse, minCharStr = sb.toString();
        String minStr = null, checkStr = null;
        int checkIndex = -1;
        int minCharIndex = -1;

        while ((checkIndex = uStr.indexOf(minCharStr, checkIndex - maxCount + 1)) > 0) {
            checkIndex += maxCount;
            if (checkIndex + (n - kLength) > uStr.length()) break;
            checkStr = uStr.substring(checkIndex, checkIndex + (n - kLength));
            if (minStr == null || minStr.compareTo(checkStr) > 0) {
                minCharIndex = checkIndex;
                minStr = checkStr;
            }
        }
        for (i = maxCount; i < kLength; i ++) {
            sb.append(minChar);
        }
        sb.append(uStr.substring(minCharIndex, minCharIndex + (n - kLength)));

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());
        String s = sc.next();

        out.println(reverseAndConcat(n, k, s));
        out.flush();
    }
}
