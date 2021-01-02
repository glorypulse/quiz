class Solution {
    public String stringShift(String s, int[][] shift) {
        int allOperation = 0;

        for (int[] sh: shift) {
            allOperation += sh[0] == 0 ? -sh[1] : sh[1];
        }

        int length = s.length();
        char[] shiftedS = new char[length];
        int index;
        for (int i = 0; i < length; i ++) {
            index = i + allOperation;
            while (index >= length || index < 0) {
                if (index >= length) {
                    index -= length;
                } else if (index < 0) {
                    index += length;
                }
            }
            shiftedS[index] = s.charAt(i);
        }

        return String.valueOf(shiftedS);
    }
}
