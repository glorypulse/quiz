import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    // O(n mlogm)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> retMap = new HashMap<String, List<String>>();

        for (String str: strs) { // * O(n)
            char[] chars = str.toCharArray(); // O(m)
            Arrays.sort(chars); // O(mlogm)
            String orderedStr = new String(chars); // O(m)
            List<String> strList = retMap.get(orderedStr); // O(1)
            if (strList == null) {
                strList = new ArrayList<String>();
                retMap.put(orderedStr, strList); // O(1)
            }
            strList.add(str); // O(1)
        }

        return new ArrayList(retMap.values()); // O(n)
    }
}
