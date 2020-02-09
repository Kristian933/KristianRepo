import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < matrix.length; r++) {
            String[] input = scanner.nextLine().split(" ");
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = Integer.parseInt(input[c]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;

        for (int r = 1; r < matrix.length - 1; r++) {
            for (int c = 1; c < matrix[r].length - 1; c++) {
                int sum = getSum(matrix, r, c);
                if (sum > maxSum) {
                    maxSum = sum;
                    row = r;
                    col = c;
                }

            }
        }
        System.out.println("Sum = " + maxSum);

        row--;
        col--;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int getSum(int[][] matrix, int r, int c) {
        int sum = 0;
        r--;
        c--;

        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
