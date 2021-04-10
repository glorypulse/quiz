import java.util.*;
import java.io.*;
public class Solution {
    static int reversortCost(int[] arr) {
        int length = arr.length;
        int[][] arrWithIndex = new int[length][2];
        for (int i = 0; i < length; i ++) {
            arrWithIndex[i][0] = arr[i];
            arrWithIndex[i][1] = i;
        }
        Arrays.sort(arrWithIndex, (a, b) -> a[0] - b[0]);
        int cost = 0;
        for (int i = 0; i < length - 1; i ++) {
            int index = arrWithIndex[i][1];
            cost += index - i + 1;
            for (int j = i + 1; j < length; j ++) {
                if (arrWithIndex[j][1] < index) {
                    arrWithIndex[j][1] = index - arrWithIndex[j][1] + i;
                }
            }
        }
        return cost;
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
            System.out.println("Case #" + t + ": " + reversortCost(arr));
        }
    }
}
