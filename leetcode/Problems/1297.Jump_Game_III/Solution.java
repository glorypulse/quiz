import java.util.List;
import java.util.ArrayList;

class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return findZero(start, arr, visited);
    }

    boolean findZero(int index, int[] arr, boolean[] visited) {
        if (arr[index] == 0) return true;
        visited[index] = true;

        int jump_index;
        jump_index = index - arr[index];
        if (jump_index >= 0 && !visited[jump_index]) {
            if (findZero(jump_index, arr, visited)) return true;
        }
        jump_index = index + arr[index];
        if (jump_index < arr.length && !visited[jump_index]) {
            if (findZero(jump_index, arr, visited)) return true;
        }
        return false;
    }
}
