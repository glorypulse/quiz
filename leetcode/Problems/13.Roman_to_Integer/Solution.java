import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

class Solution {
    static final Map<Character, Integer> ROMAN_MAP;
    static final Map<Character, char[]> SUBTRACT_CHARS;
    static final char INIT_CHAR = ' ';

    static {
        HashMap<Character, Integer> roman_map = new HashMap<Character, Integer>() {
                {
                    put('I', 1);
                    put('V', 5);
                    put('X', 10);
                    put('L', 50);
                    put('C', 100);
                    put('D', 500);
                    put('M', 1000);
                }
            };
        ROMAN_MAP = Collections.<Character, Integer>unmodifiableMap(roman_map);

        HashMap<Character, char[]> sub_chars = new HashMap<Character, char[]>() {
                char[] iNexts = { 'V', 'X' };
                char[] xNexts = { 'L', 'C' };
                char[] cNexts = { 'D', 'M' };
                char[] initNexts = { INIT_CHAR, INIT_CHAR };

                {
                    put('I', iNexts);
                    put('X', xNexts);
                    put('C', cNexts);
                    put(INIT_CHAR, initNexts);
                }
            };
        SUBTRACT_CHARS = Collections.<Character, char[]>unmodifiableMap(sub_chars);

    }

    public int romanToInt(String s) {
        int sum = 0;
        char sub = INIT_CHAR;
        char[] subNexts = { INIT_CHAR, INIT_CHAR };

        for(char c : s.toCharArray()) {
            // 前の文字がI,X,Cだった場合の処理
            if (c == subNexts[0] || c == subNexts[1]) {
                sum -= ROMAN_MAP.get(sub);
                sub = INIT_CHAR;
                subNexts = SUBTRACT_CHARS.get(INIT_CHAR);
            } else if (sub != INIT_CHAR) {
                sum += ROMAN_MAP.get(sub);
                sub = INIT_CHAR;
                subNexts = SUBTRACT_CHARS.get(INIT_CHAR);
            }

            // この文字自体の処理
            switch(c) {
            case 'I':
            case 'X':
            case 'C':
                sub = c;
                subNexts = SUBTRACT_CHARS.get(sub);
                break;
            default :
                sum += ROMAN_MAP.get(c);
            }
        }

        if (sub != INIT_CHAR) {
            sum += ROMAN_MAP.get(sub);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int num = Integer.parseInt(sc.nextLine());

        Solution solution = new Solution();
        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            out.println(solution.romanToInt(str));
        }
        out.flush();
    }
}
