import java.util.HashSet;
import java.util.Set;

class Solution {
    public String getHint(String secret, String guess) {
        StringBuilder secretSb = new StringBuilder();
        StringBuilder guessSb = new StringBuilder();

        char s, g;
        int length = secret.length();
        int bullsCount = 0;
        int i, j;
        for (i = 0; i < length; i ++) {
            s = secret.charAt(i);
            g = guess.charAt(i);
            if (s == g) {
                bullsCount ++;
            } else {
                secretSb.append(s);
                guessSb.append(g);
            }
        }

        char[] secretNotBulls = secretSb.toString().toCharArray();
        char[] guessNotBulls = guessSb.toString().toCharArray();
        Arrays.sort(secretNotBulls);
        Arrays.sort(guessNotBulls);

        i = 0;
        j = 0;
        int cowsCount = 0;
        while (i < secretNotBulls.length && j < guessNotBulls.length) {
            s = secretNotBulls[i];
            g = guessNotBulls[j];
            if (s == g) {
                cowsCount ++;
                i ++;
                j ++;
            } else if (s < g) {
                i ++;
            } else {
                j ++;
            }
        }

        return bullsCount + "A" + cowsCount + "B";
    }
}
