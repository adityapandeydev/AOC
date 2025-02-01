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
            boolean flag = false;
            for (int i = 0; i < report.length - 1; i++) {
                int left = Integer.parseInt(report[i]);
                int right = Integer.parseInt(report[i + 1]);

                if (left > right) {
                    if ((left - right) > 0 && (left - right) <= 3) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }

            for (int i = 0; i < report.length - 1; i++) {
                int left = Integer.parseInt(report[i]);
                int right = Integer.parseInt(report[i + 1]);

                if (right > left) {
                    if ((right - left) > 0 && (right - left) <= 3) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
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