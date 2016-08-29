package study;

import java.util.Scanner;
import java.io.PrintWriter;

/** Programming Contest Challenge Book p63
 */
public class LCSProblem_limited {
    /* Sample
3
3 5 8
3 2 2
17
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        int[] m = new int[N];
        for(int i = 0; i < N; i++) {
            m[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        LCSProblem_limited lpl = new LCSProblem_limited(N, a, m, K);
        boolean ans = lpl.solve();
        if (ans) {
            pw.println("Yes");
        } else {
            pw.println("No");
        }

        pw.flush();
        pw.close();
    }

    int N, K;
    int [] a, m;
    int[][] rest;

    LCSProblem_limited(int N, int[] a, int[] m, int K) {
        this.N = N;
        this.a = a;
        this.m = m;
        this.K = K;
        this.rest = new int[N+1][K+1];
        this.rest[0][0] = 0;
        for (int k = 1; k <= K; k++) {
            this.rest[0][k] = -1;
        }
    }

    boolean solve() {
        for (int i = 1; i <= N; i++) {
            for (int k = 0; k <= K; k++) {
                if (rest[i-1][k] >= 0) {
                    rest[i][k] = m[i-1];
                } else if (k - a[i-1] < 0 || rest[i][k - a[i-1]] <= 0) {
                    rest[i][k] = -1;
                } else {
                    rest[i][k] = rest[i][k - a[i-1]] - 1;
                }
            }
        }
        boolean ret = false;
        if (rest[N][K] >= 0) {
            ret = true;
        }
        return ret;
    }

    
}
