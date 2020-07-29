class Solution {
    class Node {
        char task;
        int count;

        Node(char task) {
            this.task = task;
            count = 0;
        }

        void inc() {
            count ++;
        }

        void dec() {
            count --;
        }

        String str() {
            return "task:" + task + ",count:" + count;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Node> taskMap = new HashMap<>();

        for (char task: tasks) {
            Node node = taskMap.get(task);
            if (node == null) {
                node = new Node(task);
                taskMap.put(task, node);
            }
            node.inc();
        }
        PriorityQueue<Node> taskPQ = new PriorityQueue<>((x, y) -> {
                if (x.count != y.count) return y.count - x.count;
                return x.task - y.task;
        });
        taskPQ.addAll(taskMap.values());

        Map<Integer, PriorityQueue<Node>> unitPQ = new HashMap<>();
        unitPQ.put(0, taskPQ);

        int unit = 0;
        while (!unitPQ.isEmpty()) {
            taskPQ = unitPQ.remove(unit);
            unit ++;
            if (taskPQ == null) {
                continue;
            }

            Node node = taskPQ.poll();
            node.dec();
            if (node.count > 0) {
                PriorityQueue<Node> nextPQ = unitPQ.get(unit + n);
                if (nextPQ == null) {
                    nextPQ = new PriorityQueue<>((x, y) -> {
                            if (x.count != y.count) return y.count - x.count;
                            return x.task - y.task;
                    });
                    unitPQ.put(unit + n, nextPQ);
                }
                nextPQ.offer(node);
            }
            if (taskPQ.isEmpty()) continue;
            PriorityQueue<Node> incPQ = unitPQ.get(unit);
            if (incPQ == null) {
                unitPQ.put(unit, taskPQ);
            } else {
                incPQ.addAll(taskPQ);
            }
        }
        return unit;
    }
}
