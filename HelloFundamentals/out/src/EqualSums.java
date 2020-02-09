import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int[] number = new int[line.length];

        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(line[i]);
        }

        String output = "no";
        for (int i = 0; i < number.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int k = 0; k < i; k++) {
                leftSum += number[k];
            }
            for (int j = i + 1; j < number.length; j++) {
                rightSum += number[j];
            }
            if (leftSum == rightSum) {
                output = i + " ";
                break;
            }
        }
        System.out.println(output);
    }
}
