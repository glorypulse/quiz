class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;
        ArrayList<LinkedList<Integer>> diagonalList = new ArrayList<>();
        int i = 0;
        int index;
        for(List<Integer> numList: nums) {
            count += numList.size();
            int j = 0;
            for (int num: numList) {
                index = i + j;
                if (diagonalList.size() == index) {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(num);
                    diagonalList.add(list);
                } else {
                    LinkedList<Integer> list = diagonalList.get(index);
                    list.addFirst(num);
                }
                j ++;
            }
            i ++;
        }

        int[] ans = new int[count];
        i = 0;
        for (LinkedList<Integer> diagonal: diagonalList) {
            for (int num: diagonal) {
                ans[i] = num;
                i ++;
            }
        }
        return ans;
    }
}
