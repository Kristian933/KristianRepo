import java.util.Scanner;

public class TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int n = 1; n <= number; n++) {
            for (int j = 0 ; j < n ; j ++){
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }
}
