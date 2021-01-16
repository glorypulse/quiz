import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    enum Mode {
        Red, Blue
    };

    class Node {
        ArrayList<Integer> red_children;
        ArrayList<Integer> blue_children;

        Node() {
            red_children = new ArrayList<>();
            blue_children = new ArrayList<>();
        }

        void addToRed(int child) {
            red_children.add(child);
        }

        void addToBlue(int child) {
            blue_children.add(child);
        }

        ArrayList<Integer> children(Mode mode) {
            ArrayList<Integer> children = red_children;
            if (mode == Mode.Blue) children = blue_children;
            return children;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Node[] graph = new Node[n];
        for (int i = 0; i < n; i ++) {
            graph[i] = new Node();
        }

        Set<String> edgeSet = new HashSet<>();
        String str;
        for (int[] red_edge: red_edges) {
            graph[red_edge[0]].addToRed(red_edge[1]);
            str = Mode.Red.toString() + red_edge[0] + "," + red_edge[1];
            edgeSet.add(str);
        }

        for (int[] blue_edge: blue_edges) {
            graph[blue_edge[0]].addToBlue(blue_edge[1]);
            str = Mode.Blue.toString() + blue_edge[0] + "," + blue_edge[1];
            edgeSet.add(str);
        }

        // Search
        int[] redResult = new int[n];
        Arrays.fill(redResult, Integer.MAX_VALUE);
        redResult[0] = 0;
        int[] blueResult = new int[n];
        Arrays.fill(blueResult, Integer.MAX_VALUE);
        blueResult[0] = 0;

        search(redResult, n, graph, Mode.Red, edgeSet);
        //System.out.print("RED::");
        //for (int r: redResult) System.out.print(r + ",");
        //System.out.println();
        search(blueResult, n, graph, Mode.Blue, edgeSet);
        //System.out.println("BLUE::" + blueResult.toString());
        //for (int r: blueResult) System.out.print(r + ",");
        //System.out.println();

        int[] result = new int[n];
        for (int i = 0; i < n; i ++) {
            result[i] = Math.min(redResult[i], blueResult[i]);
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result;
    }

    Mode setMode(Mode mode, int count) {
        Mode ret = mode;
        if (count % 2 == 0) {
            switch(mode) {
            case Red:
                ret = Mode.Blue;
                break;
            case Blue:
                ret = Mode.Red;
                break;
            }
        }
        return ret;
    }

    void search(int[] result, int n, Node[] graph, Mode initMode, Set<String> edgeSet) {
        Set<String> remains = new HashSet<>();
        remains.addAll(edgeSet);
        int node = 0;
        Queue<Integer> nextQueue = new ArrayDeque<>();
        Mode mode = initMode;
        int count = 1;
        nextQueue.add(-2);
        String str;
        boolean added;
        while (!remains.isEmpty()) {
            mode = setMode(initMode, count);
            //System.out.println("node: " + node + " , mode: " + mode.toString() + ", count: " + count);
            //System.out.println(remains.toString());
            added = false;
            for (int child: graph[node].children(mode)) {
                str = mode.toString() + node + "," + child;
                if (!remains.contains(str)) continue;
                added = true;
                if (result[child] > count) result[child] = count;
                //System.out.println(str + "::result:" + result[child]);
                nextQueue.add(child);
                remains.remove(str);
            }
            if (added) nextQueue.add(-(count + 1));
            //System.out.println("next->" + nextQueue.toString());
            if (nextQueue.isEmpty()) {
                break;
            } else {
                node = nextQueue.poll();
                if (node < 0) {
                    count = -node;
                    if (nextQueue.isEmpty()) break;
                    node = nextQueue.poll();
                }
            }

        }
    }
}
