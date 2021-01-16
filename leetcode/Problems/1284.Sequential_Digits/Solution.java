import java.util.ArrayList;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> seqList = new ArrayList<>();

        int numDigits = String.valueOf(low).length();
        int startNum = low / (int)Math.pow(10, numDigits - 1);
        int tmpDigit;

        StringBuilder sb = new StringBuilder();

        if (startNum > 10 - numDigits) {
            startNum = 1;
            numDigits ++;
        }

        while (numDigits <= 9) {
            sb.setLength(0);
            for (int i = 0; i < numDigits; i ++) {
                sb.append(startNum + i);
            }
            tmpDigit = Integer.parseInt(sb.toString());
            if (tmpDigit > high) break;
            if (tmpDigit >= low) {
                seqList.add(tmpDigit);
            }

            if (startNum + 1 <= 10 - numDigits) {
                startNum ++;
            } else {
                startNum = 1;
                numDigits ++;
            }
        }
        return seqList;
    }
}
