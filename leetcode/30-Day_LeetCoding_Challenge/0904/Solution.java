class Solution {
    public List<Integer> partitionLabels(String S) {
        int length = S.length();
        if (length == 0) return new ArrayList<Integer>();
        int[] lastAppearance = new int[26];

        List<Integer> partitionList = new ArrayList<>();

        for (int i = 0; i < length; i ++) {
            lastAppearance[S.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while (i < length) {
            int start_index = i;
            char c = S.charAt(i);
            int last_index = lastAppearance[c - 'a'];
            i ++;
            while (i <= last_index) {
                c = S.charAt(i);
                last_index = Math.max(last_index, lastAppearance[c - 'a']);
                i ++;
            }
            partitionList.add(last_index - start_index + 1);
        }
        return partitionList;
    }
}
