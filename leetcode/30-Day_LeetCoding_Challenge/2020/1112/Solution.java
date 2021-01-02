class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> ansList = new ArrayList<>();
        if (length == 0) return ansList;

        Queue<Integer> numsQueue = new LinkedList<>();
        for (int num: nums) {
            numsQueue.offer(num);
        }

        setPermutation(numsQueue, "", new LinkedList<>(), ansList, new HashSet<>());

        return ansList;
    }

    void setPermutation(Queue<Integer> numsQueue, String key, LinkedList<Integer> tmpList, List<List<Integer>> ansList, Set<String> exists) {
        exists.add(key);
        if (numsQueue.isEmpty()) {
            ansList.add(new ArrayList<>(tmpList));
            return;
        }

        int size = numsQueue.size();
        for (int i = 0; i < size; i ++) {
            int num = numsQueue.poll();
            String nextKey = key + num + ",";
            if (exists.contains(nextKey)) {
                numsQueue.offer(num);
                continue;
            }
            tmpList.add(num);
            setPermutation(numsQueue, nextKey, tmpList, ansList, exists);
            tmpList.removeLast();
            numsQueue.offer(num);
        }
    }
}
