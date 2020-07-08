class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      HashMap<Integer, HashMap<String, int[]>> twoSumMap = new HashMap<>();
      HashMap<String, int[]> ansMap = new HashMap<>();
      
      int n = nums.length;
      for (int i = 0; i < n; i ++) {
        int value = nums[i];
        
        HashMap<String, int[]> twoSum = twoSumMap.get(-value);
        if (twoSum != null) {
          for (int[] tupple: twoSum.values()) {
            int[] triplet = new int[]{ tupple[0], tupple[1], value };
            Arrays.sort(triplet);
            ansMap.put(String.valueOf(triplet[0]) + "," + String.valueOf(triplet[1]) + "," + String.valueOf(triplet[2]),
                       triplet);
          }
        }
        
        for (int j = 0; j < i; j ++) {
          int[] tupple = new int[] { nums[j], value };
          Arrays.sort(tupple);
          int sum = nums[j] + value;
          twoSum = twoSumMap.get(sum);
          if (twoSum == null) {
            twoSum = new HashMap<>();
            twoSumMap.put(sum, twoSum);
          }
          twoSum.put(String.valueOf(tupple[0]) + "," + String.valueOf(tupple[1]),
                     tupple);
        }
      }
      
      List<List<Integer>> ansList = new ArrayList<>();
      for (int[] triplet: ansMap.values()) {
        List<Integer> ans = new ArrayList<>();
        ans.add(triplet[0]);
        ans.add(triplet[1]);
        ans.add(triplet[2]);
        ansList.add(ans);
      }
      
      return ansList;  
    }
}