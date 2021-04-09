class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            count += countVowel(s.charAt(left));
            count -= countVowel(s.charAt(right));
            left ++;
            right --;
        }
        return count == 0;
    }


    int countVowel(char c) {
        switch (Character.toLowerCase(c)) {
        case 'a':
        case 'i':
        case 'u':
        case 'e':
        case 'o':
            return 1;
        }
        return 0;
    }
}
