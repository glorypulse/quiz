package study;

import java.util.Scanner;
import java.io.PrintWriter;

import java.util.ArrayList;

/**
   Knapsack_Bをループに書き換えたバージョン
*/
public class Knapsack_C {
    /*
      4
      2 3
      1 2
      3 4
      2 2
      5
    */

    int N = 0;
    Item items[];
    int W = 0;
    int memo[][];

    void initItem() {
        items = new Item[this.N];
    }
    void initMemo() {
        memo = new int[this.N+1][this.W+1];
        for (int i = 0; i <= this.N; i++) {
            for (int j = 0; j <= this.W; j++) {
                memo[i][j] = -1;
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        Knapsack_C ks = new Knapsack_C();
        
        ks.N = sc.nextInt();
        ks.initItem();
        for (int i = 0; i < ks.N; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            ks.items[i] = new Item(w,v);
        }
        ks.W = sc.nextInt();
        ks.initMemo();

        int ans = ks.getValue();
        pw.println("Answer:" + String.valueOf(ans));

        pw.flush();
        pw.close();
    }

    int getValue() {
        for (int i = this.N; i >= 0; i--) {
            for (int w = 0; w <= this.W; w++) {
                if (i==this.N) {
                    memo[i][w] = 0; // 初期化
                } else if (items[i].w > w) {
                    memo[i][w] = memo[i+1][w];
                } else {
                    memo[i][w] = Math.max(memo[i+1][w-items[i].w] + items[i].v,
                                          memo[i+1][w]);
                }
            }
        }
        return memo[0][this.W];
    }

}

// Knapsack_A.javaがある前提でコメントアウト
// class Item {
//     int w;
//     int v;
//     Item (int w, int v) {
//         this.w = w;
//         this.v = v;
//     }

//     // for debug
//     @Override
//     public String toString() {
//         return (String.valueOf(w) + "," + String.valueOf(v));
//     }
// }

