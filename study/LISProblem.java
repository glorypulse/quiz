package study;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;

/** Programming Contest Challenge Book p63 */

public class LISProblem {
    /* Sample
5
4 2 3 1 5
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i ++) {
            a[i] = sc.nextInt();
        }

        LISProblem lis = new LISProblem(N, a);
        int ans = lis.solve();
        pw.println(ans);
        pw.flush();
        pw.close();
    }

    int N;
    int[] a;
    int[] minValues;
    
    LISProblem(int N, int[] a) {
        this.N = N;
        this.a = a;
        this.minValues = new int[N];
        Arrays.fill(minValues, Integer.MAX_VALUE);        
    }

    // int bsearch(int value) {
    //     return bsearch(value, 0, minValues.length-1);
    // }

    int lower_bound(int value, int max_i) {
        int l = 0;
        int r = max_i;
        int i = 0;
        while (l < r) {
            i = (l + r) / 2;
            if (minValues[i] < value) {
                l = i + 1;
            } else { // minValues[i] > value
                r = i;
            }
        }
        return l;
    }

    int solve() {
        int max_length = Math.min(1, N);
        for (int i = 0; i < N; i++) {
            int j = lower_bound(a[i], max_length);
            minValues[j] = a[i];
            if (j == max_length-1) {
                max_length++;
            }
        }
        return max_length-1;
    }
    
}
