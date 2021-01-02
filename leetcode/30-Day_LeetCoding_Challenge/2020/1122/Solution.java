class Solution {
    static String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> codeSet = new HashSet<>();
        for (String word: words) {
            StringBuilder codeBuilder = new StringBuilder();
            for (char c: word.toCharArray()) {
                codeBuilder.append(morseCodes[c - 'a']);
            }
            codeSet.add(codeBuilder.toString());
        }
        return codeSet.size();
    }
}
