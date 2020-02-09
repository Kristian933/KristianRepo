import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();

        Map<Character, Integer> symbols = new TreeMap<>();

        for (char c: input) {
            symbols.putIfAbsent(c, 0);
            symbols.put(c , symbols.get(c) + 1);
        }

        symbols.forEach((k,v)->{
            System.out.printf("%s: %d time/s%n",k,v);
        });
    }
}
