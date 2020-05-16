class Trie {
    Trie[] children;
    boolean end;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        end = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.isEmpty()) {
            end = true;
            return;
        }
        int index = word.charAt(0) - 'a';
        if (children[index] == null) {
            children[index] = new Trie();
        }
        children[index].insert(word.substring(1));
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.isEmpty()) return end;

        int index = word.charAt(0) - 'a';
        if (children[index] == null) return false;
        return children[index].search(word.substring(1));
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) return true;

        int index = prefix.charAt(0) - 'a';
        if (children[index] == null) return false;
        return children[index].startsWith(prefix.substring(1));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
