import java.io.*;
import java.nio.file.*;
import java.nio.file.Path;
import java.util.*;

class Day1Part1 {
    public static void main(String[] args) throws IOException{
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("2024/Input/day1.1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line.trim();
                array1.add(Integer.parseInt(line.split(" ")[0]));
                array2.add(Integer.parseInt(line.split(" ")[3]));
                //System.out.println(line.split(" ")[0] + " " + line.split(" ")[3]);
            }
        }
        Collections.sort(array1);
        Collections.sort(array2);

        int sum = 0;
        for (int i = 0; i < array1.size(); i++) {
            sum += Math.abs(array1.get(i) - array2.get(i));
        }
        System.out.println(sum);
    }
}