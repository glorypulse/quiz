class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i ++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
                if (i % 5 == 0) {
                    sb.append("Buzz");
                }
            } else if (i % 5 == 0) {
                sb.append("Buzz");
            } else {
                sb.append(i);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
