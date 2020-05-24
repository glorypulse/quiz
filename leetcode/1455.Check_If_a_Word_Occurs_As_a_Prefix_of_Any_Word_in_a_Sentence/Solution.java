class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int index = 1;
        for (String word: sentence.split(" ")) {
            if (word.indexOf(searchWord) == 0) return index;
            index ++;
        }
        return -1;
    }
}
