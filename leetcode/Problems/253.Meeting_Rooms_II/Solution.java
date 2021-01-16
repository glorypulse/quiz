import java.util.TreeMap;
import java.util.LinkedList;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, LinkedList<Boolean>> usingTimeMap = new TreeMap<>();

        LinkedList<Boolean> start;
        LinkedList<Boolean> end;
        for (int[] interval: intervals) {
            // start
            start = usingTimeMap.get(interval[0]);
            if (start == null) {
                start = new LinkedList<Boolean>();
                usingTimeMap.put(interval[0], start);
            }
            start.add(true);

            end = usingTimeMap.get(interval[1]);
            if (end == null) {
                end = new LinkedList<Boolean>();
                usingTimeMap.put(interval[1], end);
            }
            end.addFirst(false);
        }

        int numberOfRoom = 0;
        int max = 0;
        for (LinkedList<Boolean> usingList: usingTimeMap.values()) {
            for (boolean using: usingList) {
                if (using) {
                    numberOfRoom ++;
                    if (max < numberOfRoom) max = numberOfRoom;
                } else {
                    numberOfRoom --;
                }
            }
        }

        return max;
    }
}
