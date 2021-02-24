class Solution {
    class Word {
        String str;
        int index;

        Word(String str) {
            this.str = str;
            this.index = 0;
        }

        String getStr() {
            return str;
        }

        int getLength() {
            return str.length();
        }

        void inc() {
            index ++;
        }

        boolean longerThan(Word word) {
            return word.getLength() < getLength() ||
                word.getLength() == getLength() && str.compareTo(word.getStr()) < 0;
        }

        boolean found() {
            return (index == str.length());
        }

        char getCurrentChar() {
            return str.charAt(index);
        }
    }

    public String findLongestWord(String s, List<String> d) {
        Queue<Word>[] charMap = new Queue[26];
        for (int i = 0; i < 26; i ++) {
            charMap[i] = new LinkedList<>();
        }
        for (String word: d) {
            charMap[word.charAt(0) - 'a'].offer(new Word(word));
        }

        Word longestWord = new Word("");
        for (char c: s.toCharArray()) {
            Queue<Word> queue = charMap[c - 'a'];
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                Word word = queue.poll();
                word.inc();
                if (word.found()) {
                    if (word.longerThan(longestWord)) {
                        longestWord = word;
                    }
                } else {
                    charMap[word.getCurrentChar() - 'a'].offer(word);
                }
            }
        }
        return longestWord.getStr();
    }
}
