import java.io.*;
import java.nio.file.*;
import java.nio.file.Path;
import java.util.*;

class Day1Part2 {
    public static void main(String[] args) throws IOException{
        ArrayList<Integer> array1 = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("2024/Input/day1.1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line.trim();
                array1.add(Integer.parseInt(line.split(" ")[0]));
                int key = Integer.parseInt(line.split(" ")[3]);
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
                //System.out.println(line.split(" ")[0] + " " + line.split(" ")[3]);
            }
        }

        int sum = 0;
        for (int i = 0; i < array1.size(); i++) {
            if (map.containsKey(array1.get(i))) {
                sum += array1.get(i) * map.get(array1.get(i));
            }
        }
        System.out.println(sum);
    }
}