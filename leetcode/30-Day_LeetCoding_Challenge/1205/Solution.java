class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int length = flowerbed.length;
        if (length == 0) return false;
        if (length == 1) {
            if (n > 1) return false;
            return flowerbed[0] == 0;
        }
        int count = 0;
        if (flowerbed[0] + flowerbed[1] == 0) {
            count ++;
            flowerbed[0] = 1;
            if (n <= count) return true;
        }
        if (length == 2) return false;

        for (int i = 1; i < length - 1; i ++) {
            if (flowerbed[i - 1] + flowerbed[i] + flowerbed[i + 1] == 0) {
                count ++;
                flowerbed[i] = 1;
                if (n <= count) return true;
            }
        }

        if (flowerbed[length - 2] + flowerbed[length - 1] == 0) {
            count ++;
            flowerbed[length - 1] = 1;
            if (n <= count) return true;
        }

        return false;
    }
}
