class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> countMap = new TreeMap<>(Collections.reverseOrder());

        int count;
        for (int num: arr) {
            count = countMap.getOrDefault(num, 0);
            count ++;
            countMap.put(num, count);
        }

        for (Map.Entry<Integer, Integer> countNum: countMap.entrySet()) {
            if (countNum.getKey() == countNum.getValue()) return countNum.getKey();
        }
        return -1;
    }
}
