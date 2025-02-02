import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class Day2Part1 {
    public static void main(String[] args) throws IOException {
        int count = 0;
        try (BufferedReader reader = Files.newBufferedReader(Path.of("2024/Input/day2.1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int[] report = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                if (isSafe(report)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isSafe(int[] report) {
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