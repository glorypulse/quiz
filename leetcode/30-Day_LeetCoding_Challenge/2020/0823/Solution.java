class StreamChecker {
    class Trie {
        Trie[] nexts;
        boolean end;

        Trie() {
            this.end = false;
            this.nexts = new Trie[26];
        }

        void insert(String word) {
            insert(word, 0);
        }

        void insert(String word, int index) {
            if (word.length() == index) {
                this.end = true;
                return;
            }

            int c_index = word.charAt(index) - 'a';
            if (nexts[c_index] == null) {
                nexts[c_index] = new Trie();
            }
            nexts[c_index].insert(word, index + 1);
        }

        Trie search(char letter) {
            return nexts[letter - 'a'];
        }
    }

    Trie rootTrie;
    Queue<Trie> tmpTries;

    public StreamChecker(String[] words) {
        rootTrie = new Trie();
        for (String word: words) {
            rootTrie.insert(word);
        }
        tmpTries = new LinkedList<>();
    }

    public boolean query(char letter) {
        boolean result = false;

        Queue<Trie> nextTries = new LinkedList<>();
        tmpTries.offer(rootTrie);
        while (!tmpTries.isEmpty()) {
            Trie tmp = tmpTries.poll().search(letter);
            if (tmp != null) {
                if (tmp.end) {
                    result = true;
                }
                nextTries.offer(tmp);
            }
        }
        tmpTries = nextTries;
        return result;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
