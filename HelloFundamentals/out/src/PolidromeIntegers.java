import java.util.Arrays;
import java.util.Scanner;

public class PolidromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String index = scanner.nextLine();

        char letter;
        boolean printing = true;
        int count = 0;

        while (!index.equals("END")) {
            int number = Integer.parseInt(index);
            int length = index.length();

            int[] firstSum = new int[length];
            int[] secondSum = new int[length];

            for (int i = 0; i < index.length(); i++) {
                letter = index.charAt(i);
                firstSum[i] = letter;
            }
            for (int k = index.length() - 1; k >= 0; k--) {
                letter = index.charAt(k);
                secondSum[count] = letter;
                count++;

            }
            count = 0;
            if (Arrays.equals(firstSum, secondSum)) {
                printing = false;
            }
            if (!printing) {
                System.out.println("true");
                printing = true;
            }else {
                System.out.println("false");
            }
            index = scanner.nextLine();
        }

    }
}
