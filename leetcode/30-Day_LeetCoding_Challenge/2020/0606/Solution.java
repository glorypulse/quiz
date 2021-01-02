class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,
                    (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        LinkedList<Integer> indexes = new LinkedList<>();
        for (int i = 0; i < people.length; i ++) {
            indexes.add(i);
        }
        int[][] ans = new int[people.length][];
        for (int[] p: people) {
            Integer index = indexes.remove(p[1]);
            ans[index] = p;
        }

        return ans;
    }
}
