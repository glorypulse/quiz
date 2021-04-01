class Solution {
    class Course {
        int num;
        Set<Integer> prerequisites;
        List<Integer> nexts;

        Course(int num) {
            this.num = num;
            prerequisites = new HashSet<>();
            nexts = new ArrayList<>();
        }
    }
    public int minimumSemesters(int n, int[][] relations) {
        Course[] courses = new Course[n + 1];
        for (int i = 0; i < relations.length; i ++) {
            int[] relation = relations[i];
            if (courses[relation[0]] == null) {
                courses[relation[0]] = new Course(relation[0]);
            }
            courses[relation[0]].nexts.add(relation[1]);
            if (courses[relation[1]] == null) {
                courses[relation[1]] = new Course(relation[1]);
            }
            courses[relation[1]].prerequisites.add(relation[0]);
        }
        Queue<Integer> candidates = new LinkedList<>();
        Set<Integer> remains = new HashSet<>();
        for (int i = 1; i <= n; i ++) {
            Course course = courses[i];
            if (course == null) continue;
            remains.add(course.num);
            if (course.prerequisites.isEmpty()) {
                candidates.offer(course.num);
            }
        }

        int semester = 1;
        while (!candidates.isEmpty()) {
            int size = candidates.size();
            for (int i = 0; i < size; i ++) {
                int num = candidates.poll();
                remains.remove(num);
                for (int next: courses[num].nexts) {
                    if (!remains.contains(next)) continue;
                    courses[next].prerequisites.remove(num);
                    if (courses[next].prerequisites.isEmpty()) {
                        candidates.offer(next);
                    }
                }

            }
            if (!remains.isEmpty()) {
                semester ++;
            }
        }

        if (!remains.isEmpty()) {
            return -1;
        }
        return semester;
    }
}
