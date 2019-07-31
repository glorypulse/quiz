import java.util.ArrayList;
import java.util.ArrayDeque;

/*
"dddiiiinnssssssoooo"
["dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"]
*/

class Solution {
    public int expressiveWords(String S, String[] words) {
        ArrayDeque<String> wordQueue = new ArrayDeque<>();
        for (String word: words) {
            wordQueue.add(word);
        }

        int j, l, queueSize;
        for (int i = 0; i < S.length(); i ++) {
            char c = S.charAt(i);
            char cN;
            j = 1;
            while (i + j < S.length()) {
                cN = S.charAt(i + j);
                if (c != cN) break;
                j ++;
            }
            StringBuilder sb = new StringBuilder();
            ArrayList<String> list = new ArrayList<>();
            sb.append(c);
            list.add(sb.toString());

            if (j >= 3) {
                i += j - 1;
                while (j > 1) {
                    sb.append(c);
                    list.add(sb.toString());
                    j --;
                }
                list.add(sb.toString()); // length of j
            }

            Collections.reverse(list);
            queueSize = wordQueue.size();
            for (l = 0; l < queueSize; l ++) {
                String word = wordQueue.poll();
                for (String check: list) {
                    int index = word.indexOf(check);
                    if (index != 0) continue;
                    wordQueue.offer(word.substring(index + check.length()));
                    break;
                }
            }
            if (wordQueue.size() == 0) return 0;
        }

        int count = 0;
        while (!wordQueue.isEmpty()) {
            String word = wordQueue.poll();
            if (word.isEmpty()) count ++;
        }

        return count;
    }
}
