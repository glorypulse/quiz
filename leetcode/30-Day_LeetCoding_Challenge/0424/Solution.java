class LRUCache {
    HashMap<Integer, Integer> valueMap;
    LinkedList<Integer> indexList; // 自分で連結リストして、自分のindexをmapに持つなどするとO(1)にできそう
    int capacity;

    public LRUCache(int capacity) {
        valueMap = new HashMap<>();
        indexList = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = valueMap.get(key);
        if (value == null) return -1;

        int first = indexList.getFirst();
        if (first != key) {
            indexList.remove((Integer)key); // O(n)
            indexList.addFirst(key);
        }
        return value;
    }

    public void put(int key, int value) {
        Integer oldValue = get(key);
        valueMap.put(key, value);
        if (oldValue == -1) {
            indexList.addFirst(key);
            if (indexList.size() > capacity) {
                int last = indexList.removeLast();
                valueMap.put(last, null);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
