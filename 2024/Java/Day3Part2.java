import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("2024/Input/day3.txt"))) {
            String line;
            int sum = 0;
            boolean flag = true;
            while((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile("(do\\(\\))|(don't\\(\\))|(mul\\((\\d+),(\\d+)\\))");
                Matcher match = pattern.matcher(line);
                while(match.find()) {
                    if (match.group(1) != null) {
                        flag = true;
                    }
                    if (match.group(2) != null) {
                        flag = false;
                    }
                    if (match.group(3) != null && flag) {
                        int firstNumber = Integer.parseInt(match.group(4));
                        int secondNumber = Integer.parseInt(match.group(5));
                        sum += (firstNumber * secondNumber);
                    }
                }
            }
            System.out.println(sum);
        }
    }
}