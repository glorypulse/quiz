class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        TreeMap<Integer, LinkedList<int[]>> weightEdges = new TreeMap<>();
        for (int i = 0; i < edges.length; i ++) {
            int weight = edges[i][2];
            LinkedList<int[]> wEdges = weightEdges.get(weight);
            if (wEdges == null) {
                wEdges = new LinkedList<>();
                weightEdges.put(weight, wEdges);
            }
            wEdges.add(new int[] { edges[i][0], edges[i][1], i });
        }

        Set<Integer> visited = new HashSet<>();
        Boolean[] criticaled = new Boolean[edges.length];

        for (LinkedList<int[]> wEdges: weightEdges.values()) {
            HashMap<Integer, LinkedList<Integer>> verticesEdges = new HashMap<>();
            for (int[] wEdge: wEdges) {
                LinkedList<Integer> vEdges;
                if (!visited.contains(wEdge[0])) {
                    vEdges = verticesEdges.get(wEdge[0]);
                    if (vEdges == null) {
                        vEdges = new LinkedList<>();
                        verticesEdges.put(wEdge[0], vEdges);
                    }
                    vEdges.add(wEdge[2]);
                }

                if (!visited.contains(wEdge[1])) {
                    vEdges = verticesEdges.get(wEdge[1]);
                    if (vEdges == null) {
                        vEdges = new LinkedList<>();
                        verticesEdges.put(wEdge[1], vEdges);
                    }
                    vEdges.add(wEdge[2]);
                }
            }

            for (Map.Entry<Integer, LinkedList<Integer>> vEdgesEntry: verticesEdges.entrySet()) {
                int v = vEdgesEntry.getKey();
                visited.add(v);

                LinkedList<Integer> vEdges = vEdgesEntry.getValue();
                if (vEdges.size() == 1) {
                    criticaled[vEdges.get(0)] = true;
                } else {
                    for (int vEdge: vEdges) {
                        if (criticaled[vEdge] == null) {
                            criticaled[vEdge] = false;
                        }
                    }
                }
            }

            if (visited.size() == n) break;
        }
        System.out.println(Arrays.toString(criticaled));

        List<Integer> criticalList = new LinkedList<>();
        List<Integer> pseudoList = new LinkedList<>();
        for (int i = 0; i < edges.length; i ++) {
            if (criticaled[i] == null) continue;
            if (criticaled[i]) {
                criticalList.add(i);
            } else {
                pseudoList.add(i);
            }
        }
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(criticalList);
        ans.add(pseudoList);
        return ans;
    }
}
