class Solution {

    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        List<String> combinations = new ArrayList<>();
        if (length == 0) return combinations;
        char[] charArray = new char[length];

        setCombinations(0, digits, charArray, combinations);
        return combinations;
    }

    void setCombinations(int index, String digits, char[] charArray, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(new String(charArray));
            return;
        }
        for (char c: getCharsArray(digits.charAt(index) - '0')) {
            charArray[index] = c;
            setCombinations(index + 1, digits, charArray, combinations);
        }
    }

    char[] getCharsArray(int num) {
        char[] arr;
        if (num < 7 || num == 8) {
            arr = new char[3];
        } else {
            arr = new char[4];
        }
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = (char)('a' + (num - 2) * 3 + i + (num / 8));
        }
        return arr;
    }
}
