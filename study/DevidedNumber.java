package study;

import java.util.Scanner;
import java.io.PrintWriter;

class DevidedNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int M = sc.nextInt();

        DevidedNumber dn = new DevidedNumber(n, m, M);
        int ans = dn.solve();
        pw.println(String.valueOf(ans));

        pw.flush();
        pw.close();

        
        
    }

    int n, m ,M;
    int[][] devided_matrix;
    DevidedNumber(int n, int m, int M) {
        this.n = n;
        this.m = m;
        this.M = M;
        devided_matrix = new int[m+1][n+1]; // 0分割は考えられないが、計算を簡易にするために記載
        devided_matrix[0][0] = 1;
        for (int i = 1; i <= n; i ++) {
            devided_matrix[0][i] = 0;
        }
    }

    

    int solve() {
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j - i >= 0) {
                    devided_matrix[i][j] = (devided_matrix[i][j-i] + devided_matrix[i-1][j]) % M;
                } else {
                    devided_matrix[i][j] = devided_matrix[i-1][j];
                }
            }
        }
        return devided_matrix[m][n];
    }
}
