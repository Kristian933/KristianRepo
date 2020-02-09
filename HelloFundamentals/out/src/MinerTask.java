import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        LinkedHashMap<String, Long> table = new LinkedHashMap<>();

        int counter = 0;
        String word = "";

        while (!input.equals("stop")) {
            counter++;
            long quantity = 0;
            if (counter % 2 == 1 && !table.containsKey(input)) {
                table.put(input, (long) 0);
            }
            if (counter % 2 == 1){
                word = input;
            }
            if (counter % 2 == 0) {
                quantity = Integer.parseInt(input);
                long currentIndex = table.get(word);
                table.put(word, currentIndex + quantity);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String,Long> entry:table.entrySet()) {
            System.out.println((String.format("%s -> %d",entry.getKey(),entry.getValue())));
        }
    }
}
