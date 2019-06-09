import java.util.Arrays;

class Quiz02 {

    static Node createBinaryTree(int[] array) {
        int length = array.length;
        if (array.length == 0) {
            return null;
        }

        int middle = array.length / 2;
        Node node = new Node(array[middle]);
        if (middle > 0) {
            node.left = createBinaryTree(Arrays.copyOfRange(array, 0, middle));
        } else {
            node.left = null;
        }

        if (middle < length - 1) {
            node.right = createBinaryTree(Arrays.copyOfRange(array, middle + 1, length));
        } else {
            node.right = null;
        }

        return node;
    }

    public static void main(String[] args) {
        int[] sortedArray = new int[]{ 3, 4, 7, 11, 15, 17, 23 };

        Node node = createBinaryTree(sortedArray);
        node.print();
    }
}
