class Solution {
    class Node {
        int num;
        ArrayList<Integer> nextCourses;
        Node(int num) {
            this.num = num;
            this.nextCourses = new ArrayList<>();
        }

        void addNextCourse(int num) {
            nextCourses.add(num);
        }

        boolean visit(boolean[] visited, Node[] nodes, Set<Integer> courseSet) {
            if (visited[num]) return false;
            courseSet.remove(num);
            visited[num] = true;
            for (int next: nextCourses) {
                if (!nodes[next].visit(visited, nodes, courseSet)) return false;
            }
            visited[num] = false;
            return true;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> startSet = new HashSet<>();
        Set<Integer> courseSet = new HashSet<>();
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            startSet.add(i);
            courseSet.add(i);
            nodes[i] = new Node(i);
        }

        for (int[] prerequisite: prerequisites) {
            nodes[prerequisite[0]].addNextCourse(prerequisite[1]);
            startSet.remove(prerequisite[1]);
        }

        if (startSet.isEmpty()) return false;

        boolean[] visited = new boolean[numCourses];
        for (int course: startSet) {
            if (!nodes[course].visit(visited, nodes, courseSet)) return false;
        }
        if (!courseSet.isEmpty()) return false;
        return true;
    }
}
