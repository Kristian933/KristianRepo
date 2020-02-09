import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int cols = Integer.parseInt(input[0]);
        int rows = Integer.parseInt(input[1]);
        char firstAndLast = 97;
        char middle = 97;

        String[][] matrix = new String[cols][rows];

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                matrix[col][row] = firstAndLast + "" + middle + "" + firstAndLast;
                middle++;
            }
            firstAndLast++;
            middle = firstAndLast;
        }

        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix[c].length; r++) {
                System.out.print(matrix[c][r] + " ");
            }
            System.out.println();
        }


    }
}
