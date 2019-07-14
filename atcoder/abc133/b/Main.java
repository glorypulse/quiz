import java.util.Scanner;
import java.io.PrintWriter;

class Main {
    static int distanceInteger(int n, int d, int[][] x) {
        int diff_sum, diff, sqrt, count = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n; j ++) {
                diff_sum = 0;
                for (int l = 0; l < d; l ++) {
                    diff = x[i][l] - x[j][l];
                    diff_sum += diff * diff;
                }
                sqrt = sqrtInteger(0, diff_sum, diff_sum);
                if (sqrt * sqrt == diff_sum) count ++;
            }
        }
        return count;
    }

    static int sqrtInteger(int left, int right, int target) {
        if (left >= right) return left;
        int mid = (left + right) / 2;
        int midSquare = mid * mid;
        if (midSquare == target) return mid;
        if (midSquare < target) return sqrtInteger(mid + 1, right, target);
        return sqrtInteger(left, mid - 1, target);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(sc.next());
        int d = Integer.parseInt(sc.next());

        int[][] x = new int[n][d];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < d; j ++) {
                x[i][j] = Integer.parseInt(sc.next());
            }
        }

        out.println(distanceInteger(n, d, x));
        out.flush();
    }
}
