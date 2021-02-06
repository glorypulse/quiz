class Solution {
    class HarmoniousSubarray {
        boolean existMin;
        boolean existMax;
        int count;
        int num;
        HarmoniousSubarray(int num) {
            existMin = false;
            existMax = false;
            count = 0;
            this.num = num;
        }

        void setExist(int num) {
            if (this.num == num) {
                existMin = true;
            } else {
                existMax = true;
            }
        }

        boolean isHarmonious() {
            return existMin && existMax;
        }
    }
    public int findLHS(int[] nums) {
        Map<Integer, HarmoniousSubarray> map = new HashMap<>();
        for (int num: nums) {
            setHarmoniousSubarray(num - 1, num, map);
            setHarmoniousSubarray(num, num, map);
        }
        int max = 0;
        for (HarmoniousSubarray hs: map.values()) {
            if (hs.isHarmonious()) {
                max = Math.max(max, hs.count);
            }
        }
        return max;
    }

    void setHarmoniousSubarray(int key, int num, Map<Integer, HarmoniousSubarray> map) {
        HarmoniousSubarray hs = map.get(key);
        if (hs == null) {
            hs = new HarmoniousSubarray(num);
            map.put(key, hs);
        }
        hs.setExist(num);
        hs.count ++;

    }
}
