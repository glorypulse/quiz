class Solution {
    public int minJumps(int[] arr) {
        int length = arr.length;
        if (length <= 1) return 0;

        Map<Integer, LinkedList<Integer>> valueMap = new HashMap<>();
        valueMap.put(arr[0],
                     new LinkedList<>() {
                         {
                             add(0);
                         }
                     });

        for (int i = 1; i < length; i ++) {
            int val = arr[i];
            LinkedList<Integer> sameValues = valueMap.get(val);
            if (sameValues == null) {
                sameValues = new LinkedList<>();
                valueMap.put(val, sameValues);
            }
            sameValues.addFirst(i);
        }

        int[] steps = new int[length];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int step = steps[index];

            // i - 1
            if (index - 1 > 0 && steps[index - 1] > step + 1) {
                steps[index - 1] = step + 1;
                queue.offer(index - 1);
            }
            // i + 1
            if (index + 1 < length && steps[index + 1] > step + 1) {
                if (index + 1 == length - 1) return step + 1;
                steps[index + 1] = step + 1;
                queue.offer(index + 1);
            }

            // same Values
            for (int next: valueMap.getOrDefault(arr[index], new LinkedList<>())) {
                if (steps[next] <= step + 1) continue;
                if (next == length - 1) return step + 1;
                steps[next] = step + 1;
                queue.offer(next);
            }
        }

        return length - 1;
    }
}
