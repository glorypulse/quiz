class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] num_f_words = new int[10];
        char min_c;
        int count;
        for (String word: words) {
            min_c = 'z' + 1;
            for (char c: word.toCharArray()) {
                if (c < min_c) min_c = c;
            }
            count = 0;
            for (char c: word.toCharArray()) {
                if (c == min_c) count ++;
            }
            num_f_words[count - 1] ++;
        }

        int prev = 0, tmp;
        for (int i = num_f_words.length - 1; i >= 0; i --) {
            tmp = num_f_words[i];
            num_f_words[i] = prev;
            prev += tmp;
        }

        int[] ret = new int[queries.length];
        String query;
        for (int i = 0; i < queries.length; i ++) {
            query = queries[i];
            min_c = 'z' + 1;
            for (char c: query.toCharArray()) {
                if (c < min_c) min_c = c;
            }
            count = 0;
            for (char c: query.toCharArray()) {
                if (c == min_c) count ++;
            }

            ret[i] = num_f_words[count - 1];
        }

        return ret;
    }
}
