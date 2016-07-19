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

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
            
        int N = sc.nextInt();
        ArrayList<Item> items = new ArrayList<Item>();
        for (int i = 0; i < N; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            items.add(new Item(w,v));
        }
        int W = sc.nextInt();

        for(Item item: items) {
            pw.println(item.toString());
        }


        pw.flush();
        pw.close();
            
        
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

