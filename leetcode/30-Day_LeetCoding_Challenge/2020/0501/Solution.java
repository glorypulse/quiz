/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;
        long target = (1 + n) / 2;

        while (left <= right) {
            target = (left + right) / 2;
            if (isBadVersion((int)target)) {
                if (target == 1 || !isBadVersion((int)target - 1)) {
                    return (int)target;
                }
                right = target - 1;
            } else {
                left = target + 1;
            }
        }
        return (int)target;
    }
}
