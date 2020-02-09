import java.util.Scanner;

public class ReadArrayFromConsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // String[] line = scanner.nextLine().split(" ");
        String line = scanner.nextLine();
        String[] numberStrings = line.split(" ");

        int[] numbers = new int[numberStrings.length];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);

            if (numbers[i] % 2 == 0 ){
                sum += numbers[i];
            }
        }
        System.out.println(sum);

    }
}
