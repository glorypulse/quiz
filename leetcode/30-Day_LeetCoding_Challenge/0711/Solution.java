class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> subsetList = new ArrayList<>();
      subsetList.add(new ArrayList<>());
      if (nums.length == 0) return subsetList;
      subsetList.add(new ArrayList<>(){
        {
          add(nums[0]);
        }
      });
      setSubsets(nums, 1, subsetList);
      return subsetList;
    }
    
    void setSubsets(int[] nums, int index, List<List<Integer>> subsetList) {
      if (index == nums.length) return;
      List<List<Integer>> additionalSubsets = new ArrayList<>();
      for (List<Integer> subset: subsetList) {
        additionalSubsets.add(new ArrayList<>(subset){
          {
            add(nums[index]);
          }
        });
      }
      subsetList.addAll(additionalSubsets);
      setSubsets(nums, index + 1, subsetList);
    }
}