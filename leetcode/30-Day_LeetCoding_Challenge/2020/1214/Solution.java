class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> palindromes = new ArrayList<>();
        setPalindromes(s, 0, "", partitions, palindromes);
        return partitions;
    }

    void setPalindromes (String str, int index, String prev, List<List<String>> partitions, List<String> palindromes) {
        if (index == str.length()) {
            if (prev.isEmpty()) {
                partitions.add(new ArrayList<>(palindromes));
            }
            return;
        }
        String check = prev + str.charAt(index);
        int left = 0;
        int right = check.length() - 1;
        boolean palindrome = true;
        while (left < right) {
            if (check.charAt(left) != check.charAt(right)) {
                palindrome = false;
                break;
            }
            left ++;
            right --;
        }
        if (palindrome) {
            palindromes.add(check);
            setPalindromes(str, index + 1, "", partitions, palindromes);
            palindromes.remove(palindromes.size() - 1);
        }
        setPalindromes(str, index + 1, prev + str.charAt(index), partitions, palindromes);
    }
}
