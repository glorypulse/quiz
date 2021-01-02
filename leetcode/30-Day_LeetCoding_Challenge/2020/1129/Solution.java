class Solution {
    public boolean canReach(int[] arr, int start) {
        return canReach(arr, start, new boolean[arr.length]);
    }

    boolean canReach(int[] arr, int index, boolean[] visited) {
        if (visited[index]) return false;
        visited[index] = true;
        if (arr[index] == 0 ||
            index - arr[index] >= 0 && canReach(arr, index - arr[index], visited) ||
            index + arr[index] < arr.length && canReach(arr, index + arr[index], visited)) {
            return true;
        }
        return false;
    }
}
