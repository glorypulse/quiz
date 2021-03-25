class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int length = arr.length;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < length; i ++) {
            counts.put(arr[i], counts.getOrDefault(arr[i], 0) + 1);
        }

        int total = 0;
        for (int i = 0; i < length - 2; i ++) {
            int val1 = arr[i];
            counts.put(val1, counts.get(val1) - 1);
            for (int j = i + 1; j < length - 1; j ++) {
                int val2 = arr[j];
                counts.put(val2, counts.get(val2) - 1);
                total = (total + countTarget(target - val1 - val2, counts)) % 1000000007;
            }
            for (int j = i + 1; j < length - 1; j ++) {
                int val2 = arr[j];
                counts.put(val2, counts.get(val2) + 1);
            }
        }
        return total;
    }

    int countTarget(int key, Map<Integer, Integer> counts) {
        Integer count = counts.get(key);
        if (count == null || count < 1) return 0;
        return count;
    }
}
