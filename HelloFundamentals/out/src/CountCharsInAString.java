import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String text = scanner.nextLine();

        LinkedHashMap<Character, Integer> table = new LinkedHashMap<>();

        for (char symbol:text.toCharArray()) {
            if (symbol != ' '){
                if (!table.containsKey(symbol)){
                    table.put(symbol,1);
                }else {
                    int currentIndex = table.get(symbol);
                    table.put(symbol , currentIndex + 1);
                }
            }
        }

        for (Map.Entry<Character,Integer> entry:table.entrySet()) {
            System.out.println(String.format("%c -> %d",entry.getKey(),entry.getValue()));
        }
    }
}
