class Solution {
    public List<String> printVertically(String s) {
        String[] strs = s.split(" ");
        ArrayList<StringBuilder> printSb = new ArrayList<>();
        int maxLength = 0;
        for (String str: strs) {
            if (maxLength < str.length()) {
                maxLength = str.length();
            }
        }
        for (int i = 0; i < maxLength; i ++) {
            printSb.add(new StringBuilder());
        }
        for (String str: strs) {
            int length = str.length();
            for (int i = 0; i < maxLength; i ++) {
                if (i >= length) {
                    printSb.get(i).append(' ');
                } else {
                    printSb.get(i).append(str.charAt(i));
                }
            }
        }

        List<String> printStrs = new ArrayList<>();
        for (StringBuilder sb: printSb) {
            String str = sb.toString();
            if (str.charAt(str.length() - 1) == '\u0020') {
                int length = str.length() - 1;
                int i = length - 1;
                while (i > 0) {
                    if (str.charAt(i) > '\u0020') break;
                    i --;
                }
                str = str.substring(0, i + 1);
            }
            printStrs.add(str);
        }

        return printStrs;
    }
}
