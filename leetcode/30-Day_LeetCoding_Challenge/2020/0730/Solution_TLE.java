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

        void search(List<String> found, String word, int start, int index) {
            if (end) {
                found.add(word.substring(start, index));
            }
            if (word.length() == index) return;
            int c = word.charAt(index) - 'a';
            if (words[c] == null) return;
            words[c].search(found, word, start, index + 1);
        }
    }

    class WordNode {
        List<String> words;
        int index;

        WordNode(int index) {
            this.words = new ArrayList<>();
            this.index = index;
        }

        WordNode(int index, List<String> words) {
            this.words = new ArrayList<>(words);
            this.index = index;
        }

    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word: wordDict) {
            trie.insert(word);
        }

        Queue<WordNode> queue = new LinkedList<>();
        queue.offer(new WordNode(0));

        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            WordNode wordNode = queue.poll();
            if (wordNode.index == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (String word: wordNode.words) {
                    sb.append(word);
                    sb.append(" ");
                }
                ans.add(sb.toString().trim());
                continue;
            } else if (wordNode.index > s.length()) {
                continue;
            }

            List<String> found = new ArrayList<>();
            trie.search(found, s, wordNode.index, wordNode.index);
            if (found.size() == 1) {
                String word = found.get(0);
                wordNode.words.add(word);
                wordNode.index += word.length();
                queue.offer(wordNode);
            } else if (found.size() > 1) {
                for (String word: found) {
                    WordNode newNode = new WordNode(wordNode.index + word.length(), wordNode.words);
                    newNode.words.add(word);
                    queue.offer(newNode);
                }
            }
        }

        return ans;
    }
}
