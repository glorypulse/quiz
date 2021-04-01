class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });
        TreeMap<Integer, Set<int[]>> countMap = new TreeMap<>(Collections.reverseOrder());
        countMap.put(1, new HashSet<>() {
                {
                    add(envelopes[0]);
                };
            }); // length >= 1
        for (int i = 1; i < length; i ++) {
            int[] envelope = envelopes[i];
            boolean fitted = false;
            for (Map.Entry<Integer, Set<int[]>> countEntry: countMap.entrySet()) {
                Set<int[]> includedSet = countEntry.getValue();
                int count = countEntry.getKey() + 1;
                for (int[] included: includedSet) {
                    if (included[0] < envelope[0] && included[1] < envelope[1]) {
                        countMap.putIfAbsent(count, new HashSet<>());
                        Set<int[]> set = countMap.get(count);
                        set.add(envelope);
                        fitted = true;
                        break;
                    }
                }
                if (fitted) break;
            }
            if (!fitted) {
                Set<int[]> set = countMap.get(1);
                set.add(envelope);
            }
        }

        return countMap.firstKey();
    }
}
