class Solution {
    public String reverseWords(String s) {
        if (s.isEmpty()) return s;
        String[] words = s.split(" ", 0);
        StringBuilder sb = new StringBuilder();
        int minIndex = 0;
        while (minIndex < words.length && words[minIndex].isEmpty()) {
            minIndex ++;
        }
        for (int i = words.length - 1; i >= minIndex; i --) {
            if (words[i].isEmpty()) {
                continue;
            }
            sb.append(words[i]);
            if (i > minIndex) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
