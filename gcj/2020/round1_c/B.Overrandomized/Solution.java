import java.util.*;
import java.io.*;
public class Solution {
    static String getD(int u, String[][] m_array) {
        HashMap<Character, Set<Integer>> charMap = new HashMap<>();
        HashMap<Integer, Set<Character>> digitMap = new HashMap<>();
        Set<Character> foundChar = new HashSet<>();

        for (int i = 0; i < 10; i ++) {
            digitMap.put(i, new HashSet<>());
        }

        char[] digitChar = new char[10];
        Arrays.fill(digitChar, '0');

        for (String[] request: m_array) {
            String q_str = request[0];
            int q = Integer.parseInt(q_str);
            String r = request[1];

            // 1番上の桁は0にはならない
            char firstChar = r.charAt(0);
            Set<Integer> firstCharSet = charMap.get(firstChar);
            if (firstCharSet == null) {
                firstCharSet = new HashSet<>();
                for (int i = 1; i < 10; i ++) {
                    firstCharSet.add(i);
                    digitMap.get(i).add(firstChar);
                }
                charMap.put(firstChar, firstCharSet);
            } else {
                firstCharSet.remove(0);
            }

            for (int i = 1; i < r.length(); i ++) {
                char c = r.charAt(i);
                Set<Integer> charSet = charMap.get(c);
                if (charSet == null) {
                    charSet = new HashSet<>();
                    for (int j = 0; j < 10; j ++) {
                        charSet.add(j);
                        digitMap.get(j).add(c);
                    }
                    charMap.put(c, charSet);
                }
            }

            // 1番上の桁の上限
            if (q > 0) {
                if (q_str.length() == r.length()) {
                    int firstDigit = q_str.charAt(0) - '0';
                    for (int i = firstDigit + 1; i < 10; i ++) {
                        firstCharSet.remove(i);
                        digitMap.get(i).remove(firstChar);
                    }
                }
            }


            // check
            boolean change = true;
            while (change) {
                change = false;
                for (Map.Entry<Character, Set<Integer>> entry: charMap.entrySet()) {
                    char c = entry.getKey();
                    if (foundChar.contains(c)) continue;

                    Set<Integer> charSet = entry.getValue();
                    if (charSet.size() == 1) {
                        change = true;
                        int digit = -1;
                        for (int d: charSet) {
                            digit = d;
                        }
                        digitChar[digit] = c;
                        for (Set<Character> digitSet: digitMap.values()) {
                            digitSet.remove(c);
                        }
                        for (Set<Integer> cSet: charMap.values()) {
                            cSet.remove(digit);
                        }
                    }
                }

                if (charMap.size() == 10) {
                    for (int i = 0; i < 10; i ++) {
                        if (digitChar[i] > '0') continue;

                        Set<Character> digitSet = digitMap.get(i);
                        if (digitSet.size() == 1) {
                            change = true;
                            char digitC = '0';
                            for (char c: digitSet) {
                                digitC = c;
                            }
                            digitChar[i] = digitC;
                            for (Set<Character> dSet: digitMap.values()) {
                                dSet.remove(digitC);
                            }
                            for (Set<Integer> charSet: charMap.values()) {
                                charSet.remove(i);
                            }
                        }
                    }
                }
            }
        }

        //System.out.println("===========================");
        //for (Map.Entry<Character, Set<Integer>> entry: charMap.entrySet()) {
        //  System.out.println(entry.getKey());
        //            System.out.println(entry.getValue().toString());
        //        }

        StringBuilder sb = new StringBuilder();
        sb.append(digitChar);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test_case = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= test_case; t++) {
            int u = in.nextInt();
            String[][] m_array = new String[10000][2];
            for (int i = 0; i < m_array.length; i ++ ) {
                m_array[i][0] = in.next();
                m_array[i][1] = in.next();
            }
            System.out.println("Case #" + t + ": " + getD(u, m_array));
        }
    }
}
