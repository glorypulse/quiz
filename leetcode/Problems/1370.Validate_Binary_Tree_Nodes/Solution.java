class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> rootSet = new HashSet<>();
        for (int i = 0; i < n; i ++) {
            rootSet.add(i);
        }
        int[] parents = new int[n];
        Arrays.fill(parents, -1);

        int child;
        for (int i = 0; i < n; i ++) {
            child = leftChild[i];
            if (child != -1) {
                rootSet.remove(child);
                if (parents[child] != -1) {
                    return false;
                } else {
                    parents[child] = i;
                }
            }

            child = rightChild[i];
            if (child != -1) {
                rootSet.remove(child);
                if (parents[child] != -1) {
                    return false;
                } else {
                    parents[child] = i;
                }
            }
        }

        if (rootSet.size() != 1) {
            return false;
        }
        return true;
    }
}
