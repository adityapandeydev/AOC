import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Day2Part1 {
    public static void main(String[] args) throws IOException{
        ArrayList<String[]> reports = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("2024/Input/day2.1.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                reports.add(line.split(" "));
            }
        }

        int count = 0;
        for (String[] report : reports) {
            boolean flag = true;
            int left = Integer.parseInt(report[0]);
            int right = Integer.parseInt(report[1]);
            boolean isIncreasing = right > left;
            boolean difference = (Math.abs(right - left) >= 1) && (Math.abs(right - left) <= 3);
            for (int i = 1; i < report.length - 1; i++) {
                if (!difference) {
                    flag = false;
                    break;
                }
                left = Integer.parseInt(report[i]);
                right = Integer.parseInt(report[i + 1]);
                difference = (Math.abs(right - left) >= 1) && (Math.abs(right - left) <= 3);
                if (isIncreasing && (left > right)) {
                    flag = false;
                    break;
                } else if (!isIncreasing && (right > left)) {
                    flag = false;
                    break;
                } else if (!difference) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        System.out.println(count);
    }
}