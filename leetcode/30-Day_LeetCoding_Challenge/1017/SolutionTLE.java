class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int length = s.length();
        if (length == 0) return new ArrayList<>();
        Set<String> ansSet = new HashSet<>();

        for (int i = 0; i < length - 1; i ++) {
            for (int j = i + 1; j < length; j ++) {
                int si = i;
                int ti = j;
                while (ti < length && si - i < 10) {
                    if (s.charAt(si) != s.charAt(ti)) break;
                    si ++;
                    ti ++;
                }
                if (si - i >= 10) {
                    ansSet.add(s.substring(i, si));
                }
            }
        }
        return new ArrayList<>(ansSet);
    }
}
