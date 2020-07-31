class Solution {
    class Trie {
        Trie[] words;
        boolean end;

        Trie() {
            words = new Trie[26];
            end = false;
        }

        void insert(String word) {
            if (word.length() == 0) {
                this.end = true;
                return;
            }

            int c = word.charAt(0) - 'a';
            if (words[c] == null) {
                words[c] = new Trie();
            }
            words[c].insert(word.substring(1));
        }

        void search(List<Integer> found, String word, int index) {
            if (end) {
                found.add(index);
            }
            if (word.length() == index) return;
            int c = word.charAt(index) - 'a';
            if (words[c] == null) return;
            words[c].search(found, word, index + 1);
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word: wordDict) {
            trie.insert(new StringBuilder(word).reverse().toString());
        }

        int length = s.length();
        List<Integer>[] indexList = new ArrayList[length + 1];
        String revS = new StringBuilder(s).reverse().toString();

        List<Integer> found = new ArrayList<>();
        trie.search(found, revS, 0);
        for (int index: found) {
            if (indexList[index] == null) {
                indexList[index] = new ArrayList<>();
            }
            indexList[index].add(0);
        }


        for (int i = 1; i < length; i ++) {
            if (indexList[i] == null) continue;
            found = new ArrayList<>();
            trie.search(found, revS, i);
            for (int index: found) {
                if (indexList[index] == null) {
                    indexList[index] = new ArrayList<>();
                }
                indexList[index].add(i);
            }
        }

        List<String> ans = new ArrayList<>();

        setBrokenWords(ans, length, s, "", indexList);
        return ans;
    }

    void setBrokenWords(List<String> ans, int start, String origin, String str, List<Integer>[] indexList) {
        List<Integer> list = indexList[start];
        if (list == null || list.isEmpty()) return;
        int length = origin.length();

        for (int end: list) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(origin.substring(length - start, length - end));
            if (end > 0) {
                sb.append(" ");
                setBrokenWords(ans, end, origin, sb.toString(), indexList);
            } else {
                ans.add(sb.toString());
            }
        }
    }

}
