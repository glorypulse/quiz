class ProductOfNumbers {
    int[] numbers;
    int length = 0;


    public ProductOfNumbers() {
        numbers = new int[40000];
        Arrays.fill(numbers, 1);
    }

    public void add(int num) {
        for (int i = 0; i < length; i ++) {
            numbers[i] *= num;
        }
        numbers[length] = num;
        length ++;
    }

    public int getProduct(int k) {
        return numbers[length - k];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
