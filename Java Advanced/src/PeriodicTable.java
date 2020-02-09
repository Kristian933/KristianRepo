import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Set<String> periodic = new TreeSet<>();


        for (int i = 0; i < lines; i++) {
            String[] input = scanner.nextLine().split(" ");
            periodic.addAll(Arrays.asList(input));
        }

        for (String s : periodic) {
            System.out.print(s + " ");
        }

    }
}
