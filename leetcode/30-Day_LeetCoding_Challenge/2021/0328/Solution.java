class Solution {
    class Digit {
        char[] charArray;
        int digit;

        Digit(String s, int d) {
            charArray = s.toCharArray();
            digit = d;
        }
    }
    public String originalDigits(String s) {
        int[] counts = new int[26];
        for (char c: s.toCharArray()) {
            counts[c - 'a'] ++;
        }

        Map<Character, Digit> firstMap = new HashMap<>();
        Map<Character, Digit> secondMap = new HashMap<>();
        Map<Character, Digit> thirdMap = new HashMap<>();
        firstMap.put('z', new Digit("zero", 0));
        firstMap.put('x', new Digit("six", 6));
        firstMap.put('w', new Digit("two", 2));
        firstMap.put('u', new Digit("four", 4));
        firstMap.put('g', new Digit("eight", 8));
        secondMap.put('h', new Digit("three", 3));
        secondMap.put('f', new Digit("five", 5));
        secondMap.put('s', new Digit("seven", 7));
        secondMap.put('o', new Digit("one", 1));
        thirdMap.put('e', new Digit("nine", 9));
        StringBuilder sb = new StringBuilder();
        sb.append(countDigits(counts, firstMap));
        sb.append(countDigits(counts, secondMap));
        sb.append(countDigits(counts, thirdMap));

        char[] digits = sb.toString().toCharArray();
        Arrays.sort(digits);

        return new String(digits);
    }

    String countDigits(int[] counts, Map<Character, Digit> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Digit> entry: map.entrySet()) {
            char key = entry.getKey();
            if (counts[key - 'a'] > 0) {
                Digit digit = entry.getValue();
                int count = counts[key - 'a'];
                for (int i = 0; i < count; i ++) {
                    sb.append(digit.digit);
                }
                for (char c: digit.charArray) {
                    counts[c - 'a'] -= count;
                }
            }
        }
        return sb.toString();
    }
}
