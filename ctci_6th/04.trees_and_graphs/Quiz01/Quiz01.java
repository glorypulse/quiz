class Quiz01 {
    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.setNextNode(nodeB);
        nodeA.setNextNode(nodeC);
        nodeB.setNextNode(nodeE);
        nodeC.setNextNode(nodeA);
        nodeD.setNextNode(nodeB);
        // nodeEは到達できるnodeはなし

        Node[] nodes_array = new Node[]{ nodeA, nodeB, nodeC, nodeD, nodeE };
        Graph graph = new Graph(nodes_array);

        System.out.println(graph.hasRoutes(nodeA, nodeE));
        System.out.println(graph.hasRoutes(nodeA, nodeD));
    }

}
