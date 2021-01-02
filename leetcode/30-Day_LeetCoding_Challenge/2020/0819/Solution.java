class Solution {
    public String toGoatLatin(String S) {
        String[] strs = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length - 1; i ++) {
            makeGoatLatin(sb, strs[i], i + 1);
            sb.append(' ');
        }
        makeGoatLatin(sb, strs[strs.length - 1], strs.length);

        return sb.toString();
    }

    void makeGoatLatin(StringBuilder sb, String str, int index) {
        switch (str.charAt(0)) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
            sb.append(str);
            break;
        default:
            sb.append(str.substring(1));
            sb.append(str.charAt(0));
        }

        sb.append("ma");

        for (int i = 0; i < index; i ++) {
            sb.append('a');
        }
    }
}
