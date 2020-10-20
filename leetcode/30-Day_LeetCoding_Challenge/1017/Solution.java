class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int length = s.length();
        if (length == 0) return new ArrayList<>();
        Map<String, Integer> seqMap = new HashMap<>();

        for (int i = 0; i <= length - 10; i ++) {
            String substr = s.substring(i, i + 10);
            seqMap.put(substr, seqMap.getOrDefault(substr, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> seqEntry: seqMap.entrySet()) {
            if (seqEntry.getValue() <= 1) continue;
            ans.add(seqEntry.getKey());
        }

        return ans;
    }
}
