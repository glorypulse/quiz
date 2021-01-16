import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        Set<String> invalid_transactions = new HashSet<String>();
        ArrayList<String[]> t_array_list = new ArrayList<String[]>();

        String[] t_array, check_array;
        for (String transaction: transactions) {
            t_array = transaction.split(",");
            if (Integer.parseInt(t_array[2]) > 1000) {
                invalid_transactions.add(transaction);
            }
            for (int i = 0; i < t_array_list.size(); i ++) {
                check_array = t_array_list.get(i);
                if (!check_array[0].equals(t_array[0]) || check_array[3].equals(t_array[3]) || Math.abs(Integer.parseInt(check_array[1]) - Integer.parseInt(t_array[1])) > 60) {
                    continue;
                }
                invalid_transactions.add(String.join(",", check_array));
                invalid_transactions.add(transaction);
            }

            t_array_list.add(t_array);
        }

        return new ArrayList<String>(invalid_transactions);
    }
}
