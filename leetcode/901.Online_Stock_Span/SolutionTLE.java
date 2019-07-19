import java.util.TreeSet;
import java.util.HashMap;

class StockSpanner {
    TreeSet<Integer> stocks;
    HashMap<Integer, Integer> priceIndex;
    int count;

    public StockSpanner() {
        stocks = new TreeSet<Integer>();
        priceIndex = new HashMap<Integer, Integer>();
        count = 0;
    }

    public int next(int price) {
        count ++;
        Integer check = stocks.higher(price);
        if (check == null) {
            stocks.add(price);
            priceIndex.put(price, count);
            for (Integer smaller: stocks.headSet(price)) {
                priceIndex.put(smaller, count);
            }
            return count;
        }
        Integer index = priceIndex.get(check);
        stocks.add(price);
        priceIndex.put(price, count);
        for (Integer smaller: stocks.headSet(price)) {
            priceIndex.put(smaller, count);
        }
        return count - index.intValue();
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
