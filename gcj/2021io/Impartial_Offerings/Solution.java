import java.util.*;
import java.io.*;
public class Solution {
    static int countTreats(int[] pets) {
        Arrays.sort(pets);
        int count = 1;
        int cur = 1;
        int prev = pets[0];
        for (int i = 1; i < pets.length; i ++) {
            if (prev < pets[i]) {
                prev = pets[i];
                cur ++;
            }
            count += cur;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test_case; t++) {
            int n = in.nextInt();
            int[] pets = new int[n];
            for (int i = 0; i < n; i ++) {
                pets[i] = in.nextInt();
            }
            System.out.println("Case #" + t + ": " + countTreats(pets));
        }
    }
}
