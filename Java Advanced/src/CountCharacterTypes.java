import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountCharacterTypes {
    public static void main(String[] args) {


        String dir = System.getProperty("user.dir") + "\\resources\\words.txt";
        String dir2 = System.getProperty("user.dir") + "\\resources\\text.txt";

        try {
            File file = new File("myOutput.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            Map<String, Integer> counter = new LinkedHashMap<>();
            String[] tokens = new BufferedReader(new FileReader(dir)).readLine().split(" ");

            for (String token : tokens) {
                counter.putIfAbsent(token, 0);
            }
            Files.lines(Paths.get(dir2)).forEach(line -> {
                Arrays.stream(line.split("[, \\-]+")).forEach(str -> {
                    if (counter.containsKey(str)) {
                        counter.put(str, counter.get(str) + 1);
                    }
                });
            });

            counter.forEach((key,value)->{
                try {
                    writer.write(String.format("%s - %d%n",key,value));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
