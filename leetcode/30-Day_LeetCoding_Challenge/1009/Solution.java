/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> BSTList = new ArrayList<>();
        convertNodeToList(root, BSTList);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < BSTList.size(); i ++) {
            String str = BSTList.get(i);
            sb.append(str);
            if (i < BSTList.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    void convertNodeToList(TreeNode node, ArrayList<String> list) {
        if (node == null) {
            list.add("null");
        } else {
            list.add(String.valueOf(node.val));
            convertNodeToList(node.left, list);
            convertNodeToList(node.right, list);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        if (dataArray.length == 0 || dataArray[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(dataArray[0]));
        int index = 1;
        while (index < dataArray.length) {
            index = convertListToNode(dataArray, index, root);
        }
        return root;
    }

    int convertListToNode(String[] dataArray, int index, TreeNode node) {
        if (dataArray.length <= index) return index;
        if (!dataArray[index].equals("null")) {
            node.left = new TreeNode(Integer.parseInt(dataArray[index]));
            index = convertListToNode(dataArray, index + 1, node.left);
        } else {
            index ++;
        }
        if (dataArray.length <= index) return index;
        if (!dataArray[index].equals("null")) {
            node.right = new TreeNode(Integer.parseInt(dataArray[index]));
            index = convertListToNode(dataArray, index + 1, node.right);
        } else {
            index ++;
        }
        return index;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
