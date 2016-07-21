package study;

import java.util.Scanner;
import java.io.PrintWriter;

import java.util.ArrayList;

public class Knapsack_A {
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

    Knapsack_A() {
        items = new ArrayList<Item>();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        Knapsack_A ks = new Knapsack_A();
        
        ks.N = sc.nextInt();
        for (int i = 0; i < ks.N; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            ks.items.add(new Item(w,v));
        }
        ks.W = sc.nextInt();

        int ans = ks.getValue(0, 0);
        pw.println("Answer:" + String.valueOf(ans));

        pw.flush();
        pw.close();
    }

    // i番目の品物、現在の重さcw
    int getValue(int i, int cw) {
        if (i == this.N) return 0; // 品物はもうない
        else {
            Item citem = items.get(i);
        if (cw + citem.w > this.W) return getValue(i + 1, cw); // この品物は入らない
        else return Math.max(citem.v + getValue(i + 1, cw+citem.w), getValue(i + 1, cw));
        }
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

