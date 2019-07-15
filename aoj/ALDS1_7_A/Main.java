import java.util.Scanner;
import java.io.PrintWriter;

class Main {
    enum NodeType {
        Root, InternalNode, Leaf
    };

    class Node {
        int parent = -1;
        int depth = 0;
        NodeType type = NodeType.Root;
        int[] children;

        Node(int[] children) {
            this.children = children;
        }

        String strType() {
            String result = "root";
            switch(type) {
                case Leaf:
                    result = "leaf";
                    break;
                case InternalNode:
                    result = "internal node";
                    break;
            }
            return result;
        }
    }

    Node[] setNodes(int[][] nodes) {
        int n = nodes.length;
        Node[] result = new Node[n];
        int i;
        for (i = 0; i < n; i ++) {
            result[i] = new Node(nodes[i]);
        }

        int[] children;
        for (i = 0; i < n; i ++) {
            children = result[i].children;
            for (int c: children) {
                result[c].parent = i;
            }
        }

        int parent = 0;
        for (i = 0; i < n; i ++) {
            if (result[i].parent == -1) {
                parent = i;
            } else {
                if (result[i].children.length == 0) {
                    result[i].type = NodeType.Leaf;
                } else {
                    result[i].type = NodeType.InternalNode;
                }
            }
        }

        setDepth(result, parent, 0);
        return result;
    }

    void setDepth(Node[] nodes, int index, int depth) {
        Node node = nodes[index];
        node.depth = depth;
        for (int c: node.children) {
            setDepth(nodes, c, depth + 1);
        }
        return;
    }

    void printNodes(Node[] nodes, PrintWriter out) {
        for (int i = 0; i < nodes.length; i ++) {
            out.print("node " + i + ": ");
            out.print("parent = " + nodes[i].parent + ", ");
            out.print("depth = " + nodes[i].depth + ", ");
            out.print(nodes[i].strType() + ", ");
            out.print("[");
            for (int j = 0; j < nodes[i].children.length; j ++) {
                out.print(nodes[i].children[j]);
                if (j < nodes[i].children.length - 1) out.print(", ");
            }
            out.println("]");
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(sc.next());
        int k = 0;
        int[][] nodes = new int[n][];
        int id;
        for (int i = 0; i < n; i ++) {
            id = Integer.parseInt(sc.next()); // node id
            k = Integer.parseInt(sc.next()); // k
            int[] children = new int[k];
            for (int j = 0; j < k; j ++) {
                children[j] = Integer.parseInt(sc.next());
            }
            nodes[id] = children;
        }

        Main m = new Main();
        Node[] result = m.setNodes(nodes);
        m.printNodes(result, out);
        out.flush();
    }
}
