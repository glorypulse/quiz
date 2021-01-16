/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> solutionList = new ArrayList<>();
        List<Integer> solution;
        int ans;
        for (int x = 1; x <= z; x ++) {
            ans = customfunction.f(x, 1);
            if (ans == z) {
                    solution = new ArrayList<>();
                    solution.add(x);
                    solution.add(1);
                    solutionList.add(solution);
            } else if (ans > z) {
                break;
            }
            for (int y = 2; y <= z; y ++) {
                ans = customfunction.f(x, y);
                if (ans == z) {
                    solution = new ArrayList<>();
                    solution.add(x);
                    solution.add(y);
                    solutionList.add(solution);
                } else if (ans > z) {
                    break;
                }
            }
        }
        return solutionList;
    }
}
