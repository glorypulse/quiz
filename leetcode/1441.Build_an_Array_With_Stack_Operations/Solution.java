class Solution {
    public List<String> buildArray(int[] target, int n) {
        int index = 1;
        List<String> ansList = new LinkedList<>();
        for (int t: target) {
            while (index < t) {
                ansList.add("Push");
                ansList.add("Pop");
                index ++;
            }
            ansList.add("Push");
            index ++;
        }
        return ansList;
    }
}
