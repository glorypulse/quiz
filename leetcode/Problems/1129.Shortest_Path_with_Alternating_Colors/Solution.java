import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    class Node {
        ArrayList<Integer> children;

        Node() {
            children = new ArrayList<>();
        }

        void add(int child) {
            children.add(child);
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Node[] graph = new Node[2 * n];
        for (int i = 0; i < 2 * n; i ++) {
            graph[i] = new Node();
        }

        for (int[] red_edge: red_edges) {
            graph[red_edge[0]].add(red_edge[1] + n);
        }

        for (int[] blue_edge: blue_edges) {
            graph[blue_edge[0] + n].add(blue_edge[1]);
        }

        // Search
        int[] redResult = new int[2 * n];
        Arrays.fill(redResult, Integer.MAX_VALUE);
        redResult[0] = 0;
        int[] blueResult = new int[2 * n];
        Arrays.fill(blueResult, Integer.MAX_VALUE);
        blueResult[n] = 0;

        search(redResult, graph, 0);
        search(blueResult, graph, n);

        int[] result = new int[n];
        for (int i = 0; i < n; i ++) {
            result[i] = Math.min(redResult[i], Math.min(redResult[i + n], Math.min(blueResult[i], blueResult[i + n])));
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }

    void search(int[] result, Node[] graph, int start) {
        Set<Integer> remains = new HashSet<>();
        for (int i = 0; i < graph.length; i ++) {
            remains.add(i);
        }
        int node = start;
        Queue<Integer> nextQueue = new ArrayDeque<>();
        int count = 1;
        while (!remains.isEmpty()) {
            remains.remove(node);
            count = result[node] + 1;
            for (int child: graph[node].children) {
                if (!remains.contains(child)) continue;
                if (result[child] > count) result[child] = count;
                nextQueue.add(child);
            }
            if (nextQueue.isEmpty()) {
                break;
            } else {
                node = nextQueue.poll();
            }
        }
    }
}
