class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int end = -1;
        Map<String, Set<Integer>> map = new HashMap<>();
        registerStrToMap(beginWord, 0, map);
        int i = 1;
        for (String word: wordList) {
            if (word.equals(endWord)) {
                end = i;
            }
            registerStrToMap(word, i, map);
            i ++;
        }
        if (end < 0) return 0;
        Set<Integer>[] edges = new HashSet[wordList.size() + 1];
        for (Set<Integer> indexes: map.values()) {
            if (indexes.size() > 1) {
                for (int index: indexes) {
                    if (edges[index] == null) {
                        edges[index] = new HashSet<>();
                    }
                    edges[index].addAll(indexes);
                }
            }
        }

        int[] steps = new int[wordList.size() + 1];
        Arrays.fill(steps, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        int current = 1;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (i = 0; i < size; i ++) {
                int index = queue.poll();
                for (int next: edges[index]) {
                    if (index != next && steps[next] > current) {
                        steps[next] = current;
                        if (next == end) return current + 1;
                        queue.offer(next);
                    }
                }
            }
            current ++;
        }
        return 0;
    }

    void registerStrToMap(String str, int index, Map<String, Set<Integer>> map) {
        char[] charArray = str.toCharArray();
        for (int j = 0; j < str.length(); j ++) {
            char tmp = charArray[j];
            charArray[j] = '*';
            String mapStr = new String(charArray);
            Set<Integer> mapIndex = map.get(mapStr);
            if (mapIndex == null) {
                mapIndex = new HashSet<>();
                map.put(mapStr, mapIndex);
            }
            mapIndex.add(index);
            charArray[j] = tmp;
        }
    }
}
