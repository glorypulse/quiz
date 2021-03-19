class Solution {
    double radius, x_center, y_center;


    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double x0 = x_center - radius;
        double y0 = y_center - radius;
        while (true) {
            double x = x0 + 2 * radius * Math.random();
            double y = y0 + 2 * radius * Math.random();
            if (Math.sqrt(Math.pow(x - x_center, 2) + Math.pow(y - y_center, 2)) <= radius) {
                return new double[]{ x, y };
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
