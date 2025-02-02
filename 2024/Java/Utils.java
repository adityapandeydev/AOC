public class Utils {
    public static boolean isSafe(int[] report) {
        int left = report[0];
        int right = report[1];
        boolean isIncreasing = right > left;
        for (int i = 0; i < report.length - 1; i++) {
            left = report[i];
            right = report[i + 1];
            boolean difference = (Math.abs(right - left) >= 1) && (Math.abs(right - left) <= 3);
            if ((isIncreasing && left > right) || (!isIncreasing && right > left) || !difference) {
                return false;
            }
        }
        return true;
    }
}