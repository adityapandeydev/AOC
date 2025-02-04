import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part1 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("2024/Input/day3.txt"))) {
            String line;
            int sum = 0;
            while((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
                Matcher match = pattern.matcher(line);
                while(match.find()) {
                    int firstNumber = Integer.parseInt(match.group(1));
                    int secondNumber = Integer.parseInt(match.group(2));
                    sum += firstNumber * secondNumber;
                }
            }
            System.out.println(sum);
        }
    }
}