import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int maxRepOpt1(String text) {
        char current_char = '\0', prev_char = '\0';
        int current = 0, prev = 0;

        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        HashMap<Character, Integer> swapMax = new HashMap<Character, Integer>();
        HashSet<Character> existed = new HashSet<Character>();

        for (char check_char: text.toCharArray()) {
            if (current == check_char) {

            }

            if (prev == check_char) {
                swapMax.put(check_char, swapMax.get(check_char) + 2);
            } else {
                if (!swapMax.containsKey(check_char)) {
                    swapMax.put(check_char, 2);
                }
            }

            if (count.containsKey(check_char)) {
                count.put(check_char, count.get(check_char) + 1);
            } else {
                count.put(check_char, 1);
            }

            existed.add(check_char);

            prev = current;
            prev_char = current_char;

            if (current == check_char) {
                current += 1;
            } else {
                current = 1;
            }




        }






    }
}
