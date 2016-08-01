package study;

import java.util.Scanner;
import java.io.PrintWriter;

import java.util.ArrayList;

/**
   Knapsack_Aにメモ化の改良を加えたバージョン
*/
public class Knapsack_B {
    /*
      4
      2 3
      1 2
      3 4
      2 2
      5
    */

    int N = 0;
    ArrayList<Item> items;
    int W = 0;
    int memo[][];

    Knapsack_B() {
        items = new ArrayList<Item>();
    }

    void initArray() {
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

        Knapsack_B ks = new Knapsack_B();
        
        ks.N = sc.nextInt();
        for (int i = 0; i < ks.N; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            ks.items.add(new Item(w,v));
        }
        ks.W = sc.nextInt();
        ks.initArray();

        int ans = ks.getValue(0, ks.W);
        pw.println("Answer:" + String.valueOf(ans));

        pw.flush();
        pw.close();
    }

    // i番目の品物、残りの重さrw
    int getValue(int i, int rw) {

        // 最初にメモされているか確認する
        if (memo[i][rw] >=0 ) {
            return memo[i][rw];
        }


        int value = -1; // メモ化するため、値として持つ
        
        if (i == this.N) { // 品物はもうない
            value = 0;
        } else {
            Item citem = items.get(i);
            if (citem.w > rw) { // この品物は入らない
                value = getValue(i + 1, rw);
            } else {
                value = Math.max(getValue(i+1, rw-citem.w) + citem.v,
                                 getValue(i+1, rw));
            }
        }

        memo[i][rw] = value;
        return value;


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

