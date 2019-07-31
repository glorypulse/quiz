import java.util.HashMap;

class Logger {
    HashMap<String, Integer> storeLog;

    /** Initialize your data structure here. */
    public Logger() {
        storeLog = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer before = storeLog.get(message);
        if (before != null && before > timestamp - 10) {
            return false;
        }
        storeLog.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
