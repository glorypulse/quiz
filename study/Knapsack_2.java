package study;

import java.util.Scanner;
import java.io.PrintWriter;

class Item {
    int w;
    int v;
    Item (int w, int v) {
        this.w = w;
        this.v = v;
    }
}

/** Programming Contest Challenge Book p61
 Sample
4
2 3
1 2
3 4
2 2
5
*/

public class Knapsack_2 {
    long W_MAX = new Double(10e9).longValue() + 1;
    
    int N;
    Item[] items;
    long W;

    int sum_v;
    long[][] w_matrix;

    Knapsack_2 (int n) {
        this.N = n;
        items = new Item[this.N];
    }


    void setItem (int i, Item item) {
        items[i] = item;
    }

    void init(long w, int sum_v) {
        this.W = w;
        this.sum_v = sum_v;
        w_matrix = new long[this.N + 1][this.sum_v + 1];

        // initialize

        w_matrix[0][0] = 0;
        for (int v = 1; v <= this.sum_v; v++) {
            w_matrix[0][v] = this.W_MAX;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);


        int N = sc.nextInt();
        Knapsack_2 ks = new Knapsack_2(N);

        int sum_v = 0;
        for (int i = 0; i < N; i ++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            sum_v += v;
            ks.setItem(i, new Item(w, v));
        }

        long W = sc.nextLong(); // Int.MaxValue < 10e9 < Long.MaxValue
        
        ks.init(W, sum_v);

        int ans = ks.solve();
        pw.println(String.valueOf(ans));
        
        pw.flush();
        pw.close();

    }

    int solve() {
        
        for (int n = 1; n <= this.N; n++) {
            Item item = items[n-1];
            for (int v = 0; v <= this.sum_v; v++) {
                if (v - item.v < 0) {
                    w_matrix[n][v] = w_matrix[n-1][v];
                } else {
                    w_matrix[n][v] = Math.min(w_matrix[n-1][v-item.v] + item.w, w_matrix[n-1][v]);
                }
            }
        }

        int max_v = 0;
        for(int v = 0; v <= this.sum_v; v++) {
            if ((w_matrix[this.N][v] <= this.W ) &&  (max_v < v)) {
                max_v = v;
            }
        }
        return max_v;
    }
}
