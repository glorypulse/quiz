class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int length = 0;
        for (int brick: wall.get(0)) {
            length += brick;
        }
        Map<Integer, Integer> edges = new HashMap<>();
        for (List<Integer> row: wall) {
            int col = 0;
            for (int brick: row) {
                col += brick;
                if (length <= col) break;
                edges.put(col, edges.getOrDefault(col, 0) + 1);
            }
        }
        if (edges.isEmpty()) return wall.size();

        return wall.size() - Collections.max(edges.values());
    }
}
