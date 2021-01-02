class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i ++) {
            String word = words[i];
            List<Integer> wordIndexList = wordMap.get(word);
            if (wordIndexList == null) {
                wordIndexList = new ArrayList<>();
                wordMap.put(word, wordIndexList);
            }
            wordIndexList.add(i);
        }

        int min = Integer.MAX_VALUE;
        for (int add1: wordMap.get(word1)) {
            for (int add2: wordMap.get(word2)) {
                min = Math.min(min, Math.abs(add1 - add2));
            }
        }

        return min;
    }
}
