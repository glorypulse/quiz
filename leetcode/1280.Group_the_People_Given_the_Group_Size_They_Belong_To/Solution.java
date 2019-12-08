import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> idsMap = new HashMap<>();
        List<Integer> ids;
        for (int i = 0; i < groupSizes.length; i ++) {
            int groupSize = groupSizes[i];
            ids = idsMap.get(groupSize);
            if (ids == null) {
                ids = new ArrayList<>();
                idsMap.put(groupSize, ids);
            }
            ids.add(i);
        }

        List<List<Integer>> groupList = new ArrayList<>();
        List<Integer> group;
        for (int groupSize: idsMap.keySet()) {
            ids = idsMap.get(groupSize);
            group = new ArrayList<>();
            for (int id: ids) {
                if (group.size() == groupSize) {
                    groupList.add(group);
                    group = new ArrayList<>();
                }
                group.add(id);
            }
            groupList.add(group);
        }

        return groupList;
    }
}
