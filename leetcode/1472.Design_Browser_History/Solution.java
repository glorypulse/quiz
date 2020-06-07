class BrowserHistory {
    class Node {
        Node parent;
        Node child;
        String homepage;

        Node(String homepage) {
            this.homepage = homepage;
        }
    }
    Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node next = new Node(url);
        current.child = next;
        next.parent = current;
        current = next;
    }

    public String back(int steps) {
        for (int i = 0; i < steps; i ++) {
            if (current.parent == null) break;
            current = current.parent;
        }
        return current.homepage;
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i ++) {
            if (current.child == null) break;
            current = current.child;
        }
        return current.homepage;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
