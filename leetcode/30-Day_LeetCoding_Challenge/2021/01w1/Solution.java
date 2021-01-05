class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> appearanceSet = new HashSet<>();
        for (char c: s.toCharArray()) {
            if (appearanceSet.contains(c)) {
                appearanceSet.remove(c);
            } else {
                appearanceSet.add(c);
            }
        }
        if (appearanceSet.size() <= 1) return true;
        return false;
    }
}
