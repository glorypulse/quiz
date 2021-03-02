/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Set<Integer> candidates = new HashSet<>();
        for (int i = 0; i < n; i ++) {
            candidates.add(i);
        }
        int i = 0;
        int j = 1;
        while (i < n && j < n) {
            if (i == j || !candidates.contains(j)) {
                j ++;
            } else if (!candidates.contains(i) || knows(i, j)) {
                candidates.remove(i);
                i ++;
            } else {
                candidates.remove(j);
                j ++;
            }
        }

        // candidates.size() is 1
        int candidate = -1;
        for (int c: candidates) {
            candidate = c;
            for (i = 0; i < n; i ++) {
                if (i == candidate) continue;
                if (!knows(i, candidate)) return -1;
                if (knows(candidate, i)) return -1;
            }
        }
        return candidate;
    }
}
