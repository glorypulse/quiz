class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = arr.length;
        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(arr);
        for (int num: arr) {
            if (map.get(num) <= 0) continue;
            map.put(num, map.get(num) - 1);
            if (map.getOrDefault(2 * num, 0) > 0) {
                map.put(2 * num, map.get(2 * num) - 1);
            } else if (num % 2 == 0 && map.getOrDefault(num / 2, 0) > 0) {
                map.put(num / 2, map.get(num / 2) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
