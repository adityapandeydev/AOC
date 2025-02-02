import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Day2Part2 {
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
            int damper = 1;
            boolean flag = true;
            int left = Integer.parseInt(report[0]);
            int right = Integer.parseInt(report[1]);
            boolean isIncreasing = right > left;
            boolean difference = (Math.abs(right - left) >= 1) && (Math.abs(right - left) <= 3);
            for (int i = 1; i < report.length - 1; i++) {
                if (!difference) {
                    if (damper == 0) {
                        flag = false;
                        break;
                    }
                    damper--;
                }
                left = Integer.parseInt(report[i]);
                right = Integer.parseInt(report[i + 1]);
                difference = (Math.abs(right - left) >= 1) && (Math.abs(right - left) <= 3);
                if (isIncreasing && (left > right)) {
                    if (damper == 0) {
                        flag = false;
                        break;
                    }
                    damper--;
                } else if (!isIncreasing && (right > left)) {
                    if (damper == 0) {
                        flag = false;
                        break;
                    }
                    damper--;
                } else if (!difference) {
                    if (damper == 0) {
                        flag = false;
                        break;
                    }
                    damper--;
                }
            }
            if (flag) {
                for (String ch : report) {
                    System.out.print(ch + " ");
                }
                System.out.println();
                count++;
            }
        }
        System.out.println(count);
    }
}