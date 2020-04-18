import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test_case; t++) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println("Case #" + t + ": " + (n + m) + " " + (n * m));
        }
    }
}
