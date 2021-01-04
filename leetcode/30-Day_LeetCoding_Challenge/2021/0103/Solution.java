class Solution {
    public int countArrangement(int n) {
        ArrayList<Integer>[] candidatesArray = new ArrayList[n];
        for (int i = 0; i < n; i ++) {
            candidatesArray[i] = new ArrayList<>();
            candidatesArray[i].add(i + 1);
        }
        for (int i = 1; i <= n; i ++) {
            for (int j = i + 1; j <= n; j ++) {
                if (j % i == 0) {
                    candidatesArray[i - 1].add(j);
                    candidatesArray[j - 1].add(i);
                }
            }
        }

        boolean[] used = new boolean[n];
        return countArrangement(0, used, candidatesArray);
    }

    int countArrangement(int index, boolean[] used, ArrayList<Integer>[] candidatesArray) {
        if (index == used.length) return 1;
        ArrayList<Integer> candidates = candidatesArray[index];
        int count = 0;
        for (int candidate: candidates) {
            if (used[candidate - 1]) continue;
            used[candidate - 1] = true;
            count += countArrangement(index + 1, used, candidatesArray);
            used[candidate - 1] = false;
        }
        return count;
    }
}
