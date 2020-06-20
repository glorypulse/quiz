class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num: arr) {
            int count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }

        int[] counts = new int[countMap.size()];
        int index = 0;
        for (Integer count: countMap.values()) {
            counts[index] = count;
            index ++;
        }
        Arrays.sort(counts);
        index = 0;
        int count = 0;
        while (count < k) {
            counts[index] --;
            if (counts[index] == 0) index ++;
            count ++;
        }

        return counts.length - index;
    }
}
