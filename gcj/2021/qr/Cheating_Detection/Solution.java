import java.util.*;
import java.io.*;
public class Solution {
    static int cheater(String[] answers) {
        PriorityQueue<int[]> candidates = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 100; i ++) {
            int count = 0;
            for (char c: answers[i].toCharArray()) {
                if (c == '1') {
                    count += 1;
                }
            }
            if (count >= 5000) {
                candidates.offer(new int[]{ i + 1, count }); // number, count
            }
        }

        return candidates.poll()[0];
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int p = in.nextInt();
        for (int t = 1; t <= test_case; t++) {
            String[] answers = new String[100];
            for (int i = 0; i < 100; i ++) {
                answers[i] = in.next();
            }
            System.out.println("Case #" + t + ": " + cheater(answers));
        }
    }
}
