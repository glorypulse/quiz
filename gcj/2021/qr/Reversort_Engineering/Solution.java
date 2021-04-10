import java.util.*;
import java.io.*;
public class Solution {
    static int[] originalArray(int N, int cost) {
        int[][] arrWithIndex = new int[N][2];
        for (int i = 0; i < N; i ++) {
            arrWithIndex[i][0] = i + 1;
            arrWithIndex[i][1] = i + 1;
        }

        for (int i = N - 1; i >= 0; i --) {
            arrWithIndex[i][1] = Math.min(cost, N - 1);
            cost -= arrWithIndex[i][1] - i + 1;
            for (int j = i + 1; j < N; j ++) {
                if (arrWithIndex[j][1] <= arrWithIndex[i][1]) {
                    arrWithIndex[j][1] = arrWithIndex[i][1] - arrWithIndex[j][1] + i;
                }
            }
        }
        Arrays.sort(arrWithIndex, (a, b) -> a[1] - b[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i ++) {
            arr[i] = arrWithIndex[i][0];
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test_case; t++) {
            int n = in.nextInt();
            int cost = in.nextInt();
            System.out.print("Case #" + t + ":");
            if (cost < n - 1 || cost > n * (n + 1) / 2 - 1) {
                System.out.println(" IMPOSSIBLE");
            } else {
                int[] ans = originalArray(n, cost);
                for (int i = 0; i < n; i ++) {
                    System.out.print(" " + ans[i]);
                }
                System.out.println();
            }
        }
    }
}
