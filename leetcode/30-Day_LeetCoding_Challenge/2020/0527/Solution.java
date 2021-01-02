class Solution {
    class Node {
        ArrayList<Integer> neighbors;
        Boolean color;
        int val;

        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
            this.color = null;
        }

        void addNeighbor(int neighbor) {
            this.neighbors.add(neighbor);
        }

        boolean isColored() {
            return this.color != null;
        }

        boolean eqColor(boolean c) {
            return this.color == c;
        }

        boolean setColor(Node[] nodes, boolean c) {
            if (isColored()) {
                if (color == c) return true;
                return false;
            }
            this.color = c;
            for (int neighbor: neighbors) {
                if (!nodes[neighbor].setColor(nodes, !color)) return false;
            }
            return true;
        }
    }
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i < N + 1; i ++) {
            nodes[i] = new Node(i);
        }

        for (int[] dislike: dislikes) {
            nodes[dislike[0]].addNeighbor(dislike[1]);
            nodes[dislike[1]].addNeighbor(dislike[0]);
        }

        for (int i = 1; i < N + 1; i ++) {
            if (!nodes[i].isColored()) {
                if (!nodes[i].setColor(nodes, true)) return false;
            }
        }
        return true;
    }
}
