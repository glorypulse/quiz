import java.util.Scanner;
import java.io.PrintWriter;

class Main {
    static long[] rain(int n, int[] a) {
        long sum = 0;
        long even_sum = 0;

        int i = 0;
        for (i = 0; i < n; i++) {
            sum += a[i];
            if (i % 2 == 1) even_sum += a[i]; // 0 originなので
        }
        even_sum *= 2;
        long[] m = new long[n];
        m[0] = sum - even_sum;

        for (i = 1; i < n; i++) {
            m[i] = a[i - 1] * 2 - m[i - 1];
        }

        return m;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(sc.nextLine());
        int a[] = new int[n];
        int i = 0;
        for (i = 0; i < n; i ++) {
            a[i] = Integer.parseInt(sc.next());
        }

        long m[] = rain(n, a);
        for (i = 0; i < n - 1; i ++) {
            out.print(m[i] + " ");
        }
        out.println(m[n-1]);
        out.flush();
    }
}
