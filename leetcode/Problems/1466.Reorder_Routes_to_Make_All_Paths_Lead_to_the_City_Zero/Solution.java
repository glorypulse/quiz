class Solution {
    class Node {
        int val;
        ArrayList<Integer> connectedNodes;
        ArrayList<Integer> nexts;

        Node(int val) {
            this.val = val;
            connectedNodes = new ArrayList<>();
            nexts = new ArrayList<>();
        }

        void addConnection(int c) {
            connectedNodes.add(c);
        }

        void addNext(int p) {
            nexts.add(p);
        }
        int reorder(int realParent, Node[] nodes) {
            int nextLen = nexts.size();
            for (int next: nexts) {
                if (next == realParent) {
                    nextLen --;
                    break;
                }
            }
            int count = connectedNodes.size() - nextLen - 1;
            for (int node: connectedNodes) {
                if (node == -1 || node == realParent) continue;
                count += nodes[node].reorder(val, nodes);
            }
            return count;
        }
    }
    public int minReorder(int n, int[][] connections) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i ++) {
            nodes[i] = new Node(i);
        }
        for (int connection[]: connections) {
            int from = connection[0];
            int to = connection[1];
            nodes[from].addConnection(to);
            nodes[to].addConnection(from);
            nodes[to].addNext(from);
        }

        int count = nodes[0].connectedNodes.size() - nodes[0].nexts.size();
        for (int node: nodes[0].connectedNodes) {
            if (node == -1) continue;
            count += nodes[node].reorder(0, nodes);
        }
        return count;
    }
}
