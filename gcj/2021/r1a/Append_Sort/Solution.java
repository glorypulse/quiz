import java.util.*;
import java.io.*;
public class Solution {
    static int countAppend(int[] arr) {
        int length = arr.length;
        int count = 0;
        int prevDigit = getDigit(arr[0]);
        long prev = arr[0];

        for (int i = 1; i < length; i ++) {
            System.out.print(prev + ",");
            int digit = getDigit(arr[i]);
            if (prev < arr[i]) {
                prev = arr[i];
                prevDigit = digit;
                continue;
            }

            if (digit == prevDigit) {
                prev = arr[i] * 10;
                prevDigit += 1;
                count += 1;
                continue;
            }
            int diff = prevDigit - digit;
            int tmp = (int)(prev / Math.pow(10, diff));
            int tmp2 = (int)((prev + 1) / Math.pow(10, diff));

            if (tmp == arr[i] && tmp2 == tmp) {
                prev += 1;
            } else {
                if (tmp > arr[i] || tmp2 > tmp) {
                    diff ++;
                }
                prev = (long)(arr[i] * Math.pow(10, diff));
            }

            prevDigit = digit + diff;
            count += diff;
        }
        System.out.print(prev + ",");
        System.out.println();
        return count;
    }

    static int getDigit(int num) {
        if (num == 0) return 1;
        int count = 0;
        while (num > 0) {
            num /= 10;
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test_case; t++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i ++) {
                arr[i] = in.nextInt();
            }
            System.out.println("Case #" + t + ": " + countAppend(arr));
        }
    }
}
