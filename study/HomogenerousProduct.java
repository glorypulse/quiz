package study;

import java.util.Scanner;
import java.io.PrintWriter;

class HomogenerousProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i ++) {
            a[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        HomogenerousProduct hp = new HomogenerousProduct(n, m, a, M);
        int ans = hp.solve();

        pw.println(String.valueOf(ans));
        
        pw.flush();
        pw.close();

    }

    int n,m,M;
    int[] a;
    int[][] h_matrix;

    HomogenerousProduct(int n, int m, int[] a, int M) {
        this.n = n;
        this.m = m;
        this.a = a;
        this.M = M;
        h_matrix = new int[n+1][m+1]; // i種の中からj個選ぶ組み合わせの総数
        for (int i = 0; i <= n; i++) {
            h_matrix[i][0] = 1;
        }
        for (int i = 1; i <= m; i ++) {
            h_matrix[0][i] = 0;
        }
    }

    int solve() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j > a[i-1]) {
                    h_matrix[i][j] = (h_matrix[i-1][j] + h_matrix[i][j-1] - h_matrix[i-1][j-a[i-1]-1]) % M;
                } else {
                    h_matrix[i][j] = (h_matrix[i-1][j] + h_matrix[i][j-1]) % M;
                }
            }
        }
        return h_matrix[n][m];
    }
}
