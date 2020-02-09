import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int first = scanner.nextInt();
        int second = scanner.nextInt();
        scanner.nextLine();

        Set<Integer> firstOne = new LinkedHashSet<>();
        Set<Integer> secondOne = new LinkedHashSet<>();


        for (int i = 0; i < first; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstOne.add(number);
        }

        for (int i = 0; i < second; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondOne.add(number);
        }


        for (Integer integer : firstOne) {
            if (secondOne.contains(integer)) {
                System.out.print(integer + " ");
            }
        }


    }
}
