class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        Double[][] champagnes = new Double[query_row + 1][query_glass + 1];
        champagnes[0][0] = new Double(poured);
        double ansPoured = getChampagne(query_row, query_glass, champagnes);
        return ansPoured > 1 ? 1.0 : ansPoured;
    }

    public double getChampagne(int query_row, int query_glass, Double[][] champagnes) {
        if (query_row < 0 || query_glass < 0 || query_row >= champagnes.length || query_glass >= champagnes[0].length) return 0;
        if (champagnes[query_row][query_glass] != null) return champagnes[query_row][query_glass];
        champagnes[query_row][query_glass] =
            Math.max(getChampagne(query_row - 1, query_glass - 1, champagnes) - 1, 0) / 2.0 +
            Math.max(getChampagne(query_row - 1, query_glass, champagnes) - 1, 0) / 2.0;
        return champagnes[query_row][query_glass];
    }
}
