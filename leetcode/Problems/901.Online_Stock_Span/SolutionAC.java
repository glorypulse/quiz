import java.util.Stack;

class StockSpanner {
    Stack<int[]> stocks;

    public StockSpanner() {
        stocks = new Stack<int[]>();
    }

    public int next(int price) {
        int count = 1;
        while(!stocks.isEmpty() && price >= stocks.peek()[0]) {
            count += stocks.pop()[1];
        }
        stocks.push(new int[] { price, count });
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
