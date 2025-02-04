import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day3Part1 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("2024/Input/day3.txt"))) {
            String line;
            int sum = 0;
            while((line = reader.readLine()) != null) {
                line = line.replaceAll("(mul\\(\\d{1,3},\\d{1,3}\\))|.", "$1");
                line = line.replaceAll("(\\(\\d{1,3},\\d{1,3}\\))|.", "$1");
                int i = 0;
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == ')') {
                        int firstNumber = Integer.parseInt(line.substring(i + 1, j).split(",")[0]);
                        int secondNumber = Integer.parseInt(line.substring(i + 1, j).split(",")[1]);
                        sum += firstNumber * secondNumber;
                        i = j + 1;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}