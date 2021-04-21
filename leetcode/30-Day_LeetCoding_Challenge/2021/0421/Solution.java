class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Collections.reverse(triangle);
        int[] totals = new int[triangle.get(0).size() + 1];
        for (List<Integer> row: triangle) {
            int i = 0;
            for (int num: row) {
                totals[i] = Math.min(totals[i], totals[i + 1]) + num;
                i ++;
            }
        }
        return totals[0];
    }
}
