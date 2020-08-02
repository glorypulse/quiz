class MyHashSet {
    boolean[] containsKey;

    /** Initialize your data structure here. */
    public MyHashSet() {
        containsKey = new boolean[1000001];
    }

    public void add(int key) {
        containsKey[key] = true;
    }

    public void remove(int key) {
        containsKey[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return containsKey[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
