class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> parents = new HashSet<>();
        ArrayList<Integer>[] edges = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i ++) {
            parents.add(i);
            edges[i] = new ArrayList<>();
        }


        for (int[] prerequisite: prerequisites) {
            int parent = prerequisite[1];
            int child = prerequisite[0];
            edges[parent].add(child);
            parents.remove(child);
        }

        if (parents.isEmpty()) return new int[0];
        Boolean[] visited = new Boolean[numCourses];
        LinkedList<Integer> orderedCourses = new LinkedList<>();
        for (int parent: parents) {
            if (!setCourses(parent, edges, visited, orderedCourses)) return new int[0];
        }
        if (orderedCourses.size() != numCourses) return new int[0];

        int[] orderedCourseArray = new int[numCourses];
        Collections.reverse(orderedCourses);
        int i = 0;
        for (int course: orderedCourses) {
            orderedCourseArray[i] = course;
            i ++;
        }
        return orderedCourseArray;
    }


    boolean setCourses(int course, ArrayList<Integer>[] edges, Boolean[] visited, LinkedList<Integer> orderedCourses) {
        if (visited[course] != null) {
            if (visited[course]) return true;
            return false;
        }
        visited[course] = false;
        for (int edge: edges[course]) {
            if (!setCourses(edge, edges, visited, orderedCourses)) return false;
        }
        orderedCourses.add(course);
        visited[course] = true;
        return true;
    }
}
