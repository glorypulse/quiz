import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        Comparator<int[]> firstItemComparator = new Comparator<int[]>() {
                @Override
                public int compare(int[] arr1, int[] arr2) {
                    return arr1[0] - arr2[0];
                }
            };

        PriorityQueue<int[]> uglyNumbers = new PriorityQueue<>(firstItemComparator);
        Set<Integer> existed = new HashSet<>();
        int[] uglyNumber = new int[2];
        uglyNumber[0] = a;
        uglyNumber[1] = a;
        uglyNumbers.add(uglyNumber);
        existed.add(a);

        uglyNumber = new int[2];
        uglyNumber[0] = b;
        uglyNumber[1] = b;
        uglyNumbers.add(uglyNumber);
        existed.add(b);

        uglyNumber = new int[2];
        uglyNumber[0] = c;
        uglyNumber[1] = c;
        uglyNumbers.add(uglyNumber);
        existed.add(c);

        while ( n > 0 ) {
            uglyNumber = uglyNumbers.remove();
            System.out.println(uglyNumber[0]);
            n --;
            if (n == 0) break;

            while (existed.contains(uglyNumber[0])) {
                uglyNumber[0] += uglyNumber[1];
            }
            existed.add(uglyNumber[0]);
            uglyNumbers.add(uglyNumber);
        }

        return uglyNumber[0];
    }
}
