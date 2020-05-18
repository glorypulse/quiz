class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pCharCount = new HashMap<>();
        for (char cp: p.toCharArray()) {
            int count = pCharCount.getOrDefault(cp, 0);
            count ++;
            pCharCount.put(cp, count);
        }

        List<Integer> ansList = new LinkedList<>();
        Set<Character> keySet = pCharCount.keySet();
        int falseCount = 0;
        int sLen = s.length();
        int pLen = p.length();
        for (int i = 0; i < sLen; i ++) {
            char c = s.charAt(i);
            int count = pCharCount.getOrDefault(c, 0);
            count --;
            if (count < 0) {
                falseCount --;
            }
            pCharCount.put(c, count);

            if (i >= pLen - 1) {
                int oldIndex = i - pLen + 1;
                if (falseCount == 0) ansList.add(oldIndex);
                char oc = s.charAt(oldIndex);
                int oCount = pCharCount.get(oc);
                oCount ++;
                if (oCount == 0) {
                    falseCount ++;
                }
                pCharCount.put(oc, oCount);
            }
        }
        return ansList;
    }
}
