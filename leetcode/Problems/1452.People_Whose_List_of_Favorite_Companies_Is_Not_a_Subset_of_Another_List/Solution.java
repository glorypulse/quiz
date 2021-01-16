class Solution {
    class PairSet {
        int index;
        int size;
        Set<String> companies;
        boolean unique = true;

        PairSet(int index, int size, List<String> companies) {
            this.index = index;
            this.size = size;
            this.companies = new HashSet<>(companies);
        }
    }
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String, List<PairSet>> companiesMap = new HashMap<>();
        int index = 0;
        Set<Integer> indexSet = new HashSet<>();
        for (List<String> companiesList: favoriteCompanies) {
            int size = companiesList.size();
            PairSet companiesSet = new PairSet(index, size, companiesList);
            for (String company: companiesList) {
                List<PairSet> setList = companiesMap.get(company);
                if (setList == null) {
                    setList = new ArrayList<>();
                    companiesMap.put(company, setList);
                }
                setList.add(companiesSet);
            }
            indexSet.add(index);
            index ++;
        }

        TreeSet<Integer> ansSet = new TreeSet<>();
        for (List<PairSet> companies: companiesMap.values()) {
            for (PairSet check: companies) {
                if (!indexSet.contains(check.index)) continue;

                boolean ans = true;
                for (PairSet pair: companies) {
                    //System.out.println("check.. index: " + check.index + ", size: " + check.size);
                    //System.out.println("pair.. index: " + pair.index + ", size: " + pair.size);
                    if (check.size >= pair.size) continue;
                    //System.out.println("GO");
                    if (pair.companies.containsAll(check.companies)) {
                        ans = false;
                        //System.out.println("not ans");
                        break;
                    }
                }
                indexSet.remove(check.index);
                if (ans) ansSet.add(check.index);
            }
        }

        //System.out.println(ansSet.toString());
        return new ArrayList<Integer>(ansSet);
    }
}
