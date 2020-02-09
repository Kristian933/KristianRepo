import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f",division(factorial(firstNumber),factorial(secondNumber)));

    }

    static long factorial(int number) {
        long factorial = 1;
        int sum = 0;
        for (int i = 0; i < number; i++) {
            sum = (number - i);
            factorial *= sum;
        }
        return factorial;
    }

    static double division(long numberOne, long numberTwo) {
        double sum = numberOne * 1.0 / numberTwo;
        return sum;
    }

}
