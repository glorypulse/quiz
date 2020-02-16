class Solution {
    public int minSteps(String s, String t) {
        Map<Character,Integer> letterMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            Integer count = letterMap.get(c);
            if (count == null) {
                count = 0;
            }
            letterMap.put(c, count + 1);
        }

        int stepCount = 0;
        for (char c: t.toCharArray()) {
            Integer count = letterMap.get(c);
            if (count == null || count == 0) {
                stepCount ++;
            } else {
                letterMap.put(c, count - 1);
            }
        }

        return stepCount;
    }
}
