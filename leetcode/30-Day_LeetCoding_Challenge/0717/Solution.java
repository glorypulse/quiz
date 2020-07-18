class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums) {
            int count = frequencyMap.getOrDefault(num, 0);
            frequencyMap.put(num, count + 1);
        }

        int[][] freqArray = new int[frequencyMap.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> freq: frequencyMap.entrySet()) {
            freqArray[i][0] = freq.getKey();
            freqArray[i][1] = freq.getValue();
            i ++;
        }

        Arrays.sort(freqArray, (a, b) -> (b[1] - a[1]));

        int[] topKfreq = new int[k];
        for (i = 0; i < k; i ++) {
            topKfreq[i] = freqArray[i][0];
        }
        return topKfreq;
    }
}
