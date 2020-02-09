import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int[] numbers = new int[line.length];

        int evan = 0;
        int odd = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
            if (numbers[i] % 2 == 0) {
                evan += numbers[i];
            } else {
                odd += numbers[i];
            }
        }
        int finalSum = evan - odd;
        System.out.println(finalSum);

    }
}
