class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        findPaths(graph, 0, graph.length - 1, new LinkedList<>(),  ans);
        return ans;
    }

    void findPaths(int[][] graph, int current, int target, LinkedList<Integer> parents, List<List<Integer>> found) {
        parents.add(current);
        if (current == target) {
            found.add(new ArrayList<>(parents));
        } else {
            for (int next: graph[current]) {
                findPaths(graph, next, target, parents, found);
            }
        }
        parents.removeLast();
    }
}
