class Solution {
    public int lengthOfLastWord(String s) {
        String[] splitStrs = s.split(" ");
        if (splitStrs.length == 0) return 0;
        return splitStrs[splitStrs.length - 1].length();
    }
}