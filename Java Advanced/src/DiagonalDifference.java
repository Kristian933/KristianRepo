import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int r = 0; r < size; r++) {
            String[] input = scanner.nextLine().split(" ");
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = Integer.parseInt(input[c]);
            }
        }

        int primary = 0;
        int secondary = 0;

        for (int i = 0; i < size; i++) {
            primary += matrix[i][i];
        }
        for (int i = 0; i < size; i++) {
            secondary += matrix[i][size - 1 - i];
        }

        if (primary > secondary) {
            primary -= secondary;
            System.out.println(primary);
        } else {
            secondary -= primary;
            System.out.println(secondary);
        }

    }
}
