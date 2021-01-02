class Solution {
    public int calculate(String s) {
        int length = s.length();
        if (length == 0) return 0;

        LinkedList<String> calcList = new LinkedList<>();
        LinkedList<Integer> numList = new LinkedList<>();
        LinkedList<Character> markList = new LinkedList<>();
        int index = 0;
        while (index < length) {
            index = skipSpace(s, index);
            if (index >= length) break;
            if (Character.isDigit(s.charAt(index))) {
                int num = 0;
                while (index < length && Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index ++) - '0');
                }
                numList.add(num);
            } else {
                char mark = s.charAt(index ++);
                switch (mark) {
                case '*':
                case '/':
                    int num = 0;
                    index = skipSpace(s, index);
                    while (index < length && Character.isDigit(s.charAt(index))) {
                        num = num * 10 + (s.charAt(index ++) - '0');
                    }
                    numList.add(calc(numList.removeLast(), mark, num));
                    break;
                default:
                    markList.add(mark);
                }
            }
        }

        int ans = 0;
        char mark = '+';
        boolean markMode = true;
        while (!numList.isEmpty()) {
            if (markMode) {
                int num = numList.remove();
                ans = calc(ans, mark, num);
                markMode = false;
            } else {
                mark = markList.remove();
                markMode = true;
            }
        }
        return ans;
    }

    int calc(int left, char mark, int right) {
        int ans = 0;
        switch (mark) {
        case '+':
            ans = left + right;
            break;
        case '-':
            ans = left - right;
            break;
        case '*':
            ans = left * right;
            break;
        case '/':
            ans = left / right;
            break;
        }
        return ans;
    }

    int skipSpace(String str, int i) {
        int length = str.length();
        while (i < length && str.charAt(i) == ' ') {
            i ++;
        }
        return i;
    }
}
