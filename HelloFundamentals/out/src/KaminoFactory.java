import java.util.Objects;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String clone = scanner.nextLine();
        String[] dna = clone.split("!");
        int[] number = new int[dna.length];


        int[] firstOne = new int[length];
        int counter = 0;
        int sum = 0;


        while (!clone.equals("Clone them!")) {
            for (int i = 0; i < number.length; i++) {
                number[i] = Integer.parseInt(dna[i]);
            }
            for (int i = 0; i < number.length; i++) {
                if (number[i] > firstOne[i]) {
                    for (int k = 0; k < number.length; k++) {
                        firstOne[k] = number[k];
                        if (k + 1 == number.length) {
                            counter++;
                        }
                    }
                }
            }
            clone = scanner.nextLine();
            dna = clone.split("!");

        }
        for (int i = 0; i < firstOne.length; i++) {
            sum += firstOne[i];

        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", counter, sum);
        for (int i = 0; i < firstOne.length; i++) {
            System.out.print(firstOne[i] + " ");
        }
    }
}