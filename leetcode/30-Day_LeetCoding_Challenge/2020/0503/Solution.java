class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineMap = new HashMap<>();
        for (char m: magazine.toCharArray()) {
            int mCount = magazineMap.getOrDefault(m, 0);
            magazineMap.put(m, mCount + 1);
        }

        for (char r: ransomNote.toCharArray()) {
            int rCount = magazineMap.getOrDefault(r, 0);
            if (rCount == 0) {
                return false;
            }
            magazineMap.put(r, rCount - 1);
        }

        return true;
    }
}
