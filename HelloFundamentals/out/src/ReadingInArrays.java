import java.util.Scanner;

public class ReadingInArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int[] numbers = new int[line.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length - 1; i++) {
            int element = numbers[i];

            for (int k = i + 1; k < numbers.length; k++) {
                if (element + numbers[k] == n) {
                    System.out.println(element + " " + numbers[k]);
                }
            }
        }
    }
}
