class Solution {
    public String reformat(String s) {
        char[] charArray = s.toCharArray();
        int numberCount = 0, alphabetCount = 0;
        for (char c: charArray) {
            if (c < 'a') {
                numberCount ++;
            } else {
                alphabetCount ++;
            }
        }

        if (numberCount < alphabetCount - 1 || numberCount > alphabetCount + 1) return "";

        StringBuilder sb = new StringBuilder();
        int numIndex = 0, alpIndex = 0;
        int length = charArray.length;
        if (numberCount < alphabetCount) {
            while (alpIndex < length && charArray[alpIndex] < 'a') alpIndex ++;
            sb.append(charArray[alpIndex]);
            alpIndex ++;
        }

        while (numIndex < length || alpIndex < length) {
            while (numIndex < length && charArray[numIndex] >= 'a') numIndex ++;
            while (alpIndex < length && charArray[alpIndex] < 'a') alpIndex ++;
            if (numIndex < length) sb.append(charArray[numIndex]);
            if (alpIndex < length) sb.append(charArray[alpIndex]);
            numIndex ++;
            alpIndex ++;
        }
        return sb.toString();
    }
}
