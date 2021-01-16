/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    char[] bufStore;
    int index, readNum;

    Solution() {
        bufStore = new char[4];
        index = 0;
        readNum = 0;
    }

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        if (readNum == 0) {
            readNum = read4(bufStore);
            index = 0;
            if (readNum == 0) return 0;
        }
        while (i < n && readNum > 0) {
            buf[i] = bufStore[index];
            index ++;
            readNum --;
            i ++;
            if (index == 4) {
                readNum = read4(bufStore);
                index = 0;
            }
        }
        return i;
    }
}
