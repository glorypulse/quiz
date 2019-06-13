class Quiz01 {
    static int insert_m_to_n(int n, int m, int i, int j) {
        // nのjけた目より上
        int n_upper = n >> (i + j);
        n_upper <<= (i + j);

        // nのiけた目より下
        int mask_lower = 1;
        for (int l = 0; l < i; l ++) {
            mask_lower <<= 1;
            mask_lower += 1;
        }
        int n_lower = n & mask_lower;

        return n_upper | (m << i) | n_lower;

    }
    public static void main(String[] args) {
        int n = Integer.parseInt("10000111000", 2);
        int m = Integer.parseInt("10011", 2);
        System.out.println(Integer.toBinaryString(insert_m_to_n(n, m, 2, 6)));
    }
}
