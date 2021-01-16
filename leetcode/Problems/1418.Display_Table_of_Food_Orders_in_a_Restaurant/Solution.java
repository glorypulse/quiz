class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, HashMap<String, Integer>> tableOrders = new TreeMap<>();
        TreeSet<String> foodNames = new TreeSet<>();

        // orderを読み込む処理
        for (List<String> order: orders) {
            Iterator<String> it = order.iterator();
            it.next(); // customerNameは使わない
            int tableNumber = Integer.parseInt(it.next());
            String orderedFood = it.next();

            foodNames.add(orderedFood);
            HashMap<String, Integer> tableOrder = tableOrders.get(tableNumber);
            if (tableOrder == null) {
                tableOrder = new HashMap<>();
                tableOrders.put(tableNumber, tableOrder);
            }
            int foodCount = tableOrder.getOrDefault(orderedFood, 0);
            foodCount ++;
            tableOrder.put(orderedFood, foodCount);
        }


        // tableOrderListを作る処理
        String[] foodNamesArray = new String[foodNames.size()];
        foodNames.toArray(foodNamesArray);

        // 1行目
        List<List<String>> orderList = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        for (String foodName: foodNamesArray) {
            header.add(foodName);
        }
        orderList.add(header);

        // 2行目以降
        for (Map.Entry<Integer, HashMap<String, Integer>> tableOrderWithNum: tableOrders.entrySet()) {
            List<String> tableOrderList = new ArrayList<>();
            tableOrderList.add(String.valueOf(tableOrderWithNum.getKey()));
            HashMap<String, Integer> tableOrderMap = tableOrderWithNum.getValue();
            for (String foodName: foodNamesArray) {
                int orderCount = tableOrderMap.getOrDefault(foodName, 0);
                tableOrderList.add(String.valueOf(orderCount));
            }
            orderList.add(tableOrderList);
        }
        return orderList;
    }
}
