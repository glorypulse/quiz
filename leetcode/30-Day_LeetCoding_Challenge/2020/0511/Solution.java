class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        int n = image.length;
        if (n == 0) return image;
        int m = image[0].length;

        replaceColor(image, sr, sc, n, m, image[sr][sc], newColor);
        return image;
    }

    void replaceColor(int[][] image, int r, int c, int n, int m, int baseColor, int newColor) {
        if (image[r][c] != baseColor) return;

        image[r][c] = newColor;
        if (r > 0) {
            replaceColor(image, r - 1, c, n, m, baseColor, newColor);
        }
        if (r < n - 1) {
            replaceColor(image, r + 1, c, n, m, baseColor, newColor);
        }
        if (c > 0) {
            replaceColor(image, r, c - 1, n, m, baseColor, newColor);
        }
        if (c < m - 1) {
            replaceColor(image, r, c + 1, n, m, baseColor, newColor);
        }
    }
}
