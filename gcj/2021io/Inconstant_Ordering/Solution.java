import java.util.*;
import java.io.*;
public class Solution {
    static String validString(int[] blocks) {
        StringBuilder sb = new StringBuilder();
        sb.append('A');
        for (int i = 0; i < blocks.length - 1; i ++) {
            sb.append(validBlock(i % 2 == 0, blocks[i], blocks[i + 1]));
        }
        return sb.toString();
    }

    static String validBlock(boolean even, int l, int l2) {
        StringBuilder sb = new StringBuilder();
        char c = (char)('A' + (even ? 1 : 0));
        for (int i = 0; i < l - 1; i ++) {
            sb.append(c);
            c ++;
        }

        if (even) {
            sb.append((char)Math.max(c, 'A' + l2));
        } else {
            sb.append(c);
            sb.reverse();
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test_case; t++) {
            int n = in.nextInt();
            int[] blocks = new int[n + 1];
            for (int i = 0; i < n; i ++) {
                blocks[i] = in.nextInt();
            }
            System.out.println("Case #" + t + ": " + validString(blocks));
        }
    }
}
