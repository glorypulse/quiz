class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int prev = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || prev > 0) {
            int digitA = i >= 0 ? a.charAt(i) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j) - '0' : 0;
            int digit = prev + digitA + digitB;

            sb.append(digit % 2);
            prev = digit / 2;
            i --;
            j --;
        }
        return sb.reverse().toString();
    }
}
