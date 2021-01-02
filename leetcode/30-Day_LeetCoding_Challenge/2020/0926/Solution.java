class Solution {
    public String largestNumber(int[] nums) {
	int length = nums.length;
	if (length == 0) return "";
	
	ArrayList<Integer> orderedNums = new ArrayList<>();
	orderedNums.add(nums[0]);
	boolean allZero = nums[0] == 0 ? true : false;

	for (int i = 1; i < length; i ++) {
	    int num = nums[i];
	    if (allZero && num != 0) {
		allZero = false;
	    }	    
	    for (int j = 0; j < orderedNums.size(); j ++) {
		int check = orderedNums.get(j);
		long first = Long.parseLong(String.valueOf(num) + String.valueOf(check));
		long next = Long.parseLong(String.valueOf(check) + String.valueOf(num));
		if (first >= next) {
		    orderedNums.add(j, num);
		    break;
		} else if (j == orderedNums.size() - 1) {
		    orderedNums.add(num);
		    break;
		}
	    }
	}
	if (allZero) return "0";
	StringBuilder sb = new StringBuilder();
	for (int num: orderedNums) {
	    sb.append(num);
	}
	return sb.toString();
    }
}
