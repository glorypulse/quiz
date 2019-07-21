import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Solution {
    class Node {
        ArrayList<Integer> neighbors;

        Node() {
            neighbors = new ArrayList<>();
        }

        void add(int value) {
            neighbors.add(value);
        }

        ArrayList<Integer> list() {
            return neighbors;
        }
    }

    public int countComponents(int n, int[][] edges) {
        Node[] graph = new Node[n]; // ArrayListの配列をつくりたかった
        Set<Integer> graphSet = new HashSet<Integer>();

        for (int i = 0; i < n; i ++) {
            graph[i] = new Node();
            graphSet.add(i);
        }

        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int value, count = 0;
        while (!graphSet.isEmpty()) {
            count ++;
            value = graphSet.iterator().next();
            findConnected(value, graph, graphSet);
        }
        return count;
    }

    void findConnected(int value, Node[] graph, Set<Integer> graphSet) {
        graphSet.remove(value);
        for (int nextNode: graph[value].list()) {
            if (graphSet.contains(nextNode)) {
                findConnected(nextNode, graph, graphSet);
            }
        }
    }
}
