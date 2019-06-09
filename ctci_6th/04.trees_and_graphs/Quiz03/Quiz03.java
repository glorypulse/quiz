import java.util.ArrayList;
import java.util.LinkedList;

class Quiz03 {
    public static ArrayList<LinkedList<Node>> getSameDepthList(Node node) {
        ArrayList<LinkedList<Node>> retList = new ArrayList<LinkedList<Node>>();
        return setSameDepthList(node, retList, 0);
    }

    public static void main(String[] args) {
        // Quiz02で作ったNode classを使う
        int[] sortedArray = new int[]{ 3, 4, 7, 11, 15, 17, 23 };
        Node node = Quiz02.createBinaryTree(sortedArray);

        ArrayList<LinkedList<Node>> arrayList = getSameDepthList(node);
        for (int i = 0; i < arrayList.size(); i ++) {
            System.out.println("Depth:" + i);
            LinkedList<Node> list = arrayList.get(i);
            list.forEach(n -> System.out.println(n.value));
        }
    }

    private static ArrayList<LinkedList<Node>> setSameDepthList(Node node,
                                                                ArrayList<LinkedList<Node>> retList,
                                                                int depth) {
        if (node == null) return retList;

        if (retList.size() == depth) {
            retList.add(new LinkedList<Node>());
        }

        LinkedList<Node> list = retList.get(depth);
        list.add(node);

        setSameDepthList(node.left, retList, depth + 1);
        setSameDepthList(node.right, retList, depth + 1);

        return retList;
    }

}
