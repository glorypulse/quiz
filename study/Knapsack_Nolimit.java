package study;

import java.util.Scanner;
import java.io.PrintWriter;

public class Knapsack_Nolimit {
    /* sample
3
3 4
4 5
2 3
7
    */

    int N;
    int[][] items;
    int W;
    int[][] value_matrix;
    
    public Knapsack_Nolimit(int N, int[][] items, int W) {
        this.N = N;
        this.items = items;
        this.W = W;

        init();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int N = sc.nextInt();
        int[][] items = new int[N][2];
        for (int i = 0; i < N; i++) {
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
        }
        int W = sc.nextInt();

        // debug
        // pw.println("N..." + String.valueOf(N));
        // pw.println("W..." + String.valueOf(W));
        // for (int[] item : items) {
        //     pw.println("items.." + String.valueOf(item[0]) + "," + String.valueOf(item[1]));
        // }
        
        Knapsack_Nolimit ksnl = new Knapsack_Nolimit(N, items, W);
        int ans = ksnl.solve();

        //debug
        // ksnl.printMatrix();

        pw.println("Answer: " + String.valueOf(ans));

        pw.flush();
        pw.close();
    
    }

    void init() {
        value_matrix = new int[W+1][N+1]; // ゼロの時を考えるので、大きさは+1        
        for (int w = 0; w <= this.W; w++) {
            value_matrix[w][0] = 0; // 品物を１つも選べないときは価値0
        }
    }
    
    int solve() {
        for (int w = 0; w <= this.W; w++) {
            for (int n = 0; n < this.N; n++) {

                if (w - items[n][0] < 0) { // n番目の品物は入れられない
                    value_matrix[w][n+1] = value_matrix[w][n];
                } else {
                    value_matrix[w][n+1] = Math.max(value_matrix[w][n],
                                                    value_matrix[w - items[n][0]][n+1] + items[n][1]);
                }
            }
        }

        return value_matrix[W][N];
    }

    void printMatrix() {
        for (int[] value_items : value_matrix) {
            for (int value : value_items) {
                System.out.print(String.valueOf(value) + ",");
            }
            System.out.println();
        }
    }
}
