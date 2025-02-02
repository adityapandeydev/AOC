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
                if (Utils.isSafe(report)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}