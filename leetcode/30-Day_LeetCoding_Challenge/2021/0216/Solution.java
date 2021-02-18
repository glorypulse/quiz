class Solution {
    public List<String> letterCasePermutation(String S) {
        int length = S.length();
        char[] charArray = S.toCharArray();
        List<String> permutations = new ArrayList<>();

        setPermutations(S, 0, charArray, permutations);
        return permutations;
    }

    void setPermutations(String s, int index, char[] charArray, List<String> permutations) {
        if (index == charArray.length) {
            permutations.add(new String(charArray));
            return;
        }
        char c = s.charAt(index);
        if (Character.isDigit(c)) {
            charArray[index] = c;
        } else {
            charArray[index] = Character.toLowerCase(c);
            setPermutations(s, index + 1, charArray, permutations);
            charArray[index] = Character.toUpperCase(c);
        }
        setPermutations(s, index + 1, charArray, permutations);
    }
}
