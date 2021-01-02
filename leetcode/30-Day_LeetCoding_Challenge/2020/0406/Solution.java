class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> retMap = new HashMap<String, List<String>>();

        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String orderedStr = new String(chars);
            List<String> strList = retMap.get(orderedStr);
            if (strList == null) {
                strList = new ArrayList<String>();
                retMap.put(orderedStr, strList);
            }
            strList.add(str);
        }

        return new ArrayList(retMap.values());
    }
}
