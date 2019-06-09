class Node {
    int value;
    Node left = null;
    Node right = null;

    public Node(int value) {
        this.value = value;
    }

    public void print() {
        System.out.println("|" + value + "|");
        if (left == null && right == null) {
            System.out.println("value:" + value + " is a leaf.");
        } else if (left == null) {
            System.out.println("value:" + value + " left is null.");
            System.out.print("right: ");
            right.print();
        } else if (right == null) {
            System.out.print("left: ");
            left.print();
            System.out.println("value:" + value + " right is null.");
        } else {
            System.out.print("left: ");
            left.print();
            System.out.print("right: ");
            right.print();
        }
    }
}
