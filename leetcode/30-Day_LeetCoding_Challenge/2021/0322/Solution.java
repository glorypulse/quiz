class Solution {
    class Trie {
        int endIndex;
        Trie[] tries;

        Trie(int length) {
            endIndex = -1;
            tries = new Trie[length];
        }

        void insert(String word, int index, int li) {
            if (word.length() == index) {
                if (endIndex < 0) {
                    endIndex = li;
                }
                return;
            }

            char c = word.charAt(index);
            if (tries[c - 'A'] == null) {
                tries[c - 'A'] = new Trie(tries.length);
            }
            tries[c - 'A'].insert(word, index + 1, li);
        }

        void insertIgnoringVowel(String word, int index, int li) {
            if (word.length() == index) {
                if (endIndex < 0) {
                    endIndex = li;
                }
                return;
            }

            char c = ignoreVowel(word.charAt(index));

            if (tries[c - 'A'] == null) {
                tries[c - 'A'] = new Trie(tries.length);
            }
            tries[c - 'A'].insertIgnoringVowel(word, index + 1, li);

        }

        int search(String word, int index) {
            if (word.length() == index) {
                return endIndex;
            }

            char c = word.charAt(index);
            if (tries[c - 'A'] == null) return -1;
            return tries[c - 'A'].search(word, index + 1);
        }

        int searchIgnoringVowel(String word, int index) {
            if (word.length() == index) {
                return endIndex;
            }

            char c = ignoreVowel(word.charAt(index));
            if (tries[c - 'A'] == null) return -1;
            return tries[c - 'A'].searchIgnoringVowel(word, index + 1);
        }

        private char ignoreVowel(char c) {
            switch (c) {
            case 'I':
            case 'O':
            case 'E':
            case 'U':
                return 'A';
            }
            return c;
        }
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Trie trie = new Trie(58);
        Trie trieUpper = new Trie(26);
        Trie trieVowel = new Trie(26);
        for (int i = 0; i < wordlist.length; i ++) {
            String word = wordlist[i];
            trie.insert(word, 0, i);
            String upperWord = word.toUpperCase();
            trieUpper.insert(upperWord, 0, i);
            trieVowel.insertIgnoringVowel(upperWord, 0, i);
        }

        String[] validQueries = new String[queries.length];
        for (int i = 0; i < queries.length; i ++) {
            String query = queries[i];
            if (trie.search(query, 0) >= 0) {
                validQueries[i] = query;
                continue;
            }
            String upperQuery = query.toUpperCase();
            int index = trieUpper.search(upperQuery, 0);
            if (index >= 0) {
                validQueries[i] = wordlist[index];
                continue;
            }
            index = trieVowel.searchIgnoringVowel(upperQuery, 0);
            if (index >= 0) {
                validQueries[i] = wordlist[index];
                continue;
            }
            validQueries[i] = "";
        }

        return validQueries;
    }
}
