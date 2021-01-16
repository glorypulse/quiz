import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> wordSquaresList = new ArrayList<List<String>>();
        LinkedList<String> wordList = new LinkedList<String>();
        for (String word: words) {
            wordList.add(word);
            makeSquares(1, word.length(), wordList, words, wordSquaresList);
            wordList.removeLast();
        }

        return wordSquaresList;
    }

    void makeSquares(int index, int n, LinkedList<String> wordList, String[] words, List<List<String>> wordSquaresList) {
        if (index == n) {
            wordSquaresList.add(new ArrayList(wordList));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String s: wordList) {
            sb.append(s.charAt(index));
        }
        String substring = sb.toString();

        for (String word: words) {
            if (word.indexOf(substring) == 0) {
                wordList.add(word);
                makeSquares(index + 1, n, wordList, words, wordSquaresList);
                wordList.removeLast();
            }
        }
        return;
    }

}
