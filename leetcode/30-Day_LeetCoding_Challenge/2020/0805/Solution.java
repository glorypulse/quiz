class WordDictionary {
    class Trie {
        Trie[] children;
        boolean end;

        Trie() {
            children = new Trie[26];
            end = false;
        }

        void insert(String word) {
            insert(word, 0);
        }

        void insert(String word, int index) {
            if (index == word.length()) {
                end = true;
                return;
            }

            int c = word.charAt(index) - 'a';
            if (children[c] == null) {
                children[c] = new Trie();
            }
            children[c].insert(word, index + 1);
        }

        boolean search(String word) {
            return search(word, 0);
        }

        boolean search(String word, int index) {
            if (index == word.length()) {
                return end;
            }
            char c = word.charAt(index);
            if (c == '.') {
                for (Trie child: children) {
                    if (child == null) continue;
                    if (child.search(word, index + 1)) {
                        return true;
                    }
                }
            } else {
                Trie child = children[c - 'a'];
                if (child != null) {
                    return child.search(word, index + 1);
                }
            }
            return false;
        }

    }

    Trie trie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
