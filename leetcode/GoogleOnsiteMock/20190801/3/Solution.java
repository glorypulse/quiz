import java.util.HashMap;
import java.util.Map;
import java.util.ArrayDeque;
import java.util.ArrayList;
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Double> equationsMap = new HashMap<>();
        int index = 0, q_index = 0, queueSize = 0;;
        String denominator, numerator, q_d, q_n;
        double[] retEquation = new double[queries.size()];
        Arrays.fill(retEquation, 1.0);
        ArrayDeque<List<String>> queue = new ArrayDeque<>();
        for (List<String> query: queries) {
            queue.offer(query);
        }
        List<String> query, query2;
        for (List<String> equation: equations) {
            equationsMap.put(equation.toString(), values[index]);

            numerator = equation.get(0);
            denominator = equation.get(1);

            // same
            query = new ArrayList<>();
            query.add(numerator);
            query.add(numerator);
            equationsMap.put(query.toString(), 1.0);

            query = new ArrayList<>();
            query.add(denominator);
            query.add(denominator);
            equationsMap.put(query.toString(), 1.0);

            // upside down

            query = new ArrayList<>();
            query.add(denominator);
            query.add(numerator);
            equationsMap.put(query.toString(), 1.0 / values[index]);

            q_index = 0;
            queueSize = queue.size();
            for (q_index = 0; q_index < queueSize; q_index ++) {
                query = queue.poll();
                if (query.isEmpty()) {
                    queue.offer(query);
                    continue;
                }
                if (equationsMap.containsKey(query.toString())) {
                    retEquation[q_index] *= equationsMap.get(query.toString());
                    query = queries.get(q_index);
                    equationsMap.put(query.toString(), retEquation[q_index]);
                    query2 = new ArrayList<>();
                    query2.add(query.get(1));
                    query2.add(query.get(0));
                    equationsMap.put(query2.toString(), 1.0 / retEquation[q_index]);
                    queue.offer(new ArrayList<>());
                    continue;
                }

                q_n = query.get(0);
                q_d = query.get(1);

                if (q_n.equals(numerator)) {
                    retEquation[q_index] *= values[index];
                    List<String> newQuery = new ArrayList<>();
                    newQuery.add(denominator);
                    newQuery.add(q_d);
                    queue.offer(newQuery);
                    continue;
                }

                if (q_d.equals(denominator)) {
                    retEquation[q_index] *= values[index];
                    List<String> newQuery = new ArrayList<>();
                    newQuery.add(q_n);
                    newQuery.add(numerator);
                    queue.offer(newQuery);
                    continue;
                }

                queue.offer(query);
            }
            index ++;
        }

        queueSize = queue.size();
        for (q_index = 0; q_index < queueSize; q_index ++) {
            query = queue.poll();
            if (query.isEmpty()) continue;
            if (equationsMap.containsKey(query.toString())) {
                retEquation[q_index] *= equationsMap.get(query.toString());
                query = queries.get(q_index);
                equationsMap.put(query.toString(), retEquation[q_index]);
                query2 = new ArrayList<>();
                query2.add(query.get(1));
                query2.add(query.get(0));
                equationsMap.put(query2.toString(), 1.0 / retEquation[q_index]);
                queue.offer(new ArrayList<>());
                continue;
            }
            retEquation[q_index] = -1.0;
        }

        return retEquation;
    }
}
