class FirstUnique {
    LinkedHashSet<Integer> uniqSet;
    HashSet<Integer> dupSet;

    public FirstUnique(int[] nums) {
        uniqSet = new LinkedHashSet<>();
        dupSet = new HashSet<>();

        for (int num: nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        Iterator<Integer> it = uniqSet.iterator();
        if (!it.hasNext()) return -1;
        return it.next();
    }

    public void add(int value) {
        if (dupSet.contains(value)) {
            uniqSet.remove(value);
        } else {
            uniqSet.add(value);
            dupSet.add(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
