import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class Day2Part2 {
    public static void main(String[] args) throws IOException {
        int count = 0;
        try (BufferedReader reader = Files.newBufferedReader(Path.of("2024/Input/day2.1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int[] report = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                if (Utils.isSafe(report)) {
                    count++;
                } else {
                    for (int i = 0; i <  report.length; i++) {
                        int[] modifiedReport = removeElement(report, i);
                        if (Utils.isSafe(modifiedReport)) {
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static int[] removeElement(int[] report, int index) {
        if (report.length <= 0)
            return new int[0];

        int[] newReport = new int[report.length - 1];
        for (int i = 0, j = 0; i < report.length; i++) {
            if (i != index) {
                newReport[j++] = report[i];
            }
        }
        return newReport;
    }
}