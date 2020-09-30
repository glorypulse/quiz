class Solution {
    class Trie {
        Trie[] children;
        boolean isWord;

        Trie() {
            children = new Trie[26];
            isWord = false;
        }

        void insert(String word) {
            insert(word, 0);
        }

        void insert(String word, int index) {
            if (index == word.length()) {
                isWord = true;
                return;
            }

            int cNum = word.charAt(index) - 'a';
            Trie child = children[cNum];
            if (child == null) {
                child = children[cNum] = new Trie();
            }
            child.insert(word, index + 1);
        }

        List<Integer> search(String str, int index) {
            List<Integer> found = new ArrayList<>();
            return search(str, index, found);
        }

        List<Integer> search(String str, int index, List<Integer> found) {
            if (isWord) {
                found.add(index);
            }
            if (index == str.length()) {
                return found;
            }
            int cNum = str.charAt(index) - 'a';
            Trie child = children[cNum];
            if (child == null) return found;
            return child.search(str, index + 1, found);
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        if (length == 0) return false;

        Trie trie = new Trie();
        for (String word: wordDict) {
            trie.insert(word);
        }

        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(0);

        Set<Integer> searchSet = new HashSet<>();
        searchSet.add(0);

        while (!indexStack.isEmpty()) {
            int index = indexStack.pop();
            List<Integer> found = trie.search(s, index);
            for (int fNum: found) {
                if (fNum == length) return true;
                if (!searchSet.contains(fNum)) {
                    searchSet.add(fNum);
                    indexStack.push(fNum);
                }
            }
        }

        return false;
    }
}
