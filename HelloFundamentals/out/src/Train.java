import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstLine = new int[n];
        int[] secondLine = new int[n];

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");

            int firstDigit = Integer.parseInt(line[0]);
            int secondDigit = Integer.parseInt(line[1]);

            if (i % 2 == 0) {
                firstLine[i] = firstDigit;
                secondLine[i] = secondDigit;
            } else {
                secondLine[i] = firstDigit;
                firstLine[i] = secondDigit;
            }
        }
        for (int i = 0; i < firstLine.length; i++) {
            System.out.print(firstLine[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < secondLine.length; i++) {
            System.out.print(secondLine[i] + " ");
        }
    }
}
