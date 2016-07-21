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
        ks.initItems();
        for (int i = 0; i < ks.N; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            ks.items[i] = new Item(w,v);
        }
        ks.W = sc.nextInt();
        ks.initMemo();

        int ans = ks.getValue(0, ks.W);
        pw.println("Answer:" + String.valueOf(ans));

        pw.flush();
        pw.close();
    }

    int solve() {
        for (int i = 0; i < this.N; i++) {
            for (int w = 0; w < this.W; w++) {
                //TODO
            }
        }
    }
    // i番目の品物、残りの重さrw
    int getValue(int i, int rw) {

        // 最初にメモされているか確認する
        if (memo[i][rw] >=0 ) {
            return memo[i][rw];
        }


        int value = -1; // メモ化するため、値として持つ
        
        if (i == this.N) { value = 0}; // 品物はもうない
        else if (items[i].w > rw) { value = getValue(i + 1, rw) }; // この品物は入らない
        else {
            value = Math.max(getValue(i+1, rw-items[i].w) + items[i].v,
                             getValue(i+1, rw));
        }

        memo[i][rw] = value;
        return value;


    }

}

class Item {
    int w;
    int v;
    Item (int w, int v) {
        this.w = w;
        this.v = v;
    }

    // for debug
    @Override
    public String toString() {
        return (String.valueOf(w) + "," + String.valueOf(v));
    }
}

