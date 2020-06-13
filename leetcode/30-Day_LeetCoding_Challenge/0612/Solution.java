class RandomizedSet {
    HashSet<Integer> realSet;
    Integer[] allSet;
    int size = 0;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        realSet = new HashSet<>();
        allSet = new Integer[10];
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (realSet.contains(val)) return false;
        if (size == allSet.length) {
            Integer[] tmpSet = new Integer[size * 2];
            int not = 0;
            for (int i = 0; i < size; i ++) {
                if (allSet[i] == null) {
                    not ++;
                    continue;
                }
                tmpSet[i - not] = allSet[i];
            }
            size -= not;
            allSet = tmpSet;
        }
        realSet.add(val);
        allSet[size] = val;
        size ++;
        return true;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!realSet.contains(val)) return false;
        if (realSet.size() > 10 && realSet.size() == allSet.length / 4) {
            Integer[] tmpSet = new Integer[size * 2];
            int not = 0;
            for (int i = 0; i < size; i ++) {
                if (allSet[i] == null) {
                    not ++;
                    continue;
                }
                tmpSet[i - not] = allSet[i];
            }
            size -= not;
            allSet = tmpSet;
        }
        realSet.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Integer ans = null;
        while (ans == null) {
            int r = random.nextInt(size);
            ans = allSet[r];
            if (!realSet.contains(ans)) {
                ans = allSet[r] = null;
            }
        }
        return ans;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
