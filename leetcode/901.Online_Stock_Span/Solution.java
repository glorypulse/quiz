import java.util.Stack;

class StockSpanner {
    int[] stocks;
    int[] spans;
    int index;

    public StockSpanner() {
        stocks = new int[10000];
        spans = new int[10000];
        index = 0;
    }

    public int next(int price) {
        int span = 1;
        int i = index - 1;
        while (i >= 0) {
            if (stocks[i] <= price) {
                span += spans[i];
                i -= spans[i];
            } else {
                break;
            }
        }
        stocks[index] = price;
        spans[index] = span;
        index ++;

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
