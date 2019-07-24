import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> digitLogs = new ArrayList<>();
        PriorityQueue<String> wordLogs = new PriorityQueue<>();
        HashMap<String, String> logMap = new HashMap<>();

        String[] splitLog;
        int i;
        boolean isDigitLog;
        for (String log: logs) {
            splitLog = log.split(" ");
            isDigitLog = true;
            for (i = 1; i < splitLog.length; i ++) {
                if (isDigitLog && !isDigit(splitLog[i])) {
                    isDigitLog = false;
                    break;
                }
            }
            if (isDigitLog) {
                digitLogs.add(log);
            } else {
                StringBuilder sb = new StringBuilder();
                for (i = 1; i < splitLog.length; i ++) {
                    sb.append(splitLog[i]);
                    sb.append(' ');
                }
                sb.append(splitLog[0]);
                wordLogs.add(sb.toString());
                logMap.put(sb.toString(), log);
            }
        }
        String[] result = new String[logs.length];
        int wordLogSize = wordLogs.size();
        for (i = 0; i < wordLogSize; i ++) {
            result[i] = logMap.get(wordLogs.poll());
        }

        while (i < logs.length) {
            result[i] = digitLogs.get(i - wordLogSize);
            i ++;
        }
        return result;
    }

    boolean isDigit(String str) {
        boolean isDigit = true;
        for (int i = 0; i < str.length(); i ++) {
            isDigit = Character.isDigit(str.charAt(i));
            if (!isDigit) break;
        }
        return isDigit;
    }

}
