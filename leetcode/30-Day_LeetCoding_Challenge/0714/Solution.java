class Solution {
    public double angleClock(int hour, int minutes) {
        double minAngle = 6.0 * minutes;
        double hourAngle = 30.0 * (hour % 12) + 30.0 * (minutes / 60.0);
        double angle = Math.abs(hourAngle - minAngle);
        return Math.min(angle, 360.0 - angle);
    }
}
