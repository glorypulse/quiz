class Solution {
    class Node {
        long val;
        int index;
        Node(long val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        if (length == 0) return false;
        TreeSet<Node> ksSet = new TreeSet<>((a,b) -> {
                if (a.val < b.val) {
                    return -1;
                } else if (a.val > b.val) {
                    return 1;
                } else {
                    return a.index - b.index;
                }
        });
        Node[] indexes = new Node[length];

        for (int i = 0; i < Math.min(k + 1, length); i ++) {
            Node current = new Node(nums[i], i);
            indexes[i] = current;
            ksSet.add(current);
        }

        Node pre = null;
        for (Node node: ksSet) {
            if (pre != null) {
                if (Math.abs(pre.val - node.val) <= t) return true;
            }
            pre = node;
        }

        for (int i = k + 1; i < length; i ++) {
            ksSet.remove(indexes[i - k - 1]);

            Node current = new Node(nums[i], i);
            Node check = ksSet.floor(current);
            if (check != null && Math.abs(check.val - nums[i]) <= t) {
                return true;
            }
            check = ksSet.ceiling(current);
            if (check != null && Math.abs(check.val - nums[i]) <= t) {
                return true;
            }

            indexes[i] = current;
            ksSet.add(current);
        }

        return false;
    }
}
