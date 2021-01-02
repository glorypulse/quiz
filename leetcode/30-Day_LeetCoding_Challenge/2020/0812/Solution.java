class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] pas = new int[rowIndex + 1];
        Arrays.fill(pas, 1);

        int prev, tmp;
        for (int i = 2; i <= rowIndex; i ++) {
            prev = pas[0];
            for (int j = 1; j < i; j ++) {
                tmp = pas[j];
                pas[j] = prev + pas[j];
                prev = tmp;
            }
        }
        List<Integer> pasList = new ArrayList<>();
        for (int p: pas) {
            pasList.add(p);
        }
        return pasList;
    }
}
