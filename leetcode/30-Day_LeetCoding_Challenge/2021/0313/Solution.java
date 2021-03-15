class Solution {
    class Product {
        int val1;
        int val2;
        Product(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, List<Product>> productMap = new HashMap<>();
        int length = arr.length;
        int max = arr[length - 1];
        for (int i = 0; i < length; i ++) {
            productMap.put(arr[i], new ArrayList<>());
        }

        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < length; j ++) {
                long product = arr[i] * arr[j];
                if (product > max) break;
                List<Product> pList = productMap.get((int)product);
                if (pList == null) continue;
                pList.add(new Product(arr[i], arr[j]));
            }
        }

        //int[] counts = new int[max + 1];
        Map<Integer, Long> countMap = new HashMap<>();
        int totalCount = 0;
        long curCount = 0;
        for (int i = 0; i < length; i ++) {
            List<Product> pList = productMap.get(arr[i]);
            curCount = 1;
            for (Product p: pList) {
                //curCount += (counts[p.val1] * counts[p.val2]) % 1000000007;
                curCount += countMap.get(p.val1) * countMap.get(p.val2);
            }
            //counts[arr[i]] = curCount;
            countMap.put(arr[i], curCount);
            totalCount = (int)((totalCount + curCount) % 1000000007);
        }
        return totalCount;
    }
}
