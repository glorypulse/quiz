import java.util.*;
import java.io.*;
public class Solution {
    static final int MAX_VALUE = 1_000_000;

    static int minCostForCopyrights(String s, int x, int y) {
        int costC = 0;
        int costJ = 0;
        for (char c: s.toCharArray()) {
            switch (c) {
            case 'C':
                costC = Math.min(costC, costJ + y);
                costJ = MAX_VALUE;
                break;
            case 'J':
                costJ = Math.min(costC + x, costJ);
                costC = MAX_VALUE;
                break;
            case '?':
                int prevC = costC;
                int prevJ = costJ;
                costC = Math.min(prevC, prevJ + y);
                costJ = Math.min(prevC + x, prevJ);
            }
        }
        return Math.min(costC, costJ);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test_case; t++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            System.out.println("Case #" + t + ": " + minCostForCopyrights(s, x, y));
        }
    }
}
