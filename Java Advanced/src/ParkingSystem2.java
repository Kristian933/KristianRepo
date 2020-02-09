import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(" ");

        int row = Integer.parseInt(matrixSize[0]);
        int col = Integer.parseInt(matrixSize[1]);

        int[][] matrix = new int[row][col];

        String input = scanner.nextLine();

        int counter = 0;
        boolean printed = false;

        while (!input.equals("stop")) {
            int[] tokens = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int entryRow = tokens[0];
            int rowX = tokens[1];
            int colY = tokens[2];

            int distance = Math.abs(rowX - entryRow);

            if (matrix[rowX][colY] < 1) {
                matrix[rowX][colY] = 1;
                counter += colY + 1;
            } else {
                if (matrix[rowX][colY - 1] < 1) {
                    matrix[rowX][colY - 1] = 1;
                    counter += colY;
                } else {
                    if (matrix[rowX][colY + 1] < 1) {
                        matrix[rowX][colY + 1] = 1;
                        counter += colY + 2;
                    } else {
                        System.out.printf("Row %d full", rowX);
                        printed = true;
                    }

                }

            }
            if (entryRow > rowX || entryRow < rowX) {
                counter += distance;
            }
            if (!printed) {
                System.out.println(counter);
            }

            counter = 0;
            input = scanner.nextLine();

        }


    }
}
