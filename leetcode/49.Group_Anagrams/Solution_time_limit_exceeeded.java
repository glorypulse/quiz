import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    // o(n^2 m)
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<HashMap<Character, Integer>> checkList = new ArrayList<HashMap<Character, Integer>>();
        List<List<String>> retList = new ArrayList<List<String>>();

        for (String str: strs) { // * O(n)
            int index = existsAnagram(str, checkList); // O(nm)
            if (index < 0) {
                index = checkList.size(); // O(1)
                checkList.add(createCheck(str)); // O(m)
                retList.add(new ArrayList<String>()); // O(1)
            }
            List<String> ret = retList.get(index); // O(1)
            ret.add(str);
        }
        return retList;
    }

    private int existsAnagram(String str, ArrayList<HashMap<Character, Integer>> checkList) {
        for (int i = 0; i < checkList.size(); i++) { // * O(n)
            HashMap<Character, Integer> check = (HashMap<Character, Integer>)checkList.get(i).clone();
            if (checkAnagram(str, check)) { // O(m)
                return i;
            }
        }
        return -1;
    }

    private boolean checkAnagram(String str, HashMap<Character, Integer> check) {
        for (char c : str.toCharArray()) {
            Integer value = check.get(c);
            if (value == null) {
                return false;
            } else if (value == 1) {
                check.remove(c);
            } else {
                check.put(c, value - 1);
            }
        }
        if (check.isEmpty()) return true;

        return false;
    }

    private HashMap<Character, Integer> createCheck(String str) {
        HashMap<Character, Integer> checkMap = new HashMap<Character, Integer>();
        for (char c : str.toCharArray()) {
            Integer value = checkMap.get(c);
            if (value == null) {
                checkMap.put(c, 1);
            } else {
                checkMap.put(c, value + 1);
            }
        }
        return checkMap;
    }
}
