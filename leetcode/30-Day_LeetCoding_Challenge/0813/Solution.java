class CombinationIterator {
    int combinationLength;
    char[] characters;
    int length;
    int[] nextIndex;

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters.toCharArray();
        this.length = characters.length();
        this.combinationLength = combinationLength;
        this.nextIndex = new int[combinationLength];
        for (int i = 0; i < combinationLength; i ++) {
            nextIndex[i] = i;
        }
    }

    public String next() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < combinationLength; i ++) {
            sb.append(characters[nextIndex[i]]);
        }

        for (int i = combinationLength - 1; i >= 0; i --) {
            if (nextIndex[i] < (length - combinationLength + i)) {
                nextIndex[i] ++;
                for (int j = i + 1; j < combinationLength; j ++) {
                    nextIndex[j] = nextIndex[j - 1] + 1;
                }
                break;
            } else if (i == 0) {
                nextIndex[i] ++;
            }
        }

        return sb.toString();
    }

    public boolean hasNext() {
        return nextIndex[0] < (length - combinationLength + 1);
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
