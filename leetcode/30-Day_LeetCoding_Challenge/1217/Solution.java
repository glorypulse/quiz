class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = A.length;
        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < length; j ++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int sumCount = 0;
        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < length; j ++) {
                int target = -(C[i] + D[j]);
                sumCount += map.getOrDefault(target, 0);
            }
        }
        return sumCount;
    }

    /*
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int length = A.length;
        for (int[] tuple: new int[][] { A, B, C }) {
            int size = queue.size();
            for (int j = 0; j < size; j ++) {
                int prev = queue.poll();
                for (int i = 0; i < length; i ++) {
                    int sum = prev + tuple[i];
                    queue.offer(sum);
                }
            }
        }

        int sumCount = 0;
        while (!queue.isEmpty()) {
            int sum = queue.poll();
            for (int i = 0; i < length; i ++) {
                if (sum + D[i] == 0) {
                    sumCount ++;
                }
            }
        }
        return sumCount;
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int length = A.length;
        for (int[] tuple: new int[][] { A, B, C }) {
            Map<Integer, Integer> next = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int prev = entry.getKey();
                int count = entry.getValue();
                for (int i = 0; i < length; i ++) {
                    int sum = prev + tuple[i];
                    next.put(sum, next.getOrDefault(sum, 0) + count);
                }
            }
            map = next;
        }

        int sumCount = 0;
        for (int i = 0; i < length; i ++) {
            sumCount += map.getOrDefault(-D[i], 0);
        }
        return sumCount;
    }

    */
 }
