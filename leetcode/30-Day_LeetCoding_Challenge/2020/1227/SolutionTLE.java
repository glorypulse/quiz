class Solution {
    class Node {
        int index;
        List<Node> nexts;

        Node(int index) {
            this.index = index;
            nexts = new ArrayList<>();
        }
        Node(int index, Node next) {
            this.index = index;
            nexts = new ArrayList<>() {
                    {
                        add(next);
                    }
                };
        }
    }

    public int minJumps(int[] arr) {
        int length = arr.length;
        if (length <= 1) return 0;

        Map<Integer, List<Node>> valueMap = new HashMap<>();
        Node[] nodes = new Node[length];
        nodes[0] = new Node(0);
        valueMap.put(arr[0],
                     new ArrayList<>() {
                         {
                             add(nodes[0]);
                         }
                     });

        for (int i = 1; i < length; i ++) {
            int val = arr[i];
            nodes[i] = new Node(i, nodes[i - 1]);
            nodes[i - 1].nexts.add(nodes[i]);
            List<Node> sameValues = valueMap.get(val);
            if (sameValues == null) {
                sameValues = new ArrayList<>();
                valueMap.put(val, sameValues);
            }
            for (Node next: sameValues) {
                if (next.index == i - 1) continue;
                nodes[i].nexts.add(next);
                next.nexts.add(nodes[i]);
            }
            sameValues.add(nodes[i]);
        }

        int[] steps = new int[length];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(nodes[0]);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int step = steps[node.index];
            for (Node next: node.nexts) {
                if (steps[next.index] <= step + 1) continue;
                if (next.index == length - 1) return step + 1;
                steps[next.index] = step + 1;
                queue.offer(next);
            }
        }

        return length - 1;
    }
}
