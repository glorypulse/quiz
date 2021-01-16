class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> nameCount = new HashMap<>();

        for (int i = 0; i < names.length; i ++) {
            String name = names[i];
            Integer count = nameCount.get(name);
            if (count == null) {
                nameCount.put(name, 1);
            } else {
                int testCount = count;
                String test = name + "(" + testCount + ")";
                Integer nextCount = nameCount.get(test);
                while (nextCount != null) {
                    testCount ++;
                    test = name + "(" + testCount + ")";
                    nextCount = nameCount.get(test);
                }
                names[i] = test;
                nameCount.put(name, testCount + 1);
                nameCount.put(test, 1);
            }
        }

        return names;
    }
}
