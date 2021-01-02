import java.util.Stack;

class StockSpanner {
    ArrayList<Integer> stocks;

    public StockSpanner() {
        stocks = new ArrayList<>();
    }

    public int next(int price) {
        int count = 1;
        for (int i = stocks.size() - 1; i >= 0; i --) {
            if (stocks.get(i) <= price) {
                count ++;
                // 1ずつじゃなくてiをもっと飛ばせる, spanとstockの２つの配列を持てる
            } else {
                break;
            }
        }
        stocks.add(price);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
